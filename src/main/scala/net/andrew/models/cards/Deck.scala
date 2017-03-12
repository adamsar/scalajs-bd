package net.andrew.models.cards

import scala.util.Random
import scalaz._
import scalaz.syntax.either._
import scalaz.syntax.std.boolean._
import scalaz.syntax.std.option._


trait Deck[A <: Deck[A]] {

  val cards: Seq[Card]

  protected def addCard(card: Card): A

  protected def removeCard(card: Card): A

  def canInsert(card: Card): Option[String] = {
    cards.contains(card).option("$card already in deck")
  }

  def :+(card: Card): String \/ A  = {
    canInsert(card).map(_.left[A]) | addCard(card).right[String]
  }

  def :-(card: Card): A = removeCard(card)

  def draw(number: Int = 1): String \/ (Card, Deck[A]) = {
    Random.shuffle(cards)
          .headOption
          .map(card => (card, removeCard(card)).right[String])
          .getOrElse("No cards left!".left[(Card, Deck[A])])
  }

}

case class PlayerDeck(cards: Seq[Card]) extends Deck[PlayerDeck] {

  override protected def addCard(card: Card): PlayerDeck = copy(cards = cards :+ card)

  override protected def removeCard(card: Card): PlayerDeck = copy(cards = cards diff Seq(card))

}

case class CurrentHand(cards: Seq[Card]) extends Deck[CurrentHand] {

  override protected def addCard(card: Card): CurrentHand = copy(cards = cards :+ card)

  override protected def removeCard(card: Card): CurrentHand = copy(cards = cards diff Seq(card))

}

case class DiscardPile(cards: Seq[Card]) extends Deck[DiscardPile] {

  override protected def addCard(card: Card): DiscardPile = copy(cards = cards :+ card)

  override protected def removeCard(card: Card): DiscardPile = copy(cards = cards diff Seq(card))

}

case class DrawDeck(cards: Seq[Card]) extends Deck[DrawDeck] {

  override protected def addCard(card: Card): DrawDeck = copy(cards = cards :+ card)

  override protected def removeCard(card: Card): DrawDeck = copy(cards = cards diff Seq(card))

}