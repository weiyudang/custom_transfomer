package org.apache.spark.ml.feature

import scala.collection.mutable.ArrayBuilder

import org.apache.spark.annotation.Since
import org.apache.spark.ml.Transformer
import org.apache.spark.ml.attribute.BinaryAttribute
import org.apache.spark.ml.linalg._
import org.apache.spark.ml.param._
import org.apache.spark.ml.param.shared.{HasInputCol, HasOutputCol}
import org.apache.spark.ml.util._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._




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


object Abs extends  DefaultParamsReadable[Abs]{
  override def load(path: String): Abs = super.load(path)
}
