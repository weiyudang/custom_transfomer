package com.autohome.chapter01

object detail03 {

  def main(args: Array[String]): Unit = {


    def f1():Unit={//  private final
      print("f1")
    }


    def sayOk(): Unit ={ //priavte final sayOk$1
      println("say Ok")
      def sayOk():Unit={ //private final sayOk$2
        println("main sayOK")
      }


    }


    println("ok ~~~")
    info("wangjiaqi")

    var name="weiyduang"
    println(name + "hello")


    println(sums(1,2,5,6,7))

    test()


  }


  def sums(args:Int*): Int ={
    var su=0
    for(i<-args){
      su+=i
    }
    su
  }

  def sayOk()={
    println("main sayOK")
  }


  def info(name:String="weiyudang"): Unit ={
    println(name+" come on")
//    name + "hello"
  }


  def test()={
    println("sss")
  }

}
