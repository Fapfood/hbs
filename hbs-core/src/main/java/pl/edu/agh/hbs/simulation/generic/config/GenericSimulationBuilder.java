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
    private SpaceConfig spaceConfig;

    public GenericSimulationBuilder(GenericAreaStep step, GenericSimulationConfig config, SpaceConfig spaceConfig) {
        this.step = step;
        this.config = config;
        this.spaceConfig = spaceConfig;
    }

    public List<Area> build() {
        return config.getAreas(step, spaceConfig);
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
