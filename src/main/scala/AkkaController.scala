package cat.cultura.eventfinder

import services.EventService

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.*
import akka.http.scaladsl.server.Directives.*
import org.json4s.*
import org.json4s.native.JsonMethods.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

import scala.io.StdIn

object AkkaController {

  val eventService: EventService = EventService()
  implicit val formats: Formats = Serialization.formats(NoTypeHints)

  def main(args: Array[String]): Unit = {


    implicit val system = ActorSystem(Behaviors.empty, "my-system")
    // needed for the future flatMap/onComplete in the end
    implicit val executionContext = system.executionContext



    val route =
      get {
        path("events") {
          parameters("lat".as[Double], "long".as[Double], "radius".as[Double]) {
            (lat, long, radius) => {
              val a = eventService.getByDistance(lat, long, radius)
              val r = write(a)
              complete(r)
            }
          }
        } //path

      } //get

    val bindingFuture = Http().newServerAt("0.0.0.0", 8082).bind(route)
  }
}
