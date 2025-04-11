package artofscala

object MemoizationExample {

  private def memoFix[A, B](f: (A => B) => A => B): A => B = {
    val cache = scala.collection.mutable.Map.empty[A, B]
    lazy val memo: A => B = a => cache.getOrElseUpdate(a, f(memo)(a))
    memo
  }

  private val memoizedFib: Int => BigInt = memoFix[Int, BigInt] { self => {
      case n if n <= 1 => BigInt(n)
      case n => self(n - 1) + self(n - 2)
    }
  }

  private def normalFib(value: Int): BigInt = value match{
    case _ if value <= 1 => value
    case _ => normalFib(value - 1) + normalFib(value - 2)
  }

  private def getPerformance[A, B](f: A => B)(post: (B, Long) => Unit): A => Unit =
    arg => {
      val start = System.currentTimeMillis()
      val result = f(arg)
      val end = System.currentTimeMillis()
      post(result, end - start)
    }

  private def out(result: BigInt, time: Long):Unit = {
    println(result + "(" +time + "ms)")
  }

  def main(args: Array[String]): Unit = {
    val normal: Int => Unit = getPerformance(normalFib)(out)
    val memoization: Int => Unit = getPerformance(memoizedFib)(out)

    memoization(500)
    memoization(500)
  }
}
