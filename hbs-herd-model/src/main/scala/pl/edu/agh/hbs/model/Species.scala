package pl.edu.agh.hbs.model

import pl.edu.agh.hbs.model.skill.Modifier

trait Species extends Serializable

trait SpeciesObject extends Serializable {

  val species: Species

  val maxNumberOfSpecies: Int = Int.MaxValue

  def newAgent(initModifiers: Seq[Modifier], inheritedModifiers: ModifierBuffer): Agent

  private var allInClassCounter = 0

  private var currentInClassCounter = 0

  final def nextId(): String = {
    currentInClassCounter += 1
    allInClassCounter += 1
    this.species.getClass.toString + (allInClassCounter - 1)
  }

  def isMaxReached: Boolean = currentInClassCounter >= maxNumberOfSpecies

  def decCounter(): Unit = currentInClassCounter -= 1

}
