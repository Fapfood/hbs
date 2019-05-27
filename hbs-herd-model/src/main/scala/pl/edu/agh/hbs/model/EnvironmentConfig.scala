package pl.edu.agh.hbs.model

import pl.edu.agh.hbs.model.skill.basic.modifier.ModPosition
import pl.edu.agh.hbs.model.skill.patch.Patch

import scala.collection.mutable

class EnvironmentConfig(val width: Int, val height: Int, val patchWidth: Int, val patchHeight: Int) extends Serializable {
  private val map: mutable.HashMap[Int, Patch] = mutable.HashMap.empty


  def addPatch(position: Vector, patch: Patch): Unit = {
    val xMax = width / patchWidth
    val x = (position.value(0) / patchWidth).toInt
    val y = (position.value(1) / patchHeight).toInt
    val i = y * xMax + x
    map(i) = patch
  }

  def addPatches(patches: Seq[Patch]): Unit = {
    for (patch <- patches) {
      val position = patch.modifiers.getFirst[ModPosition].position
      addPatch(position, patch)
    }
  }

  def getPatch(position: Vector): Patch = {
    val xMax = width / patchWidth
    val x = (position.value(0) / patchWidth).toInt
    val y = (position.value(1) / patchHeight).toInt
    val i = y * xMax + x
    map(i)
  }

  def getPatches: Seq[Patch] = {
    map.values.toSeq
  }

}
