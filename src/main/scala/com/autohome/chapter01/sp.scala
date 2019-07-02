package com.autohome.chapter01


import org.apache.spark.sql.SparkSession


object sp {


  def main(args: Array[String]): Unit = {
    val sqlContext = new SparkSession.Builder().master("local").appName("test").getOrCreate()

    sqlContext.read.csv("")

  }

}
