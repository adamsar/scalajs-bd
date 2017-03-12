package net.andrew

import diode.ModelRO
import net.andrew.circuits.RootCircuit
import net.andrew.models.game.GameState
import net.andrew.models.views.RootView
import net.andrew.styles.Global


import scalatags.Text._
import scalatags.Text.all._
import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom
import scalacss.ScalatagsCss._
import scalacss.Defaults._
import scalatags.JsDom.TypedTag
import org.scalajs.dom.raw.HTMLStyleElement


@JSExport("App")
object App extends JSApp {

  @JSExport
  override def main(): Unit = {
    import scalatags.JsDom.all._
    val root = dom.document.getElementById("root")
    val rootModel = RootCircuit.zoom(identity)
    RootCircuit.subscribe(rootModel)(model => render(root, model))
    renderStyles()
    render(root, rootModel)
  }

  def renderStyles(): Unit = {
    dom.document.head.appendChild(Global.render[TypedTag[HTMLStyleElement]].render)
  }

  def render(root: dom.Element, rootModel: ModelRO[GameState]): Unit =  {
    root.appendChild(RootView(rootModel).render.render)
  }

}
