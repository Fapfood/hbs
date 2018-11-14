package pl.edu.agh.hbs.core.model.domain;

import pl.edu.agh.hbs.core.model.domain.step.Step;
import pl.edu.agh.hbs.model.Agent;
import pl.edu.agh.hbs.model.Vector;
import pl.edu.agh.hbs.model.skill.Message;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Area implements Serializable {

    private final String areaId;
    private final AreaBordersDefinition areaBordersDefinition;
    private final Collection<Agent> agents;
    private final Collection<Message> messages;
    private final Collection<String> neighourAreas;
    private transient final Step step;

    public Area(String areaId, Step step, AreaBordersDefinition areaBordersDefinition, Collection<Agent> agents) {
        this.areaId = areaId;
        this.step = step;
        this.agents = Collections.newSetFromMap(new ConcurrentHashMap<>());
        this.messages = Collections.newSetFromMap(new ConcurrentHashMap<>());
        this.neighourAreas = Collections.newSetFromMap(new ConcurrentHashMap<>());
        this.areaBordersDefinition = areaBordersDefinition;

        this.agents.addAll(agents);
    }

    public String getAreaId() {
        return areaId;
    }

    public Collection<Agent> getAgents() {
        return agents;
    }

    public void addAgent(Agent agent) {
        this.agents.add(agent);
    }

    public void removeAgent(Agent agent) {
        this.agents.remove(agent);
    }

    public Step getStep() {
        return step;
    }

    public void addMessages(Collection<Message> messages) {
        this.messages.addAll(messages);
    }

    public void clearMessages() {
        this.messages.clear();
    }

    public Collection<Message> getMessages() {
        return Collections.unmodifiableCollection(messages);
    }

    public AreaBordersDefinition getAreaBordersDefinition() {
        return areaBordersDefinition;
    }

    public boolean isInside(Vector position) {
        return this.areaBordersDefinition.isInside(position);
    }

    public Collection<String> getNeighourAreas() {
        return neighourAreas;
    }

    public void addNeigbourAreas(Collection<String> areas) {
        this.neighourAreas.addAll(areas);
    }

    public Vector getBottomLeftCornerPosition() {
        return areaBordersDefinition.getBottomLeftPosition();
    }

    public Vector getUpperRightCornerPosition() {
        return areaBordersDefinition.getUpperRightPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(areaId, area.areaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaId);
    }
}
