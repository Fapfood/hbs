package pl.edu.agh.hbs.simulation.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.simulation.generic.GenericAgentBuilder;
import pl.edu.agh.hbs.simulation.species.Bird;
import pl.edu.agh.hbs.simulation.species.Shark;
import scala.collection.Seq;

public class SharkBuilder implements GenericAgentBuilder {
    @Override
    public Agent newAgent(Seq<Modifier> modifierSeq, ModifierBuffer modifierBuffer) {
        return Shark.newAgent(modifierSeq, modifierBuffer);
    }
}
