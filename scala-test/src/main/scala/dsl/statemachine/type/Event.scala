package dsl.statemachine.`type`

sealed trait Event
case object Approve extends Event
case object Reject extends Event
case object Reset extends Event
