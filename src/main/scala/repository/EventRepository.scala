package cat.cultura.eventfinder
package repository

import entity.Event

trait EventRepository {

  def getAll: Set[Event]
}
