package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;

import java.util.*;

public abstract class GenericSimulationConfigWithBuilder implements GenericSimulationConfig {
    public abstract GenericAgentListBuilder getAgentsBuilder();

    public abstract GenericPatchListBuilder getPatchBuilder();

    @Override
    public Collection<Agent> getAgents(EnvironmentConfig environmentConfig) {
        return getAgentsBuilder().build(environmentConfig);
    }

    @Override
    public Collection<Agent> getPatches(EnvironmentConfig environmentConfig) {
        GenericPatchListBuilder builder = getPatchBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return getPatchBuilder().build(environmentConfig);
    }

    @Override
    public List<Area> getAreas(Step step, EnvironmentConfig environmentConfig) {
        EnvironmentConfig environmentConfig1 = new EnvironmentConfig(environmentConfig.width(), environmentConfig.height(), environmentConfig.patchWidth(), environmentConfig.patchHeight());
        EnvironmentConfig environmentConfig2 = new EnvironmentConfig(environmentConfig.width(), environmentConfig.height(), environmentConfig.patchWidth(), environmentConfig.patchHeight());
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
                        new LinkedList<>(),
                        environmentConfig1
                ),
                new GenericArea(
                        "area-2",
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
                        environmentConfig2
                )
        );
    }
}
