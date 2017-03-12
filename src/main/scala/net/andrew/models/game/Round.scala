package net.andrew.models.game

sealed trait Round {}

case object Setup extends Round {}

case class PlayerRound(round: Int) extends Round {}

case object GameOver extends Round {}
