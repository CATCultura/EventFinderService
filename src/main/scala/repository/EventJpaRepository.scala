package cat.cultura.eventfinder
package repository

import cat.cultura.eventfinder.entity.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

import javax.transaction.Transactional

trait EventJpaRepository {

  def getAll: Set[Event] 
}
