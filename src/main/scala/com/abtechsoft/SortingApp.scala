package com.abtechsoft

/**
  * Created by abdhesh on 11/05/17.
  */
object SortingApp {
  def sort[A: Ordering](l: List[A]): List[A] = l match {
    case Nil => Nil
    case a :: as =>
      val (before, after) = as.partition(x => implicitly[Ordering[A]].lt(x, a))

      sort(before) ++ (a :: sort(after))
  }
}
