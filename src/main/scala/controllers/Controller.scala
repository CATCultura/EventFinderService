package cat.cultura.eventfinder
package controllers

import entity.Event
import services.EventService

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

import scala.::
import scala.collection.LinearSeq
import scala.collection.mutable.ListBuffer

@RestController
class Controller @Autowired()(eventService: EventService){

  @GetMapping(value = Array("/events"))
  def greeting(@RequestParam lat : Double, @RequestParam long: Double, @RequestParam radius : Double): String = {
    val a = eventService.getByDistance(lat,long,radius)

    var res  = new String()
    val gson = Gson()
    for (i <- a) {
      res += gson.toJson(i) + ",\n"
    }
    res = res.dropRight(2)
    res = "[" + res + "\n]"
    res
  }
}
