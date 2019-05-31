package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.builders.*;
import pl.edu.agh.hbs.simulation.generic.config.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.species.FishSpecies;
import pl.edu.agh.hbs.simulation.species.SharkSpecies;
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
        GenericAgentListBuilder fishBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(6)
                .setRepresentation(ModRepresentation.apply(fishShape, Colour.GREEN))
                .setAgentBuilder(FishSpecies::newAgent);
        GenericAgentListBuilder sharkBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(3)
                .setRepresentation(ModRepresentation.apply(sharkShape, Colour.RED))
                .setAgentBuilder(SharkSpecies::newAgent);
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(fishBuilder)
                .addAgentsBuilder(sharkBuilder);
    }

    @Override
    public GenericAgentListBuilder getPatchBuilder() {
        return null;
    }

    @Override
    public GenericAreaListBuilder getAreasBuilder() {
        return new RandomAreaListBuilder().setNumberOfAreas(2L);
    }
}
