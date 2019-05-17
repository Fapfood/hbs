package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{ModifierBuffer, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.WolfAgent

class WolfAlphaSpecies extends WolfSpecies

object WolfAlphaSpecies extends SpeciesObject {
  val species = new WolfAlphaSpecies

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer) = new WolfAgent(initModifiers, inheritedModifiers)
}
