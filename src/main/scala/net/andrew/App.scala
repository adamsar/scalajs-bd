package net.andrew

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom._
import scalatags.Text._
import org.scalajs.dom

@JSExport("SimpleApp")
object App extends JSApp {

  @JSExport
  override def main(): Unit = {
    dom.document.onload = (event) => {

    }
  }

}
