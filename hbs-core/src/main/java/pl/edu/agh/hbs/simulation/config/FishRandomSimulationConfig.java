package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericCombinedAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.simulation.species.FishSpecies;
import pl.edu.agh.hbs.simulation.species.SharkSpecies;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class FishRandomSimulationConfig extends GenericSimulationConfigWithBuilder {
    private Representation fishShape;
    private Colour fishColour;
    private Integer fishNumber;
    private Representation sharkShape;
    private Colour sharkColour;
    private Integer sharkNumber;

    public FishRandomSimulationConfig(Representation fishShape, Colour fishColour, Integer fishNumber,
                                      Representation sharkShape, Colour sharkColour, Integer sharkNumber) {
        this.fishShape = fishShape;
        this.fishColour = fishColour;
        this.fishNumber = fishNumber;
        this.sharkShape = sharkShape;
        this.sharkColour = sharkColour;
        this.sharkNumber = sharkNumber;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        GenericAgentListBuilder fishBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(fishNumber)
                .setRepresentation(ModRepresentation.apply(fishShape, fishColour))
                .setAgentBuilder(FishSpecies::newAgent);
        GenericAgentListBuilder sharkBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(sharkNumber)
                .setRepresentation(ModRepresentation.apply(sharkShape, sharkColour))
                .setAgentBuilder(SharkSpecies::newAgent);
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(fishBuilder)
                .addAgentsBuilder(sharkBuilder);
    }
}
