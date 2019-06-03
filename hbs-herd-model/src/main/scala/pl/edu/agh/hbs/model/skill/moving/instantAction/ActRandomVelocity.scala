package pl.edu.agh.hbs.model.skill.moving.instantAction

import pl.edu.agh.hbs.model.skill.Action
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity
import pl.edu.agh.hbs.model.{ModifierBuffer, StepOutput, Vector}

import scala.util.Random

object ActRandomVelocity extends Action {

  override def action(modifiers: ModifierBuffer): StepOutput = {
    val rand = new Random()
    val oldVelocity = modifiers.getFirst[ModVelocity]("random").velocity
    val velocity = oldVelocity + Vector((rand.nextDouble() - 0.5) / 2, (rand.nextDouble() - 0.5) / 2)
    modifiers.update(ModVelocity(velocity, "random"))
    new StepOutput()
  }
}
