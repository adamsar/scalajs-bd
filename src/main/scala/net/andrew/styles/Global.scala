package net.andrew.styles

import net.andrew.styles.Global.mdl

import scalacss.Defaults._

object Global extends StyleSheet.Standalone {
  import dsl._

  "body" - (
    margin(0 px),
    padding(0 px)
  )

  object mdl {

    def get(classNames: String*): String = {
      classNames map (c => s"mdl-$c") mkString " "
    }


    val layout = get("layout", "js-layout", "layout--fixed-header")
    val header = get("layout__header")
    val headerRow = get("layout__header-row")
    val title = get("layout-title")
    val spacer = get("layout-spacer")
    val drawer = get("layout__drawer")
    val content = get("layout__content")

    object nav {

      def get(className: String): String = {
        mdl.get(s"navigation$className")
      }

      val container = get("")
      val link = get("__link")

    }

  }


}
