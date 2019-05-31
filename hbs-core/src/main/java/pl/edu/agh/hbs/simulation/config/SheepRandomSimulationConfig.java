package pl.edu.agh.hbs.simulation.config;

import pl.edu.agh.hbs.model.skill.Modifier;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.model.skill.diPatch.modifier.ModTerrain;
import pl.edu.agh.hbs.simulation.generic.builders.*;
import pl.edu.agh.hbs.simulation.generic.config.GenericSimulationConfigWithBuilder;
import pl.edu.agh.hbs.simulation.species.GrassSpecies;
import pl.edu.agh.hbs.simulation.species.SheepSpecies;
import pl.edu.agh.hbs.simulation.species.WolfSpecies;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Colour;
import scala.collection.JavaConverters;
import scala.collection.Seq;

import java.util.LinkedList;
import java.util.List;

public class SheepRandomSimulationConfig extends GenericSimulationConfigWithBuilder {

    private Representation sheepShape;
    private Representation wolfShape;
    private Representation grassShape;

    public SheepRandomSimulationConfig(Representation sheepShape, Representation wolfShape, Representation grassShape) {
        this.sheepShape = sheepShape;
        this.wolfShape = wolfShape;
        this.grassShape = grassShape;
    }

    @Override
    public GenericAgentListBuilder getAgentsBuilder() {
        GenericAgentListBuilder sheepBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(0)
                .setRepresentation(ModRepresentation.apply(sheepShape, Colour.WHITE))
                .setAgentBuilder(SheepSpecies::newAgent);
        GenericAgentListBuilder wolfBuilder = new GenericSingleSpeciesAgentListBuilder()
                .setNumber(0)
                .setRepresentation(ModRepresentation.apply(wolfShape, Colour.BLACK))
                .setAgentBuilder(WolfSpecies::newAgent);
        return new GenericCombinedAgentListBuilder()
                .addAgentsBuilder(sheepBuilder)
                .addAgentsBuilder(wolfBuilder);
    }

    @Override
    public GenericAgentListBuilder getPatchBuilder() {
        return new GenericRandomPatchListBuilder()
                .addPatchBuilder((seq, buffer) -> {
                    List<Modifier> modifierList = new LinkedList<>(JavaConverters.seqAsJavaList(seq));
                    modifierList.add(ModRepresentation.apply(grassShape, Colour.GREEN));
                    modifierList.add(ModTerrain.apply("grass"));
                    Seq<Modifier> modifierSeq = JavaConverters.asScalaIteratorConverter(modifierList.iterator()).asScala().toSeq();
                    return GrassSpecies.newAgent(modifierSeq, buffer);
                })
                .addPatchBuilder((seq, buffer) -> {
                    List<Modifier> modifierList = new LinkedList<>(JavaConverters.seqAsJavaList(seq));
                    modifierList.add(ModRepresentation.apply(grassShape, Colour.BROWN));
                    modifierList.add(ModTerrain.apply("earth"));
                    Seq<Modifier> modifierSeq = JavaConverters.asScalaIteratorConverter(modifierList.iterator()).asScala().toSeq();
                    return GrassSpecies.newAgent(modifierSeq, buffer);
                });
    }

    @Override
    public GenericAreaListBuilder getAreasBuilder() {
        return new RandomAreaListBuilder().setNumberOfAreas(2L);
    }
}
