package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.simulation.api.Area;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GenericSimulationBuilder {

    private GenericAreaStep step;
    private GenericSimulationConfig config;

    public GenericSimulationBuilder(GenericAreaStep step, GenericSimulationConfig config) {
        this.step = step;
        this.config = config;
    }

    List<? extends Area> build() {
        List<? extends Area> areas = config.getAreas(step);
        Collection<Agent> agents = config.getAgents();
        areas.forEach(area -> area.addAgents(agents.stream()
                .filter(agent -> area.isInside(agent.position()))
                .collect(Collectors.toList())
        ));
        return areas;
    }

    public GenericAreaStep getStep() {
        return step;
    }

    public GenericSimulationConfig getConfig() {
        return config;
    }

    public void setStep(GenericAreaStep step) {
        this.step = step;
    }

    public void setConfig(GenericSimulationConfig config) {
        this.config = config;
    }
}
