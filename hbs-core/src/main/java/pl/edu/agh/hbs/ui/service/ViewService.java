package pl.edu.agh.hbs.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.patch.Patch;
import pl.edu.agh.hbs.state.SimulationStateProvider;
import pl.edu.agh.hbs.ui.Representation;
import pl.edu.agh.hbs.ui.dto.Body;
import pl.edu.agh.hbs.ui.dto.Colour;
import pl.edu.agh.hbs.ui.dto.ViewFrame;
import pl.edu.agh.hbs.ui.dto.ViewPosition;

import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class ViewService {

    private final SimulationStateProvider stateProvider;

    @Autowired
    public ViewService(final SimulationStateProvider stateProvider) {
        this.stateProvider = checkNotNull(stateProvider);
    }

    /**
     * Prepares {@link ViewFrame} for current simulation state
     *
     * @return frame with all agents state
     */
    public ViewFrame prepareViewFrame() {
        List<Body> patches = new LinkedList<>();
        List<Body> bodies = new LinkedList<>();
        stateProvider.getAllAgents().forEach(agent -> {
            final Vector position = agent.position();
            final Representation representation = agent.representation();
            final Colour colour = agent.colour();
            final ViewPosition viewPosition = new ViewPosition((int) position.get(0), (int) position.get(1));
            if (Patch.class.isAssignableFrom(agent.getClass())) {
                patches.add(new Body(
                        viewPosition,
                        colour.getValue(),
                        representation.getIdentity(),
                        (int) agent.rotation()));
            } else {
                bodies.add(new Body(
                        viewPosition,
                        colour.getValue(),
                        representation.getIdentity(),
                        (int) agent.rotation()));
            }
        });
        patches.addAll(bodies);
        return new ViewFrame(patches);
    }
}
