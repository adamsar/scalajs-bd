package net.andrew.styles

import net.andrew.styles.Global.mdl

import scalacss.Defaults._

object Global extends StyleSheet.Standalone {
  import dsl._

  object mdl {

    def get(classNames: String*): String = {
      classNames map (c => s"-$c") mkString " "
    }


    val layout = get("layout", "js-layout", "layout--fixed-header")
    val header = get("layout__header")
    val headerRow = get("layout__header-row")

  }


}
