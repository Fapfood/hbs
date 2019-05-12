package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.skill.Modifier;
import scala.collection.Seq;

public interface GenericAgentBuilder {
    Agent newAgent(Seq<Modifier> modifierSeq, ModifierBuffer modifierBuffer);
}
