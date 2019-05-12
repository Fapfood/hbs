package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.builders.BirdBuilder;
import pl.edu.agh.hbs.simulation.builders.SheepBuilder;
import pl.edu.agh.hbs.simulation.builders.WolfBuilder;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.*;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SheepRandomSimulationConfig implements GenericSimulationConfig {
    private GenericAgentListBuilder agentsBuilder;

    public SheepRandomSimulationConfig(Representation sheepShape, Representation wolfShape) {
        GenericAgentListBuilder sheepBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(10)
                .setRepresentation(ModRepresentation.apply(sheepShape, Colour.GREEN))
                .setAgentBuilder(new SheepBuilder());
        GenericAgentListBuilder wolfBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(1)
                .setRepresentation(ModRepresentation.apply(wolfShape, Colour.RED))
                .setAgentBuilder(new WolfBuilder());
        this.agentsBuilder = new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(sheepBuilder)
                .addAgentsBuilder(wolfBuilder);
    }

    @Override
    public Collection<Agent> getAgents() {
        return agentsBuilder.build();
    }

    @Override
    public List<? extends Area> getAreas(Step step) {
        return Arrays.asList(
                new GenericArea(
                        "area-1",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(0, 0),
                                Vector.of(1000, 1500),
                                true,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>()
                ),
                new GenericArea(
                        "area-2",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(1000, 0),
                                Vector.of(2500, 1500),
                                false,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>()
                )
        );
    }
}
