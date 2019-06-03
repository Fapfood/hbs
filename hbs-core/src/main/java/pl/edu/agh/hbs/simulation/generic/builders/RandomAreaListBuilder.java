package pl.edu.agh.hbs.simulation.generic.builders;

import pl.edu.agh.hbs.model.EnvironmentConfig;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.GenericArea;
import pl.edu.agh.hbs.simulation.generic.config.SpaceConfig;

import java.util.LinkedList;
import java.util.List;

public class RandomAreaListBuilder implements GenericAreaListBuilder {

    private Vector positionMin;
    private Vector positionMax;
    private Long numberOfAreas;

    @Override
    public List<Area> build(Step step, SpaceConfig spaceConfig) {
        List<Area> areas = new LinkedList<>();
        Vector min = positionMin == null ? Vector.of(0, 0) : positionMin;
        Vector max = positionMax == null ? Vector.of(spaceConfig.getWidth(), spaceConfig.getHeight()) : positionMax;
        long areasInRow = Math.round(Math.floor(Math.sqrt(numberOfAreas)));
        long areasInColumn = numberOfAreas / areasInRow;
        Vector areaMax = Vector.of(max.get(0) - min.get(0), max.get(1) - min.get(1));
        Vector areaSize = Vector.of(areaMax.get(0) / areasInColumn, areaMax.get(1) / areasInRow);
        for (int i = 0; i < areasInRow; i++) {
            for (int j = 0; j < areasInColumn; j++) {
                Vector leftBottom = Vector.of(
                        min.get(0) + j * areaSize.get(0),
                        min.get(1) + i * areaSize.get(1)
                );
                Vector rightUpper = Vector.of(
                        leftBottom.get(0) + areaSize.get(0),
                        leftBottom.get(1) + areaSize.get(1)
                );
                Area area = new GenericArea(
                        "area" + ((i * areasInColumn) + j),
                        step,
                        new CartesianRectangularBordersDefinition(
                                leftBottom,
                                rightUpper,
                                j == 0,
                                true,
                                true,
                                i == 0
                        ),
                        new LinkedList<>(),
                        new EnvironmentConfig(spaceConfig.getWidth(), spaceConfig.getHeight(), spaceConfig.getPatchWidth(), spaceConfig.getPatchHeight())
                );
                areas.add(area);
            }
        }
        return areas;
    }


    public RandomAreaListBuilder setPositionMin(Vector positionMin) {
        this.positionMin = positionMin;
        return this;
    }

    public RandomAreaListBuilder setPositionMax(Vector positionMax) {
        this.positionMax = positionMax;
        return this;
    }

    public RandomAreaListBuilder setNumberOfAreas(Long numberOfAreas) {
        this.numberOfAreas = numberOfAreas;
        return this;
    }
}
