package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;

import java.util.Collection;

public interface GenericPatchListBuilder {
    Collection<Agent> build(EnvironmentConfig environmentConfig);
}
