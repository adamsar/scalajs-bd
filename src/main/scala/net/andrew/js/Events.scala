package net.andrew.js

import org.scalajs.dom._

object Events {

  case class EventType[A <: Event](eventName: String)
  
  object Blur extends EventType[FocusEvent]("blur")
  object Scroll extends EventType[FocusEvent]("scroll")

  object Mouse {
    object Click extends EventType[MouseEvent]("click")
    object ContextMenu extends EventType[MouseEvent]("contextmenu")
    object DoubleClick extends EventType[MouseEvent]("dblclick")
    object Enter extends EventType[MouseEvent]("mouseenter")
    object Leave extends EventType[MouseEvent]("mouseleave")
    object Down extends EventType[MouseEvent]("mousedown")
    object Up extends EventType[MouseEvent]("mouseup")
    object Over extends EventType[MouseEvent]("mouseover")
    object Out extends EventType[MouseEvent]("mouseout")
    object Move extends EventType[MouseEvent]("mousemove")
  }

  object Key {
    object Down extends EventType[KeyboardEvent]("keydown")
    object Press extends EventType[KeyboardEvent]("keypress")
    object Up extends EventType[KeyboardEvent]("keyup")
  }

  object Animation {
    object End extends EventType[AnimationEvent]("animationend")
    object Iteration extends EventType[AnimationEvent]("animationiteration")
    object Start extends EventType[AnimationEvent]("animationstart")
  }

  object Transition {
    object End extends EventType[TransitionEvent]("transitionend")
  }

  object Socket {
    object Error extends EventType[ErrorEvent]("error")
    object Message extends EventType[MessageEvent]("message")
    object Open extends EventType[raw.Event]("open")
    object Close extends EventType[raw.Event]("close")
  }

  object Ready extends EventType[raw.Event]("readystatechange")

}
