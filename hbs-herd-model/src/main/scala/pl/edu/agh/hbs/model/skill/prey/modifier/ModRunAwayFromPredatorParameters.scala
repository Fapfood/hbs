package pl.edu.agh.hbs.model.skill.prey.modifier

import pl.edu.agh.hbs.model.skill.Modifier

case class ModRunAwayFromPredatorParameters(predatorFactor: Double, maxDistance: Double) extends Modifier {
  override def copy(): Modifier = ModRunAwayFromPredatorParameters(predatorFactor, maxDistance)
}
