package pl.edu.agh.hbs.simulation.agent

import pl.edu.agh.hbs.model
import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.basic.modifier.{ModIdentifier, ModSpecies}
import pl.edu.agh.hbs.model.skill.breeding.BreedingAgent
import pl.edu.agh.hbs.model.skill.common.modifier.{ModEnergy, ModVelocity}
import pl.edu.agh.hbs.model.skill.dying.DyingAgent
import pl.edu.agh.hbs.model.skill.flocking.FlockingAgent
import pl.edu.agh.hbs.model.skill.herbivore.Herbivore
import pl.edu.agh.hbs.model.skill.moving.MovingAgent
import pl.edu.agh.hbs.model.skill.prey.Prey
import pl.edu.agh.hbs.model.skill.prey.modifier.ModFearOf
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}
import pl.edu.agh.hbs.simulation.species.{HerbivorousSheepSpecies, WolfSpecies}

import scala.collection.mutable.ListBuffer
import scala.util.Random

class HerbivorousSheepAgent(private val initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer)
  extends Agent(initModifiers, inheritedModifiers)
    with MovingAgent
    with FlockingAgent
    with BreedingAgent
    with DyingAgent
    with Herbivore
    with Prey {

  override def defaultModifiers(): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    modifiers += ModFearOf(WolfSpecies)
    modifiers += ModSpecies(HerbivorousSheepSpecies)
    modifiers += ModIdentifier(HerbivorousSheepSpecies.nextId())
    modifiers += ModEnergy(1, "consumed")
    modifiers += ModVelocity(model.Vector((new Random().nextDouble() - 0.5) * 20, (new Random().nextDouble() - 0.5) * 20), "random")
    super.defaultModifiers() ++ modifiers
  }
}
