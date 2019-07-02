package com.autohome.chapter01

object mllazy {


  def main(args: Array[String]): Unit = {


    lazy val res=sum1(2,3)

    println("------")

    println("res  "+res)
    val a=new Cee with  Demo


    val ss=new Animal with  Demo {
      override var name: String = "wyd"
      override var age: Int = 12

      def cry(): Unit = {
        println("fuck")
      }
    }

    ss.cry()
    ss.info()
    ss.info1()
    a.info1()
    val aa1= (1 to 100).par.map(_=>Thread.currentThread.getName).distinct

    aa1.foreach(println)

  }


  def sum1(x:Int,y:Int): Int ={
    println("sum1 执行")
    x+y
  }
}



class Cee{
  private[chapter01]  var name="weiyudag"
}


abstract class  Animal{
  var name:String
  var age:Int
  var color:String="red"

  def cry()

  def info()={
    println("wyd")
  }

}


trait Demo {
  def info1()={
    println("trait ····")
  }
}