package cat.cultura.eventfinder
package services

import entity.Event
import repository.EventJpaRepository
import utils.Utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.time.ZoneId
import java.util
import java.util.Date

@Service
class EventService @Autowired()(eventJpaRepository: EventJpaRepository) {

  private val distanceCalculator = Utils().calculateDistance

  private def extractDate(date : Option[String]) : java.time.chrono.ChronoLocalDate = {
    val format = java.text.SimpleDateFormat("yyyy-mm-dd")

    if (date.isDefined) {
      format.parse(date.get.substring(0,10)).toInstant.atZone(ZoneId.systemDefault()).toLocalDate
    }
    else {
      java.time.LocalDate.now.atStartOfDay(ZoneId.systemDefault()).toLocalDate
    }
  }

  def getAll: Set[Event] = {
    val result: Set[Event] = eventJpaRepository.getAll
    result
  }

  def getByDistance(lat: Double, long: Double, radius: Double): java.util.List[Event] = {
    val events: Set[Event] = eventJpaRepository.getAll
    val result: java.util.List[Event] = util.ArrayList[Event]

    val today = java.time.LocalDate.now.atStartOfDay(ZoneId.systemDefault()).toLocalDate

    for (i <- events) {
      val start : java.time.chrono.ChronoLocalDate = extractDate(i.dataInici)
      val end : java.time.chrono.ChronoLocalDate = extractDate(i.dataFi)

      if (today.isAfter(start) && today.isBefore(end)) {
        if (distanceCalculator(i.latitud, i.longitud, lat, long) < radius) {
          result.add(i)
        }
      }
    }
    result
  }

}
