package pl.edu.agh.hbs.model.skill.diPatch.instantAction

import pl.edu.agh.hbs.model.skill.Action
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation
import pl.edu.agh.hbs.model.skill.diPatch.modifier.{ModChangeStateParameters, ModTerrain}
import pl.edu.agh.hbs.model.{ModifierBuffer, StepOutput}

import scala.util.Random

object ActChangeState extends Action {

  override def action(modifiers: ModifierBuffer): StepOutput = {
    val parameters = modifiers.getFirst[ModChangeStateParameters]
    val terrainLabel = modifiers.getFirst[ModTerrain].kind
    val representation = modifiers.getFirst[ModRepresentation].representation
    val random = new Random().nextDouble()

    terrainLabel match {
      case parameters.state1TerrainLabel =>
        if (random < parameters.goToState2Probability) {
          modifiers.update(ModTerrain(parameters.state2TerrainLabel))
          modifiers.update(ModRepresentation(representation, parameters.state2Colour))
        }

      case parameters.state2TerrainLabel =>
        if (random < parameters.goToState1Probability) {
          modifiers.update(ModTerrain(parameters.state1TerrainLabel))
          modifiers.update(ModRepresentation(representation, parameters.state1Colour))
        }
    }

    new StepOutput()
  }
}
