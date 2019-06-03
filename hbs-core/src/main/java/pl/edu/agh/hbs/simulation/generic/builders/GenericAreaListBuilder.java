package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;

import java.util.List;

public interface GenericAreaListBuilder {
    List<Area> build(Step step, SpaceConfig spaceConfig);
}
