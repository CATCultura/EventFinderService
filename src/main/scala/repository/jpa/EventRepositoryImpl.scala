//package cat.cultura.eventfinder
//package repository.jpa
//
//import entity.Event
//import repository.EventRepository
//
//import org.springframework.data.jpa.repository.JpaRepository
//import scala.jdk.CollectionConverters.ListHasAsScala
//
//
//import java.util
//import java.util.UUID
//import javax.transaction.Transactional
//
//@Transactional
//trait EventRepositoryImpl extends EventRepository with JpaRepository[Event, Long]{
//  override def getAll: Set[Event] = {
//    val x = findAll()
//    var aux : Set[Event] = Set()
//    for (i <- x.asScala) {
//      aux  = aux + i
//    }
//    aux
//  }
//}
