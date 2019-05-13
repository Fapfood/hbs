package pl.edu.agh.hbs.model.skill.basic.decision

import pl.edu.agh.hbs.model.ModifierBuffer
import pl.edu.agh.hbs.model.skill.{Action, Decision}

object DecEmpty extends Decision {

  override val actions: List[Action] = List()

  override def priority: Int = 0

  override def decision(modifiers: ModifierBuffer): Boolean = true

}
