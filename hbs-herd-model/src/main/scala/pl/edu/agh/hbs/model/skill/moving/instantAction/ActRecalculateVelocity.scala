package pl.edu.agh.hbs.model.skill.moving.instantAction

import pl.edu.agh.hbs.model.skill.Action
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity
import pl.edu.agh.hbs.model.skill.moving.modifier.ModMoveParameters
import pl.edu.agh.hbs.model.{ModifierBuffer, StepOutput}

object ActRecalculateVelocity extends Action {

  override def action(modifiers: ModifierBuffer): StepOutput = {
    var velocity = modifiers.getAll[ModVelocity].map(m => m.velocity).reduce((m, acc) => m + acc)
    val maxVelocity = modifiers.getFirst[ModMoveParameters].maxVelocity
    val minVelocity = modifiers.getFirst[ModMoveParameters].minVelocity

    //limiting the speed
    if (velocity.magnitude() > maxVelocity)
      velocity = velocity.unitVector() * maxVelocity
    if (velocity.magnitude() < minVelocity)
      velocity = velocity.unitVector() * minVelocity

    modifiers.update(ModVelocity(velocity, "standard"))
    new StepOutput()
  }
}
