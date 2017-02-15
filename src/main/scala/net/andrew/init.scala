package net.andrew

import io.udash._
import io.udash.wrappers.jquery._
import org.scalajs.dom.{Element, document}

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object Context {
  implicit val executionContext = scalajs.concurrent.JSExecutionContext.Implicits.queue
  private val routingRegistry = new RoutingRegistryDef
  private val viewPresenterRegistry = new StatesToViewPresenterDef

  implicit val applicationInstance = new Application[RoutingState](routingRegistry, viewPresenterRegistry, RootState)
}

object Init extends JSApp with StrictLogging {
  import Context._

  private def renderStyles(appRoot: Element) = {
    import scalacss.Defaults._
    import scalacss.ScalatagsCss._
    import scalatags.JsDom._
    import net.andrew.styles.GlobalStyles
    import net.andrew.styles.DemoStyles
    import net.andrew.styles.partials.FooterStyles
    import net.andrew.styles.partials.HeaderStyles

    Seq(
      GlobalStyles,
      DemoStyles,
      FooterStyles,
      HeaderStyles
    ) foreach { style =>
      jQ(style.render[TypedTag[org.scalajs.dom.raw.HTMLStyleElement]].render).insertBefore(appRoot)
    }

  }

  @JSExport
  override def main(): Unit = {
    jQ(document).ready((_: Element) => {
      jQ("#application").get(0) match {
        case Some(appRoot) =>
          applicationInstance.run(appRoot)
          renderStyles(appRoot)

        case None =>
          logger.error("Application root element not found! Check your index.html file!")

      }
    })
  }
}