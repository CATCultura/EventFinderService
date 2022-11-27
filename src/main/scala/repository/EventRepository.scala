package cat.cultura.eventfinder
package repository

import entity.Event

import org.springframework.stereotype.Repository


trait EventRepository {

  def getAll: Set[Event]
}
