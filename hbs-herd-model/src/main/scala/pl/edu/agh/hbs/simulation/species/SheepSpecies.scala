package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.SheepAgent

class SheepSpecies extends Species

object SheepSpecies extends SpeciesObject {
  override val species = new SheepSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new SheepAgent(initModifiers, inheritedModifiers)
}
