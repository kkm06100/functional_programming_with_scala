import scala.::

object ScalaFunc {
  def main(args:Array[String]): Unit = {
    // default
    def fun: (Int, Int) => Int = (x, y) => x * y
    println(fun(10, 20))

    // currying
    def fun1(x: Int)(y:Int): Int = x + y
    def fun2: Int => Int = fun1(10)
    println(fun2(20))

    def cover(x:Int): List[Int] = List(x) // List.apply(x)

    println(List(1, 2, 3, 4) map(x => cover(x))) // functor
    println(List(1, 2, 3, 4) flatMap(x => cover(x))) // monad

    def echo(args: String*):Unit = for {
      a <- args
      b <- 0 to 10
    } println(a * b)

    echo("Hello", "Scala", "Functional", "Programming")

    val list = List(6,7,8,9).::(5)
    val list2 = list.:::(List(1, 2, 3, 4))
    println(list2)
    val list3 = list2 ++ List(10, 11, 12)
    println(list3)
  }
}
