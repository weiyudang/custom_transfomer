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
### 步骤
- 编写scala or java transform 并进行打包
- 通过python 进行包装  abs
-  修改SPARK_HOME 下的pyspark.zip的源码，将自定义的transform abs 添加到__all__

pyspark 是通过py4j的与jvm进行交流，jvm 相当与一个docker 容易，而要调用的java或者scala 程序
就相当于里面的子服务。
> pyspark 会初始化一个没有entry_point 的GateWayServer 只是将jvm 虚拟机
启动，但是所需要的服务或者class 文件都classpath中，将jar 添加到spark 环境变量中，在本地调试的
最好的方式是将jar 复制到$SPARK_HOME 下的jars 中进行调试。
```bash
spark-submit 
–driver-class-path to augment the driver classpath 
- spark.executor.extraClassPath to augment the executor classpath
```

```bash
spark-submit --master local    py4jDemo.py 
```


