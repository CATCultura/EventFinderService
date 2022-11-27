package cat.cultura.eventfinder
package utils

import cat.cultura.eventfinder.utils

import org.scalatest.flatspec.AnyFlatSpec

class UtilsTest extends AnyFlatSpec {

  "Calculation" should "be within 2 km" in {
    val expected : Double = 2224
    val calc = Utils()
    val res = calc.calculateDistance(45,2,25,3)
    assert((res - 2 <= expected) && (expected <= res + 2))
  }

  "Closure" should "work ok" in {
    val calc = Utils().getCalculator(5,6)
    val res = calc(5,6)
    assert(0 == calc(5,6))
  }

  "Combination" should "work fine" in {
    val expected: Double = Utils().calculateDistance(45,2,25,3)
    val calc = Utils().getCalculator(45,2)
    val res = calc(25, 3)
    assert(res == expected)
  }

}
