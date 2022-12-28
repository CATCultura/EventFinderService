package cat.cultura.eventfinder
package entity

case class Event(
    dataInici: Option[String],
    dataFi: Option[String],
    dataFiAprox: String,
    denominacio: String,
    descripcio: String,
    entrades: String,
    horari: String,
    subtitol: String,
    tagsAmbits: List[String],
    tagsCateg: List[String],
    tagsAltresCateg: List[String],
    links: String,
    documents: String,
    imatges : List[String],
    videos : String,
    adreca : String,
    codiPostal : Int,
    ubicacio : String,
    email : String,
    espai : String,
    latitud : Double,
    longitud : Double,
    telf : String,
    url : String,
    imgApp : String
    )
