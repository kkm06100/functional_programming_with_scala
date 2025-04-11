object ScalaUnderscore {
  def main(args:Array[String]): Unit = {

    /**
     * Placeholder Syntax
     */
    val list = List(1, 2, 3)
    val double = list.map(_ * 2) // == list.map(number => number * 2)
    println(double)

    /**
     * Partially Applied Function
     */
    def multiply(a: Int, b: Int): Int = a * b;
    val timesTwo = multiply(_:Int, 2)
    timesTwo(3) // 6

    /**
     * Wildcard Of Match
     */
    def respond(fruit: String): String = fruit match {
      case "apple" => "is an apple"
      case "pineapple" => "is a pineapple"
      case _ => "is another fruit"
    }

    println(respond("apple"))
    println(respond("cherry"))

    /**
     * Ignore Values
     */
    val (name, _, age) = ("kim kyung min", "hello!!", 18) // ignore "hello!!"

    /**
     * Wildcard Type
     */
    val mixed: List[_] = List(1, "hello", true)

    /**
     * Unused Binding
     */
    val _ = println("Unused Binding")
  }
}
