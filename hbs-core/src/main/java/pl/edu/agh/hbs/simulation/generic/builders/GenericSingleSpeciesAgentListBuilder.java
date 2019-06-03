package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModEnvironmentConfig;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class GenericSingleSpeciesAgentListBuilder implements GenericAgentListBuilder {

    private BiFunction<Seq<Modifier>, ModifierBuffer, Agent> agentBuilder;
    private Vector positionMin = null;
    private Vector positionMax = null;
    private Vector speedMin = Vector.of(-20, -20);
    private Vector speedMax = Vector.of(20, 20);
    private String velocityLabel = "standard";
    private ModRepresentation representation;
    private Integer number = 1;

    @Override
    public List<Agent> build(SpaceConfig spaceConfig, List<Area> areas) {
        List<Integer> arr = Arrays.asList(new Integer[number]);
        return arr.stream().map(i -> getInstance(spaceConfig, areas)).collect(Collectors.toList());
    }

    private Agent getInstance(SpaceConfig spaceConfig, List<Area> areas) {
        Vector min = positionMin == null ? Vector.of(0, 0) : positionMin;
        Vector max = positionMax == null ? Vector.of(spaceConfig.getWidth(), spaceConfig.getHeight()) : positionMax;
        Vector position = vectorFromRange(min, max);
        Area area = areas.stream().filter(area1 -> area1.isInside(position)).collect(Collectors.toList()).get(0);
        return agentBuilder.apply(
                JavaConverters.asScalaIteratorConverter(Arrays.asList(
                        ModPosition.apply(position),
                        ModVelocity.apply(vectorFromRange(speedMin, speedMax), velocityLabel),
                        ModEnvironmentConfig.apply(area.getConfig()),
                        (Modifier) representation
                ).iterator()).asScala().toSeq(),
                new ModifierBuffer()
        );
    }

    private Vector vectorFromRange(Vector begin, Vector end) {
        return Vector.of(doubleFromRange(
                begin.get(0), end.get(0)),
                doubleFromRange(begin.get(1), end.get(1))
        );
    }

    private Double doubleFromRange(Double begin, Double end) {
        return ThreadLocalRandom.current().nextDouble(begin, end);
    }

    public GenericSingleSpeciesAgentListBuilder setAgentBuilder(BiFunction<Seq<Modifier>, ModifierBuffer, Agent> agentBuilder) {
        this.agentBuilder = agentBuilder;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setPositionMin(Vector positionMin) {
        this.positionMin = positionMin;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setPositionMax(Vector positionMax) {
        this.positionMax = positionMax;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setSpeedMin(Vector speedMin) {
        this.speedMin = speedMin;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setSpeedMax(Vector speedMax) {
        this.speedMax = speedMax;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setVelocityLabel(String velocityLabel) {
        this.velocityLabel = velocityLabel;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setRepresentation(ModRepresentation representation) {
        this.representation = representation;
        return this;
    }

    public GenericSingleSpeciesAgentListBuilder setNumber(Integer number) {
        this.number = number;
        return this;
    }
}
