package dsl.freemonad.console

import cats.free.Free
import dsl.freemonad.console.adt._

object ConsoleDSL {
  type ConsoleProgram[A] = Free[ConsoleOp, A]

  def readLine(prompt: String): ConsoleProgram[String] =
    Free.liftF(ReadLine(prompt))

  def printLine(msg: String): ConsoleProgram[Unit] =
    Free.liftF(PrintLine(msg))
}
