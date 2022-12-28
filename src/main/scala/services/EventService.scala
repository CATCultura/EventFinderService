package cat.cultura.eventfinder
package services

import entity.Event
import repository.{EventRepository, LocalEventRepository}
import repository.request.EventRepositoryRequestImpl
import utils.Utils

import java.time.ZoneId
import java.util
import java.util.Date


class EventService () {

  private val eventJpaRepository: EventRepositoryRequestImpl = EventRepositoryRequestImpl()

  private val eventRepo: LocalEventRepository = LocalEventRepository()

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
    val result: Set[Event] = eventRepo.getAll
    result
  }

  def getByDistance(lat: Double, long: Double, radius: Double): Set[Event] = {

    val calculator = Utils().getCalculator(lat,long)

    def isActiveToday(event: Event) : Boolean = {
      val today = java.time.LocalDate.now.atStartOfDay(ZoneId.systemDefault()).toLocalDate
      val start: java.time.chrono.ChronoLocalDate = extractDate(event.dataInici)
      val end: java.time.chrono.ChronoLocalDate = extractDate(event.dataFi)
      today.isAfter(start) && today.isBefore(end)
    }

    def isWithinDistance(event: Event) : Boolean = {
      calculator(event.latitud,event.longitud) < radius
    }
    
    val events: Set[Event] = eventRepo.getAll
    events.filter(isActiveToday).filter(isWithinDistance)
  }

}
