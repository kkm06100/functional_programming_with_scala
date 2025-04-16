package dsl.freemonad.console

import cats.effect.{IO, IOApp}
import cats.~>
import dsl.freemonad.console.ConsoleDSL.{ConsoleProgram, printLine, readLine}
import dsl.freemonad.console.adt.{ConsoleOp, PrintLine, ReadLine}

object ConsoleDSLUsage extends IOApp.Simple {
  private val program: ConsoleProgram[Unit] = for {
    name <- readLine("이름을 입력하세요:")
    _    <- printLine(s"안녕하세요, $name 님!")
  } yield ()

  private val interpreter = new (ConsoleOp ~> IO) {
    def apply[A](fa: ConsoleOp[A]): IO[A] = fa match {
      case ReadLine(prompt) =>
        IO.print(prompt) *> IO.readLine
      case PrintLine(msg) =>
        IO.println(msg)
    }
  }

  def run: IO[Unit] =
    program.foldMap(interpreter)
}
