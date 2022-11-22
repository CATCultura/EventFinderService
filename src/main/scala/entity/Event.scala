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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name= "id")
  private val _id : Long = 0L

  def id : Long = _id


  @Column(name = "codi")
  private val _codi : Long = 0L

  def codi : Long = _codi

  @Column(name = "dataFi")
  private val _dataFi : String = null

  def dataFi : Option[String] = Option(_dataFi)


  @Column(name = "dataInici")
  private val _dataInici : String = null

  def dataInici : Option[String] = Option(_dataInici)

  @Column(name = "dataFiAprox")
  private val _dataFiAprox : String = null

  def dataFiAprox : String = _dataFiAprox

  @Column(name = "denominacio")
  private val _denominacio : String = null

  def denominacio : String = _denominacio

  @Lob
  @Column(name = "descripcio")
  private val _descripcio : String = null

  def descripcio : String = _descripcio


  @Column(name = "entrades", length = 1024)
  private val _entrades : String = null

  def entrades : String = _entrades

  @Lob
  @Column(name = "horari")
  private val _horari : String = null

  def horari : String = _horari

  @Column(name = "subtitol")
  private val _subtitol : String = null

  def subtitol : String = _subtitol

  @ElementCollection
  @CollectionTable(name = "tagsAmbits", joinColumns = Array(new JoinColumn(name = "id")))
  @Column(name = "tagsAmbits")
  private val _tagsAmbits : java.util.List[String] = null

  def tagsAmbits : java.util.List[String] = _tagsAmbits

  @ElementCollection
  @CollectionTable(name = "tagsCateg", joinColumns = Array(new JoinColumn(name = "id")))
  @Column(name = "tagsCateg")
  private val _tagsCateg : java.util.List[String] = null

  def tagsCateg : java.util.List[String] = _tagsCateg

  @ElementCollection
  @CollectionTable(name = "tagsAltresCateg", joinColumns = Array(new JoinColumn(name = "id")))
  @Column(name = "tagsAltresCateg")
  private val _tagsAltresCateg : java.util.List[String] = null

  def tagsAltresCateg : java.util.List[String] = _tagsAltresCateg

  @Lob
  @Column(name = "links")
  private val _links : String = null

  def links : String = _links

  @Column(name = "documents")
  private val _documents : String = null

  def documents : String = _documents

  @ElementCollection
  @CollectionTable(name = "imatges", joinColumns = Array(new JoinColumn(name = "id")))
  @Column(name = "imatges")
  private val _imatges : java.util.List[String] = null

  def imatges : java.util.List[String] = _imatges

  @Lob
  @Column(name = "videos")
  private val _videos : String = null

  def videos : String = _videos

  @Column(name = "adreca")
  private val _adreca : String = ""

  def adreca : String = _adreca

  @Column(name = "codiPostal")
  private val _codiPostal : Int = 0

  def codiPostal : Int = _codiPostal

  @Column(name = "ubicacio")
  private val _ubicacio : String = null

  def ubicacio : String = _ubicacio

  @Column(name = "email")
  private val _email : String = null

  def email : String = _email

  @Column(name = "espai")
  private val _espai : String = null

  def espai : String = _espai

  @Column(name = "latitud")
  private val _latitud : Double = .0

  def latitud : Double = _latitud

  @Column(name = "longitud")
  private val _longitud : Double = .0

  def longitud : Double = _longitud

  @Column(name = "telf")
  private val _telf : String = null

  def telf : String = _telf

  @Column(name = "URL")
  private val _URL : String = null

  def URL : String = _URL


  @Column(name = "imgApp")
  private val _imgApp : String = null

  def imgApp : String = _imgApp


  @Column(name = "cancelado")
  private val _cancelado: Boolean = false

  def cancelado : Boolean = _cancelado

}
