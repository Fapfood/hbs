package pl.edu.agh.hbs.model.skill.patch.modifier

import pl.edu.agh.hbs.model.Vector
import pl.edu.agh.hbs.model.skill.Modifier

case class ModOccupiedArea(leftBottom: Vector, rightUpper: Vector) extends Modifier {
  override def copy(): Modifier = ModOccupiedArea(Vector.of(leftBottom.value: _*), Vector(rightUpper.value: _*))
}
