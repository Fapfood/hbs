package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModEnvironmentConfig;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity;
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
    private Vector positionMin = Vector.of(0, 0);
    private Vector positionMax = Vector.of(2000, 1500);
    private Vector speedMin = Vector.of(-20, -20);
    private Vector speedMax = Vector.of(20, 20);
    private String velocityLabel = "standard";
    private ModRepresentation representation;
    private Integer number = 1;

    @Override
    public Collection<Agent> build(EnvironmentConfig environmentConfig) {
        List<Integer> arr = Arrays.asList(new Integer[number]);
        return arr.stream().map(i -> getInstance(environmentConfig)).collect(Collectors.toList());
    }

    private Agent getInstance(EnvironmentConfig environmentConfig) {
        return agentBuilder.apply(
                JavaConverters.asScalaIteratorConverter(Arrays.asList(
                        ModPosition.apply(vectorFromRange(positionMin, positionMax)),
                        ModVelocity.apply(vectorFromRange(speedMin, speedMax), velocityLabel),
                        ModEnvironmentConfig.apply(environmentConfig),
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
