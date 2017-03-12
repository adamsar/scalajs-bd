package net.andrew.models.views

import scalatags.jsdom.Frag

trait View {

  def render: Frag

}
