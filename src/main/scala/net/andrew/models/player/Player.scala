package net.andrew.models.player

import net.andrew.models.cards.PlayerDeck

case class Player(name: String, deck: PlayerDeck)

sealed trait AIOpponent extends Player
