package artofscala.util

object PerformanceChecker {

  def getPerformance[A, B](f: A => B)(post: (B, Long) => Unit): A => Unit =
    arg => {
      val start = System.currentTimeMillis()
      val result = f(arg)
      val end = System.currentTimeMillis()
      post(result, end - start)
    }

  def out(result: BigInt, time: Long):Unit = {
    println(result + "(" +time + "ms)")
  }
}
