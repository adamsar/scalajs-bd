package net.andrew.models.views

import diode.ModelRO
import net.andrew.models.game.{GamePhase, GameState, Round}

import scalatags.JsDom.all._
import scalatags.jsdom.Frag

case class RootView(rootModel: ModelRO[GameState]) extends View {

  def viewForPhase: GamePhase[_ <: Round] => View = {
    case _ => RootView(rootModel)
  }

  /**
    *
    * @return
    */
  override def render: Frag = {
    div(`class` := "container")(
      "test this"
    )
  }

}
