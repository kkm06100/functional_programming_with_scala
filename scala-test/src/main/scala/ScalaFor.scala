import java.text.DateFormat.{LONG, getDateInstance}
import java.util.{Date, Locale}

object ScalaFor {

  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    val list: List[Int] = List(13, 4, 5, 5, 4, 4, 7, 8, 3)
    println(df format now)

    // ...?
    val value:Int = 1.*(10)
    println(value)

    // for (to)
    // 1 ~ 5
    for(i <- 1 to 5) {
      println(i)
    }

    // for (until)
    // 1 ~ 4
    for(i <- 1 until 5) {
      println(i)
    }

    // 중첩 for
    for {
      i <- 1 to 3
      j <- 1 to 2
    } println("hello" + i + j)

    // cartesian product
    val list2: List[Int] = for {
      a <- List(1, 2, 3, 4)
      b <- List(1, 2, 3, 4)
    } yield a * 10 + b

    println(list2)

    // for (value <- list) println(value)
  }
}
