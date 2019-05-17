package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.BirdAgent

class BirdSpecies extends Species

object BirdSpecies extends SpeciesObject {
  override val species = new BirdSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new BirdAgent(initModifiers, inheritedModifiers)
}
