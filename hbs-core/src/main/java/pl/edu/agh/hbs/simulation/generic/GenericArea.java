package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.AreaBordersDefinition;
import pl.edu.agh.hbs.simulation.api.Step;

import java.util.Collection;

public class GenericArea extends Area {

    public GenericArea(final String areaId,
                       final Step step,
                       final AreaBordersDefinition areaBordersDefinition,
                       final Collection<Agent> agents,
                       final EnvironmentConfig config) {
        super(areaId, step, areaBordersDefinition, agents, config);
    }
}
