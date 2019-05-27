package pl.edu.agh.hbs.model.skill.herbivore.decision

import pl.edu.agh.hbs.model.ModifierBuffer
import pl.edu.agh.hbs.model.skill.basic.modifier.{ModEnvironmentConfig, ModPosition}
import pl.edu.agh.hbs.model.skill.diPatch.modifier.ModTerrain
import pl.edu.agh.hbs.model.skill.herbivore.action.ActEatGrass
import pl.edu.agh.hbs.model.skill.{Action, Decision}

object DecEatGrass extends Decision {

  override val actions: List[Action] = List(ActEatGrass)

  override def priority: Int = 4

  override def decision(modifiers: ModifierBuffer): Boolean = {
    val position = modifiers.getFirst[ModPosition].position
    val config = modifiers.getFirst[ModEnvironmentConfig].config
    val patch = config.getPatch(position)
    val terrain = patch.modifiers.getFirst[ModTerrain].kind

    terrain == "grass"
  }

}
