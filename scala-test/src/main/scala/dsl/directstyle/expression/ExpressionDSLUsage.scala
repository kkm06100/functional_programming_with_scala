package dsl.directstyle.expression

import ExpressionDSL._

object ExpressionDSLUsage {

  def main(array: Array[String]): Unit = {
    val expression = /(*($(10), $(20)), `-`($(10), $(5))) // similar to lisp...
    println(eval(expression))
  }
}
