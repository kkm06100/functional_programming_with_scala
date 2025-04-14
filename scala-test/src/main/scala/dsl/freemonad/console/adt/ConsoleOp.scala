package dsl.freemonad.console.adt

sealed trait ConsoleOp[A]
case class ReadLine(prompt: String) extends ConsoleOp[String]
case class PrintLine(msg: String) extends ConsoleOp[Unit]
