package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericCombinedAgentListBuilder implements GenericAgentListBuilder {
    private List<GenericAgentListBuilder> agentsBuilders = new LinkedList<>();

    @Override
    public List<Agent> build(SpaceConfig spaceConfig, List<Area> areas) {
        return agentsBuilders.stream().map(builder -> builder.build(spaceConfig, areas))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public GenericCombinedAgentListBuilder addAgentsBuilder(GenericAgentListBuilder agentsBuilder) {
        this.agentsBuilders.add(agentsBuilder);
        return this;
    }
}
