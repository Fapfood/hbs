package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;

import java.util.List;

public interface GenericAgentListBuilder {
    List<Agent> build(EnvironmentConfig environmentConfig);
}
