package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericCombinedAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.simulation.species.Fish;
import pl.edu.agh.hbs.simulation.species.Shark;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class FishRandomSimulationConfig extends GenericSimulationConfigWithBuilder {

    private Representation fishShape;
    private Representation sharkShape;

    public FishRandomSimulationConfig(Representation fishShape, Representation sharkShape) {
        this.fishShape = fishShape;
        this.sharkShape = sharkShape;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        GenericAgentListBuilder sheepBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(6)
                .setRepresentation(ModRepresentation.apply(fishShape, Colour.GREEN))
                .setAgentBuilder(Fish::newAgent);
        GenericAgentListBuilder wolfBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(3)
                .setRepresentation(ModRepresentation.apply(sharkShape, Colour.RED))
                .setAgentBuilder(Shark::newAgent);
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(sheepBuilder)
                .addAgentsBuilder(wolfBuilder);
    }
}
