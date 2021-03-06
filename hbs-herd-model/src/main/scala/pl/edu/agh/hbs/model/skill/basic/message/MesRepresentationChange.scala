package pl.edu.agh.hbs.model.skill.basic.message

import pl.edu.agh.hbs.model.ModifierBuffer
import pl.edu.agh.hbs.model.perception.DirectPerception
import pl.edu.agh.hbs.model.skill.Message
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation
import pl.edu.agh.hbs.ui.Representation
import pl.edu.agh.hbs.ui.dto.Colour


class MesRepresentationChange(val agentId: String,
                              val representation: Representation,
                              val colour: Colour) extends Message(perception = Seq(new DirectPerception(agentId))) {

  def process(modifiers: ModifierBuffer): Unit = {
    modifiers.update(ModRepresentation(this.representation, this.colour))
  }

}
