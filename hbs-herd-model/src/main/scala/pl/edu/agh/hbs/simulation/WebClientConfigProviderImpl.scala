package pl.edu.agh.hbs.simulation

import pl.edu.agh.hbs.ui.dto.Colour
import pl.edu.agh.hbs.ui.{Representation, WebClientConfigProvider}

class WebClientConfigProviderImpl(val width: Int, val height: Int, val colour: Colour, val representations: Representation*) extends WebClientConfigProvider {

  override def getConfigString: String = "{\"width\":" + width + ", \"height\":" + height + ", \"color\":\"" + colour.getValue + "\", \"config\":[" + representations.map(r => r.getConfig).mkString(",") + "]}"

  override def getWidth: Int = width

  override def getHeight: Int = height
}
