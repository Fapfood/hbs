package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.simulation.species.BirdSpecies;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class BirdRandomSimulationConfig extends GenericSimulationConfigWithBuilder {
    private Representation birdShape;
    private Colour birdColour;
    private Integer birdNumber;

    public BirdRandomSimulationConfig(Representation birdShape, Colour birdColour, Integer birdNumber) {
        this.birdShape = birdShape;
        this.birdColour = birdColour;
        this.birdNumber = birdNumber;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        return new GenericSingleSpeciesAgentListBuilder()
                .setNumber(birdNumber)
                .setRepresentation(ModRepresentation.apply(birdShape, birdColour))
                .setAgentBuilder(BirdSpecies::newAgent);
    }
}
