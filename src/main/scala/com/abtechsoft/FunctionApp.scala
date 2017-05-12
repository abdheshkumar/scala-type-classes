package com.abtechsoft

/**
  * Created by abdhesh on 12/05/17.
  */
object FunctionApp {
  def ignoreBroken(x: Int, f: Int): Int = ???

  val a: (Int, Int) => Int = ignoreBroken _

  def ignore(x: Int, f: => Int): Int = ???

  val b: (Int, => Int) => Int = ignore _
  /*
  (Int, => Int) => Int is the same, but the second Int has to be a by-name parameter
  (=> Int, Int) => Int, or (=> Int, => Int) => Int`. It's just a way to talk about by-name parameters in functions
   */
}
