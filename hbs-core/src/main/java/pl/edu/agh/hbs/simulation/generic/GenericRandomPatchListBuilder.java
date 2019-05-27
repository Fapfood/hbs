package pl.edu.agh.hbs.simulation.generic;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModEnvironmentConfig;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.patch.modifier.ModOccupiedArea;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;

public class GenericRandomPatchListBuilder implements GenericPatchListBuilder {

    private List<BiFunction<Seq<Modifier>, ModifierBuffer, Agent>> patchBuilders = new LinkedList<>();
    private Vector positionMin = Vector.of(0, 0);
    private Vector positionMax = Vector.of(2000, 1500);
    private Vector boxSize = Vector.of(100, 100);

    @Override
    public Collection<Agent> build(EnvironmentConfig environmentConfig) {
        List<Agent> patches = new LinkedList<>();
        for (int i = 0; i < (positionMax.get(0) - positionMin.get(0)) / boxSize.get(0); i++) {
            for (int j = 0; j < (positionMax.get(1) / positionMin.get(1)) / boxSize.get(1); j++) {
                Vector leftBottom = Vector.of(
                        positionMin.get(0) + i * boxSize.get(0),
                        positionMin.get(1) + j * boxSize.get(1)
                );
                Vector position = Vector.of(
                        leftBottom.get(0) + boxSize.get(0) / 2,
                        leftBottom.get(1) + boxSize.get(1) / 2
                );
                Vector rightUpper = Vector.of(
                        leftBottom.get(0) + boxSize.get(0),
                        leftBottom.get(1) + boxSize.get(1)
                );
                Agent patch = getInstance(environmentConfig, position, leftBottom, rightUpper);
                patches.add(patch);
            }
        }
        return patches;
    }

    private Agent getInstance(EnvironmentConfig environmentConfig, Vector position, Vector leftBottom, Vector rightUpper) {
        int patchIndex = intFromRange(patchBuilders.size());
        BiFunction<Seq<Modifier>, ModifierBuffer, Agent> patchBuilder = patchBuilders.get(patchIndex);
        return patchBuilder.apply(
                JavaConverters.asScalaIteratorConverter(Arrays.asList(
                        ModPosition.apply(position),
                        ModOccupiedArea.apply(leftBottom, rightUpper),
                        (Modifier) ModEnvironmentConfig.apply(environmentConfig)
                ).iterator()).asScala().toSeq(),
                new ModifierBuffer()
        );
    }

    private int intFromRange(int end) {
        return ThreadLocalRandom.current().nextInt(0, end);
    }

    public GenericRandomPatchListBuilder addPatchBuilder(BiFunction<Seq<Modifier>, ModifierBuffer, Agent> patchBuilder) {
        this.patchBuilders.add(patchBuilder);
        return this;
    }

    public GenericRandomPatchListBuilder setPositionMin(Vector positionMin) {
        this.positionMin = positionMin;
        return this;
    }

    public GenericRandomPatchListBuilder setPositionMax(Vector positionMax) {
        this.positionMax = positionMax;
        return this;
    }

    public GenericRandomPatchListBuilder setBoxSize(Vector boxSize) {
        this.boxSize = boxSize;
        return this;
    }
}
