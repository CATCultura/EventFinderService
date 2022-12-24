package cat.cultura.eventfinder

import services.EventService

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.event.slf4j.Logger
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
import cat.cultura.eventfinder.entity.Event
import org.json4s.*
import org.json4s.native.JsonMethods.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write, writePretty}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object AkkaController {

  private val eventService: EventService = EventService()
  implicit val formats: Formats = Serialization.formats(NoTypeHints)

  def main(args: Array[String]): Unit = {


    implicit val system: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext: ExecutionContextExecutor = system.executionContext
    val logger = Logger(getClass.getName)



    val route =
      get {
        path("events") {
          parameters("lat".as[Double], "long".as[Double], "radius".as[Double]) {
            (lat, long, radius) => {
              logger.info("Received request with params: " + lat + " " + long + " " + radius)
              val ini = System.currentTimeMillis()
              val a = eventService.getByDistance(lat, long, radius)
              logger.info("A total of " + a.size + " events meet the requirements")
              val r = writePretty[Set[Event]](a)
              val end = System.currentTimeMillis()
              logger.info("Total service time: " + (end-ini)/1000 + " seconds")
              complete(r)
            }
          }
        } //path

      } //get

    val bindingFuture = Http().newServerAt("0.0.0.0", 8082).bind(route)
  }
}
