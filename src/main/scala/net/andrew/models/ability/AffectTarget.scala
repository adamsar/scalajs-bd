package net.andrew.models.ability

import net.andrew.models.player.Player

sealed trait AffectTarget

case object User extends AffectTarget
case class SinglePlayer(player: Player) extends AffectTarget
case class Players(players: Seq[Player]) extends AffectTarget
