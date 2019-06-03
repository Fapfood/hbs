package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModEnvironmentConfig;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.patch.modifier.ModOccupiedArea;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class GenericRandomPatchListBuilder implements GenericAgentListBuilder {

    private List<BiFunction<Seq<Modifier>, ModifierBuffer, Agent>> patchBuilders = new LinkedList<>();
    private Vector positionMin = null;
    private Vector positionMax = null;

    @Override
    public List<Agent> build(SpaceConfig spaceConfig, List<Area> areas) {
        List<Agent> patches = new LinkedList<>();
        Vector min = positionMin == null ? Vector.of(0, 0) : positionMin;
        Vector max = positionMax == null ? Vector.of(spaceConfig.getWidth(), spaceConfig.getHeight()) : positionMax;
        Vector boxSize = Vector.of(spaceConfig.getPatchWidth(), spaceConfig.getPatchHeight());
        for (int i = 0; i < (max.get(0) - min.get(0)) / boxSize.get(0); i++) {
            for (int j = 0; j < (max.get(1) - min.get(1)) / boxSize.get(1); j++) {
                Vector leftBottom = Vector.of(
                        min.get(0) + i * boxSize.get(0),
                        min.get(1) + j * boxSize.get(1)
                );
                Vector position = Vector.of(
                        leftBottom.get(0) + boxSize.get(0) / 2,
                        leftBottom.get(1) + boxSize.get(1) / 2
                );
                Vector rightUpper = Vector.of(
                        leftBottom.get(0) + boxSize.get(0),
                        leftBottom.get(1) + boxSize.get(1)
                );
                Area area = areas.stream().filter(area1 -> area1.isInside(position)).collect(Collectors.toList()).get(0);
                Agent patch = getInstance(position, leftBottom, rightUpper, area);
                patches.add(patch);
            }
        }
        return patches;
    }

    private Agent getInstance(Vector position, Vector leftBottom, Vector rightUpper, Area area) {
        int patchIndex = intFromRange(patchBuilders.size());
        BiFunction<Seq<Modifier>, ModifierBuffer, Agent> patchBuilder = patchBuilders.get(patchIndex);
        return patchBuilder.apply(
                JavaConverters.asScalaIteratorConverter(Arrays.asList(
                        ModPosition.apply(position),
                        ModEnvironmentConfig.apply(area.getConfig()),
                        (Modifier) ModOccupiedArea.apply(leftBottom, rightUpper)
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
}
