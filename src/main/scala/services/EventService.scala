package cat.cultura.eventfinder
package services

import entity.Event

import cat.cultura.eventfinder.repository.EventJpaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util

@Service
class EventService @Autowired()(eventJpaRepository: EventJpaRepository) {

  def getAll: Set[Event] = {
    val resu: Set[Event] = eventJpaRepository.getAll
    resu
  }

}
