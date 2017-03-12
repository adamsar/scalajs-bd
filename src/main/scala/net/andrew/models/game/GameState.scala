package net.andrew.models.game

import net.andrew.models.player.Player

case class GameState(currentPhase: GamePhase[_ <: Round], players: Seq[Player], round: Round)

