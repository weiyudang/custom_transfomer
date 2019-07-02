package com.autohome.chapter01

import java.util.UUID

import org.apache.spark.ml.feature.Binarizer
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._
import org.apache.spark.ml.feature.Abs

import   org.apache.spark.ml.{Pipeline,PipelineModel}




object test12 {

  def main(args: Array[String]): Unit = {



    val arr = Array(1,23,4)


    val uuid=UUID.randomUUID().toString
    println(uuid)

    require(2>1)


    val  name="weiyudang"


    println(s"$name")


    val data=Array((0,0.1),(1,0.8),(2,-0.2),(3,-10.0))

    val spark=SparkSession.builder().master("local").getOrCreate()

    val df=spark.createDataFrame(data).toDF("id","feature")




    val abss=new Abs().setInputCol("feature").setOutputCol("abs_feature")

    val binarizer:Binarizer=new Binarizer().setInputCol("feature").setOutputCol("binaray_feature")
      .setThreshold(0.3)

    val binarizerdf=binarizer.transform(df)


    val abs_df=abss.transform(df)


    val pip =new Pipeline().setStages(Array(abss,binarizer))

    val model=pip.fit(df)
    val pipdf=model.transform(df)

    pipdf.show()



    model.write.overwrite().save("./test.model")


    val pipmodel=PipelineModel.load("./test.model")

    println("load model ")

    pipmodel.transform(df).show()




    println("---"*10)
    abs_df.show()


    df.show()

    binarizerdf.show()

    val sf=new StructField("name",StringType)

    println(sf.dataType,sf.name,sf.metadata)


    val  struct =StructType(List(
      StructField("name",StringType),
      StructField("age",IntegerType)
    ))


    println(struct("name"))
    StructType(struct.fields:+ StructField("a",StringType))
















  }

}
