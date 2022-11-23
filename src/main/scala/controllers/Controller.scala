package cat.cultura.eventfinder
package controllers

import entity.Event
import services.EventService

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, ResponseBody, RestController}

import scala.::
import scala.collection.LinearSeq
import scala.collection.mutable.ListBuffer

@RestController
class Controller @Autowired()(eventService: EventService){

  @GetMapping(value = Array("/events"))
  @ResponseBody
  def greeting(@RequestParam lat : Double, @RequestParam long: Double, @RequestParam radius : Double): java.util.List[Event] = {
    val a = eventService.getByDistance(lat,long,radius)
    a
  }
}
