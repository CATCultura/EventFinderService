package cat.cultura.eventfinder
package utils

import cat.cultura.eventfinder.utils

import org.scalatest.flatspec.AnyFlatSpec

class UtilsTest extends AnyFlatSpec {

  "Calculation" should "be within 2 km" in {
    val expected : Double = 2224
    val calc : Utils = Utils()
    val res = calc.calculateDistance(45,2,25,3)
    assert((res - 2 <= expected) && (expected <= res + 2))
  }

}
