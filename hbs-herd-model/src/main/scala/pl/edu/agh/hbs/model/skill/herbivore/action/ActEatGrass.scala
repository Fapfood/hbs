package pl.edu.agh.hbs.model.skill.herbivore.action

import pl.edu.agh.hbs.model.skill.Action
import pl.edu.agh.hbs.model.skill.basic.modifier._
import pl.edu.agh.hbs.model.skill.common.modifier.ModEnergy
import pl.edu.agh.hbs.model.skill.diPatch.modifier.ModTerrain
import pl.edu.agh.hbs.model.{ModifierBuffer, StepOutput}
import pl.edu.agh.hbs.ui.dto.Colour

object ActEatGrass extends Action {

  override def stepsDuration: Int = 1

  override def action(modifiers: ModifierBuffer): StepOutput = {
    val energy = modifiers.getFirst[ModEnergy]("standard").energy
    val eatenEnergy = modifiers.getFirst[ModEnergy]("eaten").energy
    modifiers.update(ModEnergy(energy + eatenEnergy, "standard"))

    val position = modifiers.getFirst[ModPosition].position
    val config = modifiers.getFirst[ModEnvironmentConfig].config
    val patch = config.getPatch(position)

    patch.modifiers.update(ModTerrain("earth"))

    val patchRepresentation = patch.modifiers.getFirst[ModRepresentation].representation
    patch.modifiers.update(ModRepresentation(patchRepresentation, Colour.BROWN))

    new StepOutput()
  }
}
