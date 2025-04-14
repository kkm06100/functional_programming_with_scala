package dsl.directstyle.statemachine

import dsl.directstyle.statemachine.status.{Event, State}

class StateMachineDSL(transitions: Map[(State, Event), State]) {
  def transition(current: State, event: Event): State =
    transitions.getOrElse((current, event), current)
}

object StateMachineDSL {
  def dsl(build: Builder => Unit): StateMachineDSL = {
    val builder = new Builder
    build(builder)
    new StateMachineDSL(builder.build())
  }

  class Builder {
    private var transitions = Map.empty[(State, Event), State]

    def state(s: State)(build: StateBuilder => Unit): Unit = {
      val sb = new StateBuilder(s)
      build(sb)
      transitions ++= sb.transitions
    }

    def build(): Map[(State, Event), State] = transitions
  }

  class StateBuilder(state: State) {
    var transitions = Map.empty[(State, Event), State]

    def on(event: Event): EventBuilder = new EventBuilder(state, event, this)

    class EventBuilder(s: State, e: Event, parent: StateBuilder) {
      def goTo(target: State): Unit = {
        parent.transitions += ((s, e) -> target)
      }
    }
  }
}
