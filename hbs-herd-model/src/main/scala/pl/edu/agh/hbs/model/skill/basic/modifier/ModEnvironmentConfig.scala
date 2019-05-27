package pl.edu.agh.hbs.model.skill.basic.modifier

import pl.edu.agh.hbs.model.EnvironmentConfig
import pl.edu.agh.hbs.model.skill.Modifier

case class ModEnvironmentConfig(config: EnvironmentConfig) extends Modifier {
  override def copy(): Modifier = {
    val newConfig = new EnvironmentConfig(config.width, config.height, config.patchWidth, config.patchHeight)
    newConfig.addPatches(config.getPatches)
    ModEnvironmentConfig(newConfig)
  }
}
