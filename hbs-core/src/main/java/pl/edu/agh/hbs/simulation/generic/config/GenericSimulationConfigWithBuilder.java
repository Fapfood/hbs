package pl.edu.agh.hbs.simulation.generic.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.generic.builders.GenericAgentListBuilder;
import pl.edu.agh.hbs.simulation.generic.builders.GenericAreaListBuilder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class GenericSimulationConfigWithBuilder implements GenericSimulationConfig {
    public abstract GenericAgentListBuilder getAgentsBuilder();

    public abstract GenericAgentListBuilder getPatchBuilder();

    public abstract GenericAreaListBuilder getAreasBuilder();

    @Override
    public List<Agent> getAgents(EnvironmentConfig environmentConfig) {
        GenericAgentListBuilder builder = getAgentsBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return builder.build(environmentConfig);
    }

    @Override
    public Collection<Agent> getPatches(EnvironmentConfig environmentConfig) {
        GenericAgentListBuilder builder = getPatchBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return builder.build(environmentConfig);
    }

    @Override
    public List<Area> getAreas(Step step, EnvironmentConfig environmentConfig) {
        GenericAreaListBuilder builder = getAreasBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return builder.build(step, environmentConfig);
    }
}
