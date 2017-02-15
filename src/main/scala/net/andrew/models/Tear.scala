package net.andrew.models

case class Tear(amount: Int) extends AnyVal {
  require(amount >= 0, "To choose the card can not give tears to player")
}
