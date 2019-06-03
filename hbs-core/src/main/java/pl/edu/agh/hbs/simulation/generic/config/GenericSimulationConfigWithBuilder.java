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
import java.util.stream.Collectors;

public abstract class GenericSimulationConfigWithBuilder implements GenericSimulationConfig {
    public abstract GenericAgentListBuilder getAgentsBuilder();

    public abstract GenericAgentListBuilder getPatchBuilder();

    public abstract GenericAreaListBuilder getAreasBuilder();

    private List<Agent> getAgents(SpaceConfig spaceConfig, List<Area> areas) {
        GenericAgentListBuilder builder = getAgentsBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return builder.build(spaceConfig, areas);
    }

    private Collection<Agent> getPatches(SpaceConfig spaceConfig, List<Area> areas) {
        GenericAgentListBuilder builder = getPatchBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        return builder.build(spaceConfig, areas);
    }

    @Override
    public List<Area> getAreas(Step step, SpaceConfig spaceConfig) {
        GenericAreaListBuilder builder = getAreasBuilder();
        if (builder == null) {
            return Collections.emptyList();
        }
        List<Area> areas = builder.build(step, spaceConfig);
        Collection<Agent> agents = getAgents(spaceConfig, areas);
        Collection<Agent> patches = getPatches(spaceConfig, areas);
        areas.forEach(area -> area.addAgents(patches.stream()
                .filter(patch -> area.isInside(patch.position()))
                .collect(Collectors.toList())
        ));
        areas.forEach(area -> area.addAgents(agents.stream()
                .filter(agent -> area.isInside(agent.position()))
                .collect(Collectors.toList())
        ));
        return areas;
    }
}
