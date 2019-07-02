package com.autohome.chapter01

object func {
  def main(args: Array[String]): Unit = {

    var a=20
    var b=21
    println(adds(a,b))
    val name:String="dd"

    val wyd= new Person("weiyduang",17,"man")
    wyd.printsome()
    info()
    log
    test(4)

    println(mul(20,12))

    println(name)




  }

  def adds(x:Int,y:Int):Int={
    x+y
  }

  def info()={
    println("fuck you !!")
  }

  def log: Unit ={
    print("This is log\n")
  }

  def mul(x:Int,y:Int):Int={
    return x*y
  }


  def test(n:Int){

    if (n>2){
      test(n-1)
    }

    println("n+:",n)

  }



}





