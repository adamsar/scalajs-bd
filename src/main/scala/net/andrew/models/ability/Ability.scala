package net.andrew.models.ability

//import net.andrew.models.ability._

// Card effect
sealed trait Effect[A <: AffectTarget] {

  def sideEffects: Seq[Effect[_]] = Nil

}

trait SelfHeal extends Effect[User.type]
trait SingleAttack extends Effect[SinglePlayer]
trait MultiAttack extends Effect[Players]
