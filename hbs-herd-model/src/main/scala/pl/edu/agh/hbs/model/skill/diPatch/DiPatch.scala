package pl.edu.agh.hbs.model.skill.diPatch

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.diPatch.instantAction.ActChangeState
import pl.edu.agh.hbs.model.skill.diPatch.modifier.{ModChangeStateParameters, ModTerrain}
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}
import pl.edu.agh.hbs.ui.dto.Colour

import scala.collection.mutable.ListBuffer

trait DiPatch extends Agent {
  this.afterStepActions += ActChangeState

  override def modifiersCopiedFromParent(inherited: ModifierBuffer): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    inherited.getAll[ModChangeStateParameters].foreach(m => modifiers += m.copy())
    inherited.getAll[ModTerrain].foreach(m => modifiers += m.copy())
    super.modifiersCopiedFromParent(inherited) ++ modifiers
  }

  override def defaultModifiers(): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    modifiers += ModChangeStateParameters(Colour.WHITE, Colour.BLACK)
    super.defaultModifiers() ++ modifiers
  }
}
