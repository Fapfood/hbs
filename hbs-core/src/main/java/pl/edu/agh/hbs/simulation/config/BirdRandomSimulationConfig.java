package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericPatchListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
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
    public GenericPatchListBuilder getPatchBuilder() {
        return null;
    }
}
