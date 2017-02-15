package net.andrew.models

sealed trait CardType
case object Character extends CardType
case object Weapon extends CardType
case object Movement extends CardType
case object Healing extends CardType
case object Enhancement extends CardType

sealed abstract class Card(val cardType: CardType) {

  def name: String
  def cost: Tear

}

case class CharacterCard(cost: Tear, name: String, abilities: Seq[Ability]) extends Card(Character)

case class WeaponCard(cost: Tear, name: String) extends Card(Weapon)

case class MovementCard(cost: Tear, name: String) extends Card(Movement)

case class HealingCard(cost: Tear, name: String) extends Card(Healing)

case class EnhancementCard(cost: Tear, name: String) extends Card(Enhancement)

