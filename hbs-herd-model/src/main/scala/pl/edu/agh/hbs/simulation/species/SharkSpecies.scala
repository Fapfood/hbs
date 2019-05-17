package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.SharkAgent

class SharkSpecies extends Species

object SharkSpecies extends SpeciesObject {
  override val species = new SharkSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new SharkAgent(initModifiers, inheritedModifiers)
}
