package cat.cultura.eventfinder
package entity

val ph : String = "No info provided"

case class EventHelper(
                  dataInici: Option[String],
                  dataFi: Option[String],
                  dataFiAprox: String = "false",
                  denominacio: String,
                  descripcio: String = ph,
                  entrades: String = ph,
                  horari: String = ph,
                  subtitol: String = ph,
                  tagsAmbits: List[String],
                  tagsCateg: List[String],
                  tagsAltresCateg: List[String],
                  links: String = ph,
                  documents: String = ph,
                  imatges : List[String],
                  videos : String = ph,
                  adreca : String = ph,
                  codiPostal : String = "0",
                  ubicacio : String,
                  email : String = ph,
                  espai : String = ph,
                  latitud : String = "0.0",
                  longitud : String = "0.0",
                  telf : String = ph,
                  url : String = ph,
                  imgApp : String = ph
                ) {
  def toEvent: Event = {
    val e : Event = Event (
      this.dataInici,
      dataFi,
      dataFiAprox,
      denominacio,
      descripcio,
      entrades,
      horari,
      subtitol,
      tagsAmbits,
      tagsCateg,
      tagsAltresCateg,
      links,
      documents,
      imatges,
      videos,
      adreca,
      if (!codiPostal.isBlank) codiPostal.toInt else 0,
      ubicacio,
      email,
      espai,
      latitud.toDouble,
      longitud.toDouble,
      telf,
      url,
      imgApp
    )
    e
  }
}
