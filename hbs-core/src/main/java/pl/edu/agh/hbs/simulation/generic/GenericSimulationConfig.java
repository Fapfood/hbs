package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;

import java.util.Collection;
import java.util.List;

public interface GenericSimulationConfig {
    Collection<Agent> getAgents();

    List<? extends Area> getAreas(Step step);
}
