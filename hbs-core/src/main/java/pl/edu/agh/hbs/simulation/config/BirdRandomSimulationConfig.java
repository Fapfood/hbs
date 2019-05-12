package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.builders.BirdBuilder;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.*;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BirdRandomSimulationConfig implements GenericSimulationConfig {
    private GenericAgentListBuilder agentsBuilder;

    public BirdRandomSimulationConfig(Representation birdShape) {
        this.agentsBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(17)
                .setRepresentation(ModRepresentation.apply(birdShape, Colour.ORANGE))
                .setAgentBuilder(new BirdBuilder());
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
