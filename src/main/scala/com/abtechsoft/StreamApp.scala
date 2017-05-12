package com.abtechsoft

/**
  * Created by abdhesh on 12/05/17.
  */
object StreamApp extends App {

  sealed trait Stream[+A] {

    def toList: List[A] = {
      @annotation.tailrec
      def go(s: Stream[A], acc: List[A]): List[A] = s match {
        case Cons(h, t) => go(t(), h() :: acc)
        case _ => acc
      }

      go(this, List()).reverse
    }

    def foldRight[B](z: => B)(f: (A, => B) => B): B =
      this match {
        case Cons(h, t) => f(h(), t().foldRight(z)(f))
        case _ => z
      }

    def map[B](f: A => B): Stream[B] =
      this.foldRight(Stream.empty[B])((x, y) => Stream.cons(f(x), y))

    def filter(f: A => Boolean): Stream[A] =
      this.foldRight(Stream.empty[A])((h, t) => if (f(h)) Stream.cons(h, t) else t)

  }

  case object Empty extends Stream[Nothing]

  case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]


  object Stream {

    def cons[A](hd: => A, t1: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = t1

      Cons(() => head, () => tail)
    }

    def empty[A]: Stream[A] = Empty

    def apply[A](as: A*): Stream[A] =
      if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))

  }

  Stream(1, 2, 3, 4).map((x) => {
    println(x)
    x + 10
  })
  /*.filter((x) => {
        println(x)
        x % 2 == 0
      }).toList*/

}
