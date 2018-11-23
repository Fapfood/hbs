package pl.edu.agh.hbs.simulation.agent

import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}
import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.flocking.FlockingAgent

class SheepAgent(private val initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer)
  extends Agent(initModifiers, inheritedModifiers)
    with FlockingAgent {
}
