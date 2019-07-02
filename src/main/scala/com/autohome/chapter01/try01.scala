package com.autohome.chapter01

object try01 {

  def main(args: Array[String]): Unit = {

//    val res=test()
//    println(res.toString())

    try{
      test()
    }catch {
      case ex:Exception=>println(ex.getMessage())
    }finally {
      println("程序结束")
    }

    println("ok~~~")


//    f11()

    var  name:String = "www"

    name="weiyudang"
    println(name)

  }



  def test():Nothing={
    throw new Exception("No1异常出现")
  }

  @throws(classOf[NumberFormatException])//等同于 NumberFormatException.class
  def f11() = {
  "abc".toInt }


}

