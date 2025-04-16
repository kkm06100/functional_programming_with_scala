package dsl.freemonad.console

import cats.Functor
import dsl.freemonad.console.adt.{ConsoleOp, PrintLine, ReadLine}

object ConsoleOpInstances {
  implicit val consoleOpFunctor: Functor[ConsoleOp] = new Functor[ConsoleOp] {
    def map[A, B](fa: ConsoleOp[A])(f: A => B): ConsoleOp[B] = fa match {
      case ReadLine(prompt) => ReadLine(prompt).asInstanceOf[ConsoleOp[B]]
      case PrintLine(msg)   => PrintLine(msg).asInstanceOf[ConsoleOp[B]]
    }
  }
}
