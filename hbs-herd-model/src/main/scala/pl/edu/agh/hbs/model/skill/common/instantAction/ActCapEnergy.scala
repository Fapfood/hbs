package pl.edu.agh.hbs.model.skill.common.instantAction

import pl.edu.agh.hbs.model.skill.Action
import pl.edu.agh.hbs.model.skill.common.modifier.ModEnergy
import pl.edu.agh.hbs.model.{ModifierBuffer, StepOutput}

object ActCapEnergy extends Action {

  override def action(modifiers: ModifierBuffer): StepOutput = {
    val energy = modifiers.getFirst[ModEnergy]("standard").energy
    val maxEnergy = modifiers.getFirst[ModEnergy]("max").energy
    if (energy > maxEnergy)
      modifiers.update(ModEnergy(maxEnergy, "standard"))
    new StepOutput()
  }
}
