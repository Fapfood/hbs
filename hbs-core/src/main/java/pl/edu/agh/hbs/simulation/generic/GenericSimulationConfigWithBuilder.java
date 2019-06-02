package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public abstract class GenericSimulationConfigWithBuilder implements GenericSimulationConfig {
    public abstract GenericAgentListBuilder getAgentsBuilder();

    @Override
    public Collection<Agent> getAgents() {
        return getAgentsBuilder().build();
    }

    @Override
    public List<? extends Area> getAreas(Step step) {
        return Arrays.asList(
                new GenericArea(
                        "area1",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(0, 0),
                                Vector.of(1000, 1500),
                                true,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>(),
                        new EnvironmentConfig(2000, 1500, 100, 100)
                ),
                new GenericArea(
                        "area2",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(1000, 0),
                                Vector.of(2000, 1500),
                                false,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>(),
                        new EnvironmentConfig(2000, 1500, 100, 100)
                )
        );
    }
}
