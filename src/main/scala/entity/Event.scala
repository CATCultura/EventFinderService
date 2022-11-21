package cat.cultura.eventfinder
package entity


import java.util
import java.util.List
import javax.persistence.{Access, AccessType, CollectionTable, Column, ElementCollection, Entity, GeneratedValue, GenerationType, Id, JoinColumn, Lob, Table}

@Entity
@Table(name="event")
@Access(value=AccessType.FIELD)
class Event {


  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
//  @Column(name= "id")
  var id : Long = 0L

//  @Column(name = "codi") private var codi : Long = 0L
//
//  @Column(name = "dataFi") private var dataFi : String = ""

//  @Column(name = "dataInici") private var dataInici = null
//
//  @Column(name = "dataFiAprox") private var dataFiAprox = null
//
//  @Column(name = "denominacio")
  private var denominacio : String = null

  def getDenominacio : String = denominacio
//
//  @Lob
//  @Column(name = "descripcio")
  private var descripcio : String = null

  def getDescripcio : String = descripcio
//
//  @Column(name = "entrades", length = 1024) private var entrades = null
//
//  @Lob
//  @Column(name = "horari") private var horari = null
//
//  @Column(name = "subtitol") private var subtitol = null
//
//  @ElementCollection
//  @CollectionTable(name = "tagsAmbits", joinColumns = Array(new JoinColumn(name = "id")))
//  @Column(name = "tagsAmbits") private var tagsAmbits = null
//
//  @ElementCollection
//  @CollectionTable(name = "tagsCateg", joinColumns = Array(new JoinColumn(name = "id")))
//  @Column(name = "tagsCateg") private var tagsCateg = null
//
//  @ElementCollection
//  @CollectionTable(name = "tagsAltresCateg", joinColumns = Array(new JoinColumn(name = "id")))
//  @Column(name = "tagsAltresCateg") private var tagsAltresCateg = null
//
//  @Lob
//  @Column(name = "links") private var links = null
//
//  @Column(name = "documents") private var documents = null
//
//  @ElementCollection
//  @CollectionTable(name = "imatges", joinColumns = Array(new JoinColumn(name = "id")))
//  @Column(name = "imatges") private var imatges = null
//
//  @Lob
//  @Column(name = "videos")
  private var videos : String = null
//
//  @Column(name = "adreca")
  private var adreca : String = ""
//
//  @Column(name = "codiPostal")
  private var codiPostal : Int = 0
//
//  @Column(name = "ubicacio")
  private var ubicacio : String = null

  def getUbicacio : String = ubicacio
//
//  @Column(name = "email")
  private var email : String = null
//
//  @Column(name = "espai")
  private var espai = ""
//
//  @Column(name = "latitud")
    val latitud = .0
//
//  @Column(name = "longitud")
    val longitud = .0
//
//  @Column(name = "telf") private var telf = null
//
//  @Column(name = "URL") private var URL = null
//
//  @Column(name = "imgApp") private var imgApp = null
//
//
//  @Column(name = "cancelado") private var cancelado = false

}
