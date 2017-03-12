package net.andrew.circuits

import diode.Circuit
import net.andrew.models.game.{GameState, Setup, Start}

object RootCircuit extends Circuit[GameState] {

  override protected def initialModel: GameState = GameState(Start, Nil, Setup)

  override protected def actionHandler: RootCircuit.HandlerFunction =
    (model, action) => action match {
      case _ => None
    }
}
