package cat.cultura.eventfinder
package controllers

import entity.Event
import services.EventService
import utils.Utils

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{GetMapping, RequestParam, RestController}

import scala.::
import scala.collection.LinearSeq
import scala.collection.mutable.ListBuffer

@RestController
class Controller @Autowired()(eventService: EventService){

  @GetMapping(value = Array("/greeting"))
  def greeting(@RequestParam lat : Double, @RequestParam long: Double, @RequestParam radius : Double): String = {
    val a = eventService.getAll
    val u = Utils()
    var res  = new String()
    val gson = Gson()
    for (i <- a) {
      if (u.calculateDistance(i.latitud,i.longitud,lat,long) < radius) {
        res += gson.toJson(i) + ",\n"
      }
    }
    res = res.dropRight(2)
    res = "[" + res + "\n]"
    res
  }
}
