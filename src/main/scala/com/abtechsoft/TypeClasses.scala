package com.abtechsoft

/**
  * Created by abdhesh on 08/05/17.
  */
object TypeClasses extends App {

  trait Show[A] {
    def show(a: A): String
  }

  object Show {
    def show[A](a: A)(implicit sh: Show[A]) = sh.show(a)

    //def show[A: Show](a: A) = implicitly[Show[A]].show(a)

    implicit val int2show = new Show[Int] {
      override def show(a: Int): String = s"int $a"
    }
  }

  //println(intCanShow.show(20))
  Show.show(12)

  object Show1 {

    //def show[A: Show](a: A) = Show1.apply[A].show(a)

    object ops {
      //def show[A: Show](a: A) = Show1[A].show(a)

      implicit class ShowOps[A: Show](a: A) {
        def show = Show1[A].show(a)
      }

    }

    def instance[A](func: A => String): Show[A] = new Show[A] {
      def show(a: A): String = func(a)
    }

    implicit val intCanShow: Show[Int] =
      instance(int => s"int $int")

    implicit val stringCanShow: Show[String] =
      instance(str => s"string $str")

    /*implicit val int2show = new Show[Int] {
      override def show(a: Int): String = s"int $a"
    }*/

    def apply[A](implicit sh: Show[A]): Show[A] = sh
  }

  import Show1.ops._

  println(30.show)
}
