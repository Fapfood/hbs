package pl.edu.agh.hbs.model.skill.flocking.modifier

import pl.edu.agh.hbs.model.skill.Modifier

case class ModAlignmentVelocityParameters(alignmentFactor: Double, maxDistance: Double) extends Modifier {
  override def copy(): Modifier = ModAlignmentVelocityParameters(alignmentFactor, maxDistance)
}
