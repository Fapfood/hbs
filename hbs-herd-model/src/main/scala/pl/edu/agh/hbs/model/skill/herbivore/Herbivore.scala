package pl.edu.agh.hbs.model.skill.herbivore

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.common.modifier.ModEnergy
import pl.edu.agh.hbs.model.skill.herbivore.decision.DecEatGrass
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}

import scala.collection.mutable.ListBuffer

trait Herbivore extends Agent {
  this.decisions += DecEatGrass

  override def modifiersCopiedFromParent(inherited: ModifierBuffer): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    inherited.getAll[ModEnergy](Seq("eaten")).foreach(m => modifiers += m.copy())
    super.modifiersCopiedFromParent(inherited) ++ modifiers
  }

  override def defaultModifiers(): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    modifiers += ModEnergy(400, "standard")
    modifiers += ModEnergy(50, "eaten")
    super.defaultModifiers() ++ modifiers
  }
}
