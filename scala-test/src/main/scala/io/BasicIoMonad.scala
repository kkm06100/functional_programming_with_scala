package io

import cats.effect.IO
import cats.effect.unsafe.implicits.global

object BasicIoMonad {

  def main(args: Array[String]): Unit = {
    val program: IO[Unit] = for {
      name <- IO.readLine
      _    <- IO.println(s"Hello $name")
    } yield ()

    program.unsafeRunSync()
  }
}
