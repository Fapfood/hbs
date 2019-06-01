package pl.edu.agh.hbs.model.skill.breeding

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.model.skill.breeding.decision.DecBreed
import pl.edu.agh.hbs.model.skill.breeding.modifier.ModBreedParameters
import pl.edu.agh.hbs.model.skill.common.modifier.ModTimer
import pl.edu.agh.hbs.model.{Agent, ModifierBuffer}

import scala.collection.mutable.ListBuffer
import scala.util.Random

trait BreedingAgent extends Agent {
  this.decisions += DecBreed

  override def modifiersCopiedFromParent(inherited: ModifierBuffer): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    inherited.getAll[ModBreedParameters].foreach(m => modifiers += m.copy())
    super.modifiersCopiedFromParent(inherited) ++ modifiers
  }

  override def defaultModifiers(): Seq[Modifier] = {
    val modifiers = ListBuffer.empty[Modifier]
    val breedParameters = ModBreedParameters(50, 400)
    modifiers += breedParameters
    val rand = new Random()
    modifiers += ModTimer(rand.nextInt(breedParameters.breedTimer / 5), "breed")
    super.defaultModifiers() ++ modifiers
  }
}
