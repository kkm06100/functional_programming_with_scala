package dsl.expression.status

sealed trait Expression
case class Number(value: Int) extends Expression
case class Add(a: Expression, b: Expression) extends Expression
case class Subtraction(a: Expression, b: Expression) extends Expression
case class Multiply(a: Expression, b: Expression) extends Expression
case class Divide(a: Expression, b: Expression) extends Expression
