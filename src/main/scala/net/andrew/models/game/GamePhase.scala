package net.andrew.models.game

import net.andrew.models.player.Player

import scalaz.@@

trait Winner {}

sealed trait GamePhase[A <: Round]

trait Animation[A <: Round] extends GamePhase[A]
case object Start extends Animation[Setup.type]
case object DamagePhase extends Animation[PlayerRound]
case object RoundInterlude extends Animation[PlayerRound]

case object PlayerSetup extends GamePhase[Setup.type ]

case class PlayerTurn(player: Player) extends GamePhase[PlayerRound]

case class PlayerWins(winner: Player @@ Winner) extends GamePhase[GameOver.type]


