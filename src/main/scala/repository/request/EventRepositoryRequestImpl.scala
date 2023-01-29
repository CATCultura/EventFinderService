package cat.cultura.eventfinder
package repository.request

import entity.Event
import repository.EventRepository

import akka.event.slf4j.Logger
import cat.cultura.eventfinder.AkkaController.getClass
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.{HttpGet, HttpUriRequest}
import org.apache.http.impl.client.HttpClientBuilder
import org.json4s.*
import org.json4s.native.JsonMethods.*
import org.json4s.native.Serialization
import org.json4s.native.Serialization.{read, write}

import java.io.{BufferedReader, InputStreamReader}
import java.net.http.HttpClient
import java.net.{HttpURLConnection, URL}
import java.util.Base64


class EventRepositoryRequestImpl extends EventRepository {

  private val requestUrl : String = "******************************"

  val logger = Logger(getClass.getName)
  private def base64Encode(user: String, password: String): String = {
    "Basic " + Base64.getEncoder.encodeToString((user + ":" + password).getBytes())
  }

  override def getAll: Set[Event] = {

    implicit val formats: Formats = Serialization.formats(NoTypeHints)
    val content = getRestContent(requestUrl)
    val a : Set[Event] = read[Set[Event]](content)
    a
  }

  private def getRestContent(url: String): String = {

    val httpClient = HttpClientBuilder.create.build
    var a = new HttpGet(url)
    val b = a.addHeader("Authorization",base64Encode("admin","admin"))
    logger.info("Executing the remote request.")
    val ini : Long = System.currentTimeMillis()
    val httpResponse = httpClient.execute(a)
    val end : Long = System.currentTimeMillis()
    logger.info("Response received. Latency of " + (end-ini)/1000  + " seconds")
    val entity = httpResponse.getEntity
    var content = ""
    if (entity != null) {
      val inputStream = entity.getContent
      content = io.Source.fromInputStream(inputStream).getLines.mkString
      inputStream.close()
    }
    httpClient.close()
    content
  }


}
