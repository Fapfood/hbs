package pl.edu.agh.hbs.model.skill.diPatch.modifier

import pl.edu.agh.hbs.model.skill.Modifier
import pl.edu.agh.hbs.ui.dto.Colour

case class ModChangeStateParameters(state1Colour: Colour, state2Colour: Colour,
                                    state1TerrainLabel: String = "state1", state2TerrainLabel: String = "state2",
                                    goToState1Probability: Double = 0.5, goToState2Probability: Double = 0.5) extends Modifier {
  override def copy(): Modifier = ModChangeStateParameters(state1Colour, state2Colour, state1TerrainLabel,
    state2TerrainLabel, goToState1Probability, goToState2Probability)
}
