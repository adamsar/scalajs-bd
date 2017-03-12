package net.andrew.models.views

import diode.ModelRO
import net.andrew.models.game._
import net.andrew.styles.Global

import scalatags.JsDom.all._
import scalatags.jsdom.Frag

case class RootView(rootModel: ModelRO[GameState]) extends View {
  import Global.mdl

  def viewForPhase: GamePhase[_ <: Round] => View = {
    case _ => RootView(rootModel)
  }

  def renderHeader: Frag = {
    header(`class` := mdl.header,
      div(`class` := mdl.headerRow,
        span(`class` := mdl.title, "BLAZING DUEEEEEELS")))
  }

  def renderPullOut: Frag = {
    div(`class` := mdl.drawer,
      span(`class` := mdl.title, "Test"),
      tag("nav")(attr("class") := mdl.nav.container)("test"))
  }

  def renderContent: Frag = rootModel().round match {
    case Setup => div("setup")
    case PlayerRound(round) => div(round)
    case GameOver => div("game over")
  }

  override def render: Frag = {
    div(`class` := mdl.layout,
      renderHeader,
      renderPullOut,
      div(`class` := mdl.content,
        renderContent)
    )
  }

}
