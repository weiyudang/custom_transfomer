## 自定义spark transform 
主要文件是abs.scala
```
class Abs (override val uid:String) extends
  Transformer with HasInputCol with HasOutputCol with DefaultParamsWritable {


  def this()=this(Identifiable.randomUID("Abs"))


  def setInputCol(value: String): this.type = set(inputCol, value)


  def setOutputCol(value: String): this.type = set(outputCol, value)


  override def transform(dataset: Dataset[_]): DataFrame = {
    val to_abs=udf{in:Double => if (in>0.0) in else -in}

    val outputSchema=transformSchema(dataset.schema,logging = true)
    val schema=dataset.schema
    val inputType=schema($(inputCol)).dataType
    val metadata = outputSchema($(outputCol)).metadata
    dataset.select(col("*"),to_abs(col($(inputCol))).as($(outputCol),metadata))
  }

  override def copy(extra: ParamMap): Abs = defaultCopy(extra)

  override def transformSchema(schema: StructType): StructType ={
    val inputType=schema($(inputCol)).dataType
    val outputColName=$(outputCol)

    val outCol:StructField=StructField(outputColName,inputType)

    StructType(schema:+outCol)
  }

}
```
仿照HashTF 进行改写
主要目的是通过scala 自定义 transform 通过py4j 进行包装，通过pyspark
进行调用

