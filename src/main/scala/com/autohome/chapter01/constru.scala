package  com.autohome.chapter01

import scala.beans.BeanProperty




object constru {


  def main(args: Array[String]): Unit = {

    val p=new Person1("wyd",12)

    val c=new Car("wyd")
    println(c.getName)

    println(c)

  }

}



class Person1 (val inname:String,val inage:Int){

   var name=inname
   var age=inage

}


class Car (@BeanProperty var name:String) {
  def info: Unit ={
    println(this.name)
  }


  override def toString: String = {
    "This car name "+this.name
  }
}


