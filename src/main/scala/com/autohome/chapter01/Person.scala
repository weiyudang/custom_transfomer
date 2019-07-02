package com.autohome.chapter01

class Person(var name:String,var age:Int,val sex:String) {



  def printsome(): Unit ={
    println(this.name,this.age)
  }

}
