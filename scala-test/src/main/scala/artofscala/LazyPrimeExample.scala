package artofscala

object LazyPrimeExample {
  val naturals: LazyList[Int] = LazyList.from(2)

  def sieve(s: LazyList[Int]): LazyList[Int] =
    s.head #:: sieve(s.tail.filter(_ % s.head != 0))

  val primes: LazyList[Int] = sieve(naturals)

  def main(args: Array[String]): Unit = {
    println(naturals)

    println(naturals.take(30).toList)
    println(primes.take(30).toList)
  }
}
