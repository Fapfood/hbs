package pl.edu.agh.hbs.simulation.agent

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.basic.modifier.ModIdentifier
import pl.edu.agh.hbs.model.skill.diPatch.DiPatch
import pl.edu.agh.hbs.model.skill.diPatch.modifier.ModChangeStateParameters
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}
import pl.edu.agh.hbs.simulation.species.GrassSpecies
import pl.edu.agh.hbs.ui.dto.Colour

import scala.collection.mutable.ListBuffer

class GrassAgent(private val initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer)
  extends Agent(initModifiers, inheritedModifiers)
    with DiPatch {

  override def defaultModifiers(): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    modifiers += ModIdentifier(GrassSpecies.nextId())
    modifiers += ModChangeStateParameters(Colour.GREEN, Colour.BROWN, "grass", "earth", 0.05, 0.01)
    super.defaultModifiers() ++ modifiers
  }
}
