package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity;
import pl.edu.agh.hbs.simulation.agent.SheepAgent;
import pl.edu.agh.hbs.simulation.agent.WolfAgent;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.Step;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.GenericArea;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationConfig;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;
import scala.collection.JavaConverters;

import java.util.*;

public class SheepSimulationConfig implements GenericSimulationConfig {

    private final Representation sheepShape;
    private final Representation wolfShape;

    public SheepSimulationConfig(Representation sheepShape, Representation wolfShape) {
        this.sheepShape = sheepShape;
        this.wolfShape = wolfShape;
    }

    public Collection<Agent> getAgents() {
        return Arrays.asList(
                new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(100, 100)),
                                ModVelocity.apply(Vector.of(5, 15), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(900, 900)),
                                ModVelocity.apply(Vector.of(-5, 15), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1700, 1000)),
                                ModVelocity.apply(Vector.of(5, -15), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ), new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(600, 300)),
                                ModVelocity.apply(Vector.of(8, 14), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ), new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(200, 600)),
                                ModVelocity.apply(Vector.of(-4, 14), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new SheepAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(800, 100)),
                                ModVelocity.apply(Vector.of(9, -10), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new WolfAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(260, 600)),
                                ModVelocity.apply(Vector.of(-8, -13), "standard"),
                                (Modifier) ModRepresentation.apply(wolfShape, Colour.RED)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new WolfAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(700, 250)),
                                ModVelocity.apply(Vector.of(7, 13), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.RED)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                ),
                new WolfAgent(
                        JavaConverters.asScalaIteratorConverter(Arrays.asList(
                                ModPosition.apply(Vector.of(1400, 500)),
                                ModVelocity.apply(Vector.of(-8, 16), "standard"),
                                (Modifier) ModRepresentation.apply(sheepShape, Colour.RED)
                        ).iterator()).asScala().toSeq(),
                        new ModifierBuffer()
                )
        );
    }

    public List<? extends Area> getAreas(Step step) {
        return Collections.singletonList(
                new GenericArea(
                        "area-1",
                        step,
                        new CartesianRectangularBordersDefinition(
                                Vector.of(0, 0),
                                Vector.of(2500, 1500),
                                true,
                                true,
                                true,
                                true
                        ),
                        new LinkedList<>()
                )
        );
    }
}
