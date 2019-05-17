package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.GrassAgent

class GrassSpecies extends Species

object GrassSpecies extends SpeciesObject {
  override val species = new GrassSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new GrassAgent(initModifiers, inheritedModifiers)
}
