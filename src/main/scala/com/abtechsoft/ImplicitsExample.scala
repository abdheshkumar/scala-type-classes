package com.abtechsoft

/**
  * Created by abdhesh on 21/03/17.
  */
object ImplicitsExample extends App {

  trait CanFoo[A] {
    def foos(x: A): String
  }

  object CanFoo {
    def apply[A: CanFoo]: CanFoo[A] = implicitly
  }


  case class Wrapper(wrapped: String)

  implicit object WrapperCanFoo extends CanFoo[Wrapper] {
    def foos(x: Wrapper) = x.wrapped
  }

  def foo[A: CanFoo](thing: A) = CanFoo[A].foos(thing)

  foo(Wrapper("hi"))
}
