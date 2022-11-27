package cat.cultura.eventfinder
package controllers

import entity.Event
import services.EventService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, ResponseBody, RestController}

import org.json4s.*
import org.json4s.native.JsonMethods.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

import scala.::
import scala.collection.LinearSeq
import scala.collection.mutable.ListBuffer

@RestController
class Controller @Autowired()(eventService: EventService){

  implicit val formats: Formats = Serialization.formats(NoTypeHints)

  @GetMapping(value = Array("/events"))
  @ResponseBody
  def greeting(@RequestParam lat : Double, @RequestParam long: Double, @RequestParam radius : Double): String = {
    val a = eventService.getByDistance(lat,long,radius)
    val r = write(a)
    r
  }
}
