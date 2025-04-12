package dsl.directstyle.statemachine

import dsl.directstyle.statemachine.status.{Approve, Approved, Pending, Reject, Rejected}

object StateMachineDSLUsage {
  def main(array: Array[String]): Unit = {

    val sm = StateMachineDSL.dsl {
      _.state(Pending) { state =>
        state on Approve goTo Approved
        state on Reject goTo Rejected
      }
    }

    println(sm transition(Pending, Approve))
    println(sm transition(Pending, Reject))
  }
}
