package com.autohome.chapter01

import org.apache.spark.ml.feature.Abs
import py4j.GatewayServer


object  AbsDemo {
  def main(args: Array[String]): Unit = {
    val gateway=new GatewayServer(new Abs());
    gateway.start()
    println("系统开始运行")

  }
}

