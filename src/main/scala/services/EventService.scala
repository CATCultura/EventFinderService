package cat.cultura.eventfinder
package services

import entity.Event
import repository.EventRepository
import repository.request.EventRepositoryRequestImpl
import utils.Utils

import java.time.ZoneId
import java.util
import java.util.Date


class EventService () {

  private val eventJpaRepository: EventRepositoryRequestImpl = EventRepositoryRequestImpl()

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

  def getByDistance(lat: Double, long: Double, radius: Double): Set[Event] = {

    def meetsRequirements(event : Event) : Boolean = {
      val today = java.time.LocalDate.now.atStartOfDay(ZoneId.systemDefault()).toLocalDate
      val start: java.time.chrono.ChronoLocalDate = extractDate(event.dataInici)
      val end: java.time.chrono.ChronoLocalDate = extractDate(event.dataFi)

      if (today.isAfter(start) && today.isBefore(end)) {
        if (distanceCalculator(event.latitud, event.longitud, lat, long) < radius) {
          return true
        }
      }
      false
    }

    val events: Set[Event] = eventJpaRepository.getAll
    val r : Set[Event] = events.filter(meetsRequirements)
    r
  }

}
