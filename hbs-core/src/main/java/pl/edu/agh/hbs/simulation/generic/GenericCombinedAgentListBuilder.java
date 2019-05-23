package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericCombinedAgentListBuilder implements GenericAgentListBuilder {
    private List<GenericAgentListBuilder> agentsBuilders = new LinkedList<>();

    @Override
    public Collection<Agent> build(EnvironmentConfig environmentConfig) {
        return agentsBuilders.stream().map(builder -> builder.build(environmentConfig))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public GenericCombinedAgentListBuilder addAgentsBuilder(GenericAgentListBuilder agentsBuilder) {
        this.agentsBuilders.add(agentsBuilder);
        return this;
    }
}
