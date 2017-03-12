package net.andrew.models.player

import net.andrew.models.cards.{CurrentHand, DiscardPile, DrawDeck}

case class GamePlayer[A <: Player](player: A, currentHand: CurrentHand, discardPile: DiscardPile, drawDeck: DrawDeck)
