package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.builders.SheepBuilder;
import pl.edu.agh.hbs.simulation.builders.WolfBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericCombinedAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class SheepRandomSimulationConfig extends GenericSimulationConfigWithBuilder {

    private Representation sheepShape;
    private Representation wolfShape;

    public SheepRandomSimulationConfig(Representation sheepShape, Representation wolfShape) {
        this.sheepShape = sheepShape;
        this.wolfShape = wolfShape;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        GenericAgentListBuilder sheepBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(10)
                .setRepresentation(ModRepresentation.apply(sheepShape, Colour.GREEN))
                .setAgentBuilder(new SheepBuilder());
        GenericAgentListBuilder wolfBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(3)
                .setRepresentation(ModRepresentation.apply(wolfShape, Colour.RED))
                .setAgentBuilder(new WolfBuilder());
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(sheepBuilder)
                .addAgentsBuilder(wolfBuilder);
    }
}
