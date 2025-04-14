package dsl.directstyle.expression

import dsl.directstyle.expression.status.{Add, Divide, Subtraction, Expression, Multiply, Number}

object ExpressionDSL {

  def $(n: Int): Expression = Number(n)
  def +(a: Expression, b: Expression): Expression = Add(a, b)
  def -(a: Expression, b: Expression): Expression = Subtraction(a, b)
  def *(a: Expression, b: Expression): Expression = Multiply(a, b)
  def /(a: Expression, b: Expression): Expression = Divide(a, b)

  def eval(expression: Expression): Int = expression match{
    case Number(v) => v
    case Add(l, r)   => eval(l) + eval(r)
    case Subtraction(l, r) => eval(l) - eval(r)
    case Multiply(l, r) => eval(l) * eval(r)
    case Divide(l, r) => eval(l) / eval(r)
  }
}
