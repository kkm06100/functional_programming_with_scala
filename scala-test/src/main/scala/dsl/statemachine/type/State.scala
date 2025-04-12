package dsl.statemachine.`type`

sealed trait State
case object Pending extends State
case object Approved extends State
case object Rejected extends State
