package pl.edu.agh.hbs.core.service;

import org.assertj.core.groups.Tuple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.edu.agh.hbs.core.model.ui.cartesian.ViewFrame;
import pl.edu.agh.hbs.core.model.ui.cartesian.ViewPosition;
import pl.edu.agh.hbs.core.state.SimulationStateProvider;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.representation.elm.shape.BoxShape;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition;
import pl.edu.agh.hbs.model.skill.basic.modifier.ModRepresentation;
import pl.edu.agh.hbs.simulation.Human;
import scala.collection.JavaConverters;

import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ViewServiceTest {

    @Mock
    private SimulationStateProvider stateProvider;

    @InjectMocks
    private ViewService viewService;

    @Test
    public void shouldPrepareCorrectFrame() {
        // given
        final Human humanA = prepareHumanWithBoxShape(3, 3, 5);
        final Human humanB = prepareHumanWithBoxShape(1, 3, 5);
        final Human humanC = prepareHumanWithBoxShape(2, 6, 1);
        given(stateProvider.getAllAgents()).willReturn(Arrays.asList(humanA, humanB, humanC));

        // when
        final ViewFrame frame = viewService.prepareViewFrame();

        // then
        then(frame.getBodies())
                .extracting("position", "kind")
                .contains(
                        Tuple.tuple(toViewPosition(humanA.position()), humanA.representation().getIdentity()),
                        Tuple.tuple(toViewPosition(humanB.position()), humanB.representation().getIdentity()),
                        Tuple.tuple(toViewPosition(humanC.position()), humanC.representation().getIdentity()));
    }

    private Human prepareHumanWithBoxShape(int factor, int posX, int posY) {
        return new Human(JavaConverters.asScalaBuffer(
                Arrays.asList(
                        new ModRepresentation(new BoxShape(factor)),
                        new ModPosition(Vector.of(posX, posY)))));
    }

    private ViewPosition toViewPosition(Vector position) {
        int[] arrayPosition = position.toArray();
        return new ViewPosition(arrayPosition[0], arrayPosition[1]);
    }
}