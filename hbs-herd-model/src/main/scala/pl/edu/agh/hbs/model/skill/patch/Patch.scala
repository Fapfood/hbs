package pl.edu.agh.hbs.model.skill.patch

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.basic.decision.DecEmpty
import pl.edu.agh.hbs.model.skill.basic.modifier.{ModEnvironmentConfig, ModPosition}
import pl.edu.agh.hbs.model.skill.patch.modifier.ModOccupiedArea
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}

import scala.collection.mutable.ListBuffer

trait Patch extends Agent {
  this.decisions += DecEmpty

  private val conf = modifiers.getFirst[ModEnvironmentConfig].config
  private val pos = modifiers.getFirst[ModPosition].position
  conf.addPatch(pos, this)

  override def modifiersCopiedFromParent(inherited: ModifierBuffer): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    inherited.getAll[ModOccupiedArea].foreach(m => modifiers += m.copy())
    super.modifiersCopiedFromParent(inherited) ++ modifiers
  }
}
