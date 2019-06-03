package pl.edu.agh.hbs.simulation.species

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer, SpeciesObject}
import pl.edu.agh.hbs.simulation.agent.HerbivorousSheepAgent

class HerbivorousSheepSpecies extends SheepSpecies

object HerbivorousSheepSpecies extends SpeciesObject {
  override val species = new HerbivorousSheepSpecies

  override val maxNumberOfSpecies: Int = 100

  override def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent = new HerbivorousSheepAgent(initModifiers, inheritedModifiers)
}
