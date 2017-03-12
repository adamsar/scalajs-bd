package net.andrew.models.cards

import net.andrew.models.Tear

sealed trait CardType
case object Character extends CardType
case object Weapon extends CardType
case object Movement extends CardType
case object Healing extends CardType
case object Enhancement extends CardType

sealed abstract class Card(val cardType: CardType) {

  def name: String

}

trait Selectable extends Card {

  def selectCost: Tear

}

trait Usable extends Card {

  def useCost: Tear

}

case class CharacterCard(selectCost: Tear,  name: String) extends Card(Character) with Selectable

case class WeaponCard(selectCost: Tear, name: String) extends Card(Weapon) with Selectable

// Attacks
case class MovementCard(useCost: Tear, name: String) extends Card(Movement) with Usable

// Heals
case class HealingCard(useCost: Tear, name: String) extends Card(Healing) with Usable

// Buffs, debuffs, etc.
case class EnhancementCard(useCost: Tear, name: String) extends Card(Enhancement) with Usable
