package pl.edu.agh.hbs.model.skill.move

import pl.edu.agh.hbs.model.Agent
import pl.edu.agh.hbs.model.skill.move.action.ActMove
import pl.edu.agh.hbs.model.skill.move.decision.DecMove

trait MovingAgent extends Agent {
  this.decisions += DecMove
  this.actions += ActMove
}
