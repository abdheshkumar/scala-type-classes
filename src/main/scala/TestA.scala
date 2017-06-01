import java.awt.Color

/**
  * Created by abdhesh on 19/05/17.
  */
object TestA extends App {

  abstract class A[T <: A[T]] {
    def rename(a: String): T
  }

  case class B(b: String) extends A[B] {
    override def rename(a: String): B = this.copy(b = s"${this.b} $a")
  }

  def esquire[T <: A[T]](a: T): T = a.rename("works")

  println(esquire(B("Test")))
}
