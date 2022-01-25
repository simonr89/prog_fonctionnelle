import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.{an, shouldBe, be}
import TP1Ex1.*

class TestsTP1 extends AnyFlatSpec {

  "Not" should "be defined" in {
    not(true) shouldBe false
    not(false) shouldBe true
  }

  "And" should "be defined" in {
    and(true, true) shouldBe true
    and(true, false) shouldBe false
    and(false, true) shouldBe false
    and(false, false) shouldBe false
  }

  "Or" should "be defined" in {
    or(true, true) shouldBe true
    or(true, false) shouldBe true
    or(false, true) shouldBe true
    or(false, false) shouldBe false
  }

  "Xor" should "be defined" in {
    xor(true, true) shouldBe false
    xor(true, false) shouldBe true
    xor(false, true) shouldBe true
    xor(false, false) shouldBe false
  }

  "Absolute value" should "be defined" in {
    abs(48.548) shouldBe 48.548
    abs(-573.79) shouldBe 573.79
  }

  "Factorial" should "be defined" in {
    factorial(0) shouldBe 1
    factorial(1) shouldBe 1
    factorial(6) shouldBe 720
    an [IllegalArgumentException] should be thrownBy factorial(-3)
  }

  "Exponentiation" should "be defined for positive exponents" in {
    power(0, 0) shouldBe 1
    power(1, 217) shouldBe 1
    power(2, 10) shouldBe 1024
    power(-2, 9) shouldBe -512
    an [IllegalArgumentException] should be thrownBy power(5, -3)
  }

  "Sum of segment" should "be defined" in {
    sumSegment(3, 6) shouldBe 18
    sumSegment(14, 14) shouldBe 14
    sumSegment(6, 5) shouldBe 0
    sumSegment(-4,-2) shouldBe -9
    sumSegment(-8,8) shouldBe 0
  }

  "Fast sum of segment" should "be defined" in {
    fastSumSegment(3, 6) shouldBe 18
    fastSumSegment(14, 14) shouldBe 14
    fastSumSegment(6, 5) shouldBe 0
    fastSumSegment(-4,-2) shouldBe -9
    fastSumSegment(-8,8) shouldBe 0
  }

  "Binary representation" should "be defined" in {
    binaryString(0) shouldBe "0"
    binaryString(2) shouldBe "10"
    binaryString(157) shouldBe "10011101"
    binaryString(-8) shouldBe "-1000"
  }

  "Euclid's algorithm" should "be defined for positive numbers" in {
    gcd(63, 15) shouldBe 3
    gcd(33, 35) shouldBe 1
    gcd(0, 7) shouldBe 0
  }

  it should "be defined for negative numbers" in {
    gcd(-63, 15) shouldBe 3
    gcd(63, -15) shouldBe 3
    gcd(-63, -15) shouldBe 3
  }


}
