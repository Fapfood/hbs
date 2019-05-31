package pl.edu.agh.hbs.simulation.generic.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.generic.GenericAreaStep;
import pl.edu.agh.hbs.simulation.generic.config.GenericSimulationConfig;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class GenericSimulationBuilder {

    private GenericAreaStep step;
    private GenericSimulationConfig config;
    private EnvironmentConfig environmentConfig;

    public GenericSimulationBuilder(GenericAreaStep step, GenericSimulationConfig config, EnvironmentConfig environmentConfig) {
        this.step = step;
        this.config = config;
        this.environmentConfig = environmentConfig;
    }

    public List<Area> build() {
        List<Area> areas = config.getAreas(step, environmentConfig);
        Collection<Agent> agents = config.getAgents(environmentConfig);
        Collection<Agent> patches = config.getPatches(environmentConfig);
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
