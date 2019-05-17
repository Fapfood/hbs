package pl.edu.agh.hbs.model.skill.diPatch.modifier

import pl.edu.agh.hbs.model.skill.Modifier

case class ModTerrain(kind: String) extends Modifier {
  override def copy(): Modifier = ModTerrain(kind)
}
