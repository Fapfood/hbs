package pl.edu.agh.hbs.simulation.agent

import pl.edu.agh.hbs.model.Agent
import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.basic.modifier.{ModIdentifier, ModSpecies}
import pl.edu.agh.hbs.model.skill.dying.DyingAgent
import pl.edu.agh.hbs.model.skill.moving.MovingAgent
import pl.edu.agh.hbs.simulation.species.Fish

class FishAgent(private val initModifiers: Seq[Modifier])
  extends Agent(initModifiers)
    with MovingAgent
    with DyingAgent {
  this.modifiers.update(ModSpecies(Fish))
  this.modifiers.update(ModIdentifier(Fish.nextId()))
}
