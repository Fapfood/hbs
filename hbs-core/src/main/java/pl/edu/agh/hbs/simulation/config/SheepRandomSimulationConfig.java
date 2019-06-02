package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.generic.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericCombinedAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.generic.GenericSingleSpeciesAgentListBuilder;
import pl.edu.agh.hbs.simulation.species.SheepSpecies;
import pl.edu.agh.hbs.simulation.species.WolfSpecies;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

public class SheepRandomSimulationConfig extends GenericSimulationConfigWithBuilder {
    private Representation sheepShape;
    private Colour sheepColour;
    private Integer sheepNumber;
    private Representation wolfShape;
    private Colour wolfColour;
    private Integer wolfNumber;

    public SheepRandomSimulationConfig(Representation sheepShape, Colour sheepColour, Integer sheepNumber,
                                       Representation wolfShape, Colour wolfColour, Integer wolfNumber) {
        this.sheepShape = sheepShape;
        this.sheepColour = sheepColour;
        this.sheepNumber = sheepNumber;
        this.wolfShape = wolfShape;
        this.wolfColour = wolfColour;
        this.wolfNumber = wolfNumber;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        GenericAgentListBuilder sheepBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(sheepNumber)
                .setRepresentation(ModRepresentation.apply(sheepShape, sheepColour))
                .setAgentBuilder(SheepSpecies::newAgent);
        GenericAgentListBuilder wolfBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(wolfNumber)
                .setRepresentation(ModRepresentation.apply(wolfShape, wolfColour))
                .setAgentBuilder(WolfSpecies::newAgent);
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(sheepBuilder)
                .addAgentsBuilder(wolfBuilder);
    }
}
