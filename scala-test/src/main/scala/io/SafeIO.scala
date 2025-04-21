package io

import cats.effect.unsafe.implicits.global

object SafeIO {
  def main(args: Array[String]): Unit = {
    MyApp.run.unsafeRunAsync {
      case Left(e)  => println(s"Execution failed with: $e")
      case Right(_) => println("Execution completed successfully!")
    }
  }
}
