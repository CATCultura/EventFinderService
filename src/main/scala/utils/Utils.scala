package cat.cultura.eventfinder
package utils

import org.springframework.stereotype.Service

class Utils {

  def calculateDistance(latFrom: Double, longFrom: Double, latTo: Double, longTo: Double): Double = {
    def toRadians(value : Double) : Double = value*math.Pi/180

    val latFromR = toRadians(latFrom)
    val longFromR = toRadians(longFrom)
    val latToR = toRadians(latTo)
    val longToR = toRadians(longTo)

    val earthRadius = 6371e3
    val a = math.pow(math.sin((math.abs(latFromR - latToR)) / 2), 2) +
        math.cos(latFromR) * math.cos(latToR) *
        math.pow(math.sin((math.abs(longFromR - longToR)) / 2), 2)
    val c = 2 * math.atan2(math.sqrt(a), math.sqrt((1 - a)))
    val d = earthRadius * c
    d/1000
  }
}
