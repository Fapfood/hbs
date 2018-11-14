package pl.edu.agh.hbs.simulation.agent

import pl.edu.agh.hbs.model.Agent
import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.basic.modifier.{ModIdentifier, ModSpecies}
import pl.edu.agh.hbs.model.skill.moving.MovingAgent
import pl.edu.agh.hbs.simulation.species.Human

class HumanAgent(private val initModifiers: Seq[Modifier])
  extends Agent(initModifiers)
    with MovingAgent {
  this.modifiers.update(ModSpecies(Human))
  this.modifiers.update(ModIdentifier(Human.nextId()))
}
