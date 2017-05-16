package com.abtechsoft

/**
  * Created by abdhesh on 16/05/17.
  */

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

object Debug {

  def debug(s: Any): Unit = macro debugImpl

  def hello(): Unit = macro hello_impl

  def debugImpl(c: blackbox.Context)
               (s: c.Expr[Any]): c.Expr[Unit] = {
    import c.universe._

    val paramRep = show(s.tree)

    c.Expr(q"""println($paramRep + " = " + $s)""")
  }

  def hello_impl(c: blackbox.Context)(): c.Expr[Unit] = {
    import c.universe._
    reify {
      println("Hello World!")
    }
  }
}

