package cat.cultura.eventfinder
package repository

import entity.{Event, EventHelper}

import org.json4s.{Formats, NoTypeHints}
import org.json4s.native.Serialization
import org.json4s.native.Serialization.read

class LocalEventRepository extends EventRepository {

  implicit val formats: Formats = Serialization.formats(NoTypeHints)
  override def getAll: Set[Event] = {
    val file = scala.io.Source.fromFile("data/current_data.json", "UTF8")
    val str = file.mkString
    val a: Set[EventHelper] = read[Set[EventHelper]](str)
    val res = a.map(_.toEvent)
    res
  }


}
