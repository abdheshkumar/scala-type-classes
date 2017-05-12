package com.abtechsoft

/**
  * Created by abdhesh on 12/05/17.
  */
object CaseClassPlay extends App {

  case class example1(data: Array[Byte]) {

  }

  // works fine
  val e1 = example1(Array.empty)

  case class example2(sth: Int, data: Array[Byte]) {
    def this(data2: Array[Byte]) = this(1, data2)
  }

  // works fine
  val e2 = new example2(Array.empty)

  case class example3(sth: Int) {
    def this(data2: Array[Byte]) = this(2)

    def this(st: String, a: String) = this(1)
  }

  //val e3 = new example3("".toArray) why? it is failing.
}
