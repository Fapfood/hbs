package pl.edu.agh.hbs.model.skill.basic.modifier

import pl.edu.agh.hbs.model.EnvironmentConfig
import pl.edu.agh.hbs.model.skill.Modifier

case class ModEnvironmentConfig(config: EnvironmentConfig) extends Modifier {
  override def copy(): Modifier = ModEnvironmentConfig(config)
}
