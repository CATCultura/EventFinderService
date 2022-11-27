package cat.cultura.eventfinder
package repository.request

import entity.Event
import repository.EventRepository

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

class EventRepositoryRequestImpl extends EventRepository {

  private val requestUrl : String = "http://localhost:8081/allevents"

  private val hash : String = "eventservice"

  override def getAll: Set[Event] = {

    implicit val formats: Formats = Serialization.formats(NoTypeHints)
    val content = getRestContent(requestUrl)
    val a : Set[Event] = read[Set[Event]](content)
    a
  }

  def getRestContent(url: String): String = {

    val httpClient = HttpClientBuilder.create.build
    var a = new HttpGet(requestUrl)
    val b = a.addHeader("Authorization",hash)
    val httpResponse = httpClient.execute(a)
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
