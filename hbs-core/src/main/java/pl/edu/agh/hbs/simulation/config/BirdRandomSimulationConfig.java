package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.builders.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.builders.GenericAreaListBuilder;
import pl.edu.agh.hbs.simulation.generic.builders.RandomAreaListBuilder;
import pl.edu.agh.hbs.simulation.generic.config.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.builders.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.simulation.species.BirdSpecies;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class BirdRandomSimulationConfig extends GenericSimulationConfigWithBuilder {

    private Representation birdShape;

    public BirdRandomSimulationConfig(Representation birdShape) {
        this.birdShape = birdShape;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        return new GenericSingleSpeciesAgentListBuilder()
                .setNumber(17)
                .setRepresentation(ModRepresentation.apply(birdShape, Colour.ORANGE))
                .setAgentBuilder(BirdSpecies::newAgent);
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
