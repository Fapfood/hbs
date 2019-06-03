package pl.edu.agh.hbs.model.skill.flocking.modifier

import pl.edu.agh.hbs.model.skill.Modifier

//school will disperse if cohesionFactor is negative
case class ModCohesionVelocityParameters(cohesionFactor: Double, maxDistance: Double) extends Modifier {
  override def copy(): Modifier = ModCohesionVelocityParameters(cohesionFactor, maxDistance)
}
