package com.abtechsoft

/**
  * Created by abdhesh on 21/03/17.
  */
trait CanFoo[A] {
  def foos(x: A): String
}

case class Wrapper(wrapped: String)

object WrapperCanFoo extends CanFoo[Wrapper] {
  def foos(x: Wrapper) = x.wrapped
}

object WrapperExample extends App {

  implicit object WrapperCanFoo extends CanFoo[Wrapper] {
    def foos(x: Wrapper) = x.wrapped
  }

  def foo[A](thing: A)(implicit evidence: CanFoo[A]) = evidence.foos(thing)

  def foo1[A: CanFoo](thing: A) = implicitly[CanFoo[A]].foos(thing)

  foo(Wrapper("hi"))
}
