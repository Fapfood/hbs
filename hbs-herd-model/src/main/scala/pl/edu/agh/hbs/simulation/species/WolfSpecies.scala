package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{ModifierBuffer, Species, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.WolfAgent

class WolfSpecies extends Species

object WolfSpecies extends SpeciesObject {
  override val species = new WolfSpecies

  override val maxNumberOfSpecies: Int = 20

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer) = new WolfAgent(initModifiers, inheritedModifiers)
}
