/**
  * Created by abdhesh on 01/06/17.
  */
object Test {

  // write this once
  trait F[In] {
    type Out

    def apply(i: In): Out
  }

  object F {
    type Aux[I, O] = F[I] {type Out = O}

    def instance[I, O](f: I => O): F.Aux[I, O] = new F[I] {
      type Out = O

      def apply(i: I): Out = f(i)
    }
  }

  def method[I](i: I)(implicit ev: F[I]): ev.Out = ev(i)

  //  Random example: A contains Ints, and _method_ will sum the ints and check
  //  if they are greater than 10
  case class A(x: Int, y: Int)

  object A {
    implicit def fOfA: F.Aux[A, Boolean] =
      F.instance(a => (a.x + a.y) > 10)
  }

  // Random example: B contains String, and method concatenates the
  //String and return their lenght
  case class B(s1: String, s2: String)

  object B {
    implicit def fOfB: F.Aux[B, Int] =
      F.instance(b => (b.s1 + b.s2).length)
  }

  def forAs = method(A(3, 4))

  // forAs: Boolean = false

  def forBs = method(B("hello", "world"))

  // forBs: Int = 10
}