package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.FishAgent

class FishSpecies extends Species

object FishSpecies extends SpeciesObject {
  override val species = new FishSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new FishAgent(initModifiers, inheritedModifiers)
}
