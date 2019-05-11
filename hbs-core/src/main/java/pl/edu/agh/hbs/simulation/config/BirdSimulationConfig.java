package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity;
import pl.edu.agh.hbs.simulation.agent.BirdAgent;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.GenericArea;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfig;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;
import scala.collection.JavaConverters;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BirdSimulationConfig implements GenericSimulationConfig {

    private final Representation birdShape;

    public BirdSimulationConfig(Representation birdShape) {
        this.birdShape = birdShape;
    }

    @Override
    public Collection<Agent> getAgents() {
        return Arrays.asList(
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(100, 100)),
                                ModVelocity.apply(Vector.of(5, 15), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(600, 300)),
                                ModVelocity.apply(Vector.of(8, 14), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(200, 600)),
                                ModVelocity.apply(Vector.of(-4, 14), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(800, 100)),
                                ModVelocity.apply(Vector.of(9, -10), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(260, 800)),
                                ModVelocity.apply(Vector.of(-8, -13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(700, 900)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(500, 800)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(900, 900)),
                                ModVelocity.apply(Vector.of(-5, 15), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1150, 400)),
                                ModVelocity.apply(Vector.of(5, -15), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1400, 500)),
                                ModVelocity.apply(Vector.of(-8, 16), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1200, 250)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1300, 300)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1300, 800)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1800, 800)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1700, 1200)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new BirdAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1700, 1000)),
                                ModVelocity.apply(Vector.of(5, -15), "standard"),
                                (Modifier) ModRepresentation.apply(birdShape, Colour.ORANGE)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                )
        );
    }

    @Override
    public List<? extends Area> getAreas(Step step) {
        return Arrays.asList(
                new GenericArea(
                        "area-1",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(0, 0),
                                Vector.of(1000, 1500),
                                true,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>()
                ),
                new GenericArea(
                        "area-2",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(1000, 0),
                                Vector.of(2000, 1500),
                                false,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>()
                )
        );
    }
}
