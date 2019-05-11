package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.ModifierBuffer;
import pl.edu.agh.hbs.model.representation.elm.Shape;
import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.common.modifier.ModVelocity;
import pl.edu.agh.hbs.simulation.agent.WolfAgent;
import pl.edu.agh.hbs.simulation.api.Area;
import pl.edu.agh.hbs.simulation.api.AreaBordersDefinition;
import pl.edu.agh.hbs.simulation.cartesian.CartesianRectangularBordersDefinition;
import pl.edu.agh.hbs.simulation.generic.GenericArea;
import pl.edu.agh.hbs.simulation.generic.GenericAreaStep;
import pl.edu.agh.hbs.simulation.generic.GenericSimulationMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.simulation.agent.SheepAgent;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.ui.dto.Colour;
import scala.collection.JavaConverters;
import scala.collection.Seq;

public class SheepSimulationConfig extends GenericSimulationMap {
    public SheepSimulationConfig(GenericAreaStep step, Shape sheep, Shape wolf, ModifierBuffer modifierBuffer) {
        super(getAreas(step, sheep, wolf, modifierBuffer));
    }

    private static List<? extends Area> getAreas(GenericAreaStep step, Shape sheepShape, Shape wolfShape, ModifierBuffer modifierBuffer){
        LinkedList<GenericArea> areas = new LinkedList<>();
        Seq<Modifier> modifierSeq1 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(100,100)),
                ModVelocity.apply(Vector.of(5,15), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq2 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(900,900)),
                ModVelocity.apply(Vector.of(-5,15), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq3 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(1700,1000)),
                ModVelocity.apply(Vector.of(5,-15), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq4 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(600,300)),
                ModVelocity.apply(Vector.of(8,14), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq5 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(200,600)),
                ModVelocity.apply(Vector.of(-4,14), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq6 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(800,100)),
                ModVelocity.apply(Vector.of(9,-10), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.GREEN)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq7 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(260,600)),
                ModVelocity.apply(Vector.of(-8,-13), "standard"),
                (Modifier) ModRepresentation.apply(wolfShape, Colour.RED)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq8 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(700,250)),
                ModVelocity.apply(Vector.of(7,13), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.RED)
        ).iterator()).asScala().toSeq();
        Seq<Modifier> modifierSeq9 = JavaConverters.asScalaIteratorConverter(Arrays.asList(
                ModPosition.apply(Vector.of(1400,500)),
                ModVelocity.apply(Vector.of(-8,16), "standard"),
                (Modifier) ModRepresentation.apply(sheepShape, Colour.RED)
        ).iterator()).asScala().toSeq();
        Agent agent1 = new SheepAgent(
                modifierSeq1,
                modifierBuffer
        );
        Agent agent2 = new SheepAgent(
                modifierSeq2,
                modifierBuffer
        );
        Agent agent3 = new SheepAgent(
                modifierSeq3,
                modifierBuffer
        );
        Agent agent4 = new SheepAgent(
                modifierSeq4,
                modifierBuffer
        );
        Agent agent5 = new SheepAgent(
                modifierSeq5,
                modifierBuffer
        );
        Agent agent6 = new SheepAgent(
                modifierSeq6,
                modifierBuffer
        );
        Agent agent7 = new WolfAgent(
                modifierSeq7,
                modifierBuffer
        );
        Agent agent8 = new WolfAgent(
                modifierSeq8,
                modifierBuffer
        );
        Agent agent9 = new WolfAgent(
                modifierSeq9,
                modifierBuffer
        );
        Collection<Agent> agents = new LinkedList<>();
        agents.add(agent1);
        agents.add(agent2);
        agents.add(agent3);
        agents.add(agent4);
        agents.add(agent5);
        agents.add(agent6);
        agents.add(agent7);
        agents.add(agent8);
        agents.add(agent9);
        AreaBordersDefinition areaBordersDefinition = new CartesianRectangularBordersDefinition(
                Vector.of(0,0),
                Vector.of(2500,1500),
                true,
                true,
                true,
                true
        );
        GenericArea area = new GenericArea(
                "area-1",
                step,
                areaBordersDefinition,
                agents
        );
        areas.add(area);
        return areas;
    }

}
