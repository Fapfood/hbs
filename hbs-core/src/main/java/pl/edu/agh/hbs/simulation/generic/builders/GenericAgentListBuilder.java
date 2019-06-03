package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;

import java.util.List;

public interface GenericAgentListBuilder {
    List<Agent> build(SpaceConfig spaceConfig, List<Area> areas);
}
