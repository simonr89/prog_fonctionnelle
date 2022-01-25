import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

import TP6Ex2.*, TP6Ex4.*, TP6Ex5.*

class TestsTP6 extends AnyFlatSpec {

  def exception: Boolean = throw new Exception

  "Lazy boolean operators" should "be defined" in {
    lazyAnd(false, exception) shouldBe false
    lazyAnd(true, false) shouldBe false
    lazyAnd(true, true) shouldBe true
    lazyOr(true, exception) shouldBe true
    lazyOr(false, true) shouldBe true
    lazyOr(false, false) shouldBe false
    an [Exception] should be thrownBy lazyAnd(exception, true)
    an [Exception] should be thrownBy lazyOr(exception, false)
  }

  "Find value" should "be defined" in {
    findValue(3, LazyList.from(0)) shouldBe true
    findValue(3, LazyList()) shouldBe false
  }

  "Difference stream" should "be defined" in {
    differenceStream(LazyList.from(5,3).map(_.toDouble)).take(3) shouldBe LazyList(3.0, 3.0, 3.0)
    differenceStream(LazyList(1.5, 0.5, 3)) shouldBe LazyList(-1.0, 2.5)
  }

  "Map stream" should "be defined" in {
    mapStream(LazyList.from(-2), math.abs).take(5) shouldBe LazyList(2, 1, 0, 1, 2)
  }

  "Even numbers" should "be defined" in {
    evenNumbers.take(5) shouldBe LazyList(0,2,4,6,8)
  }

  "The Fibonacci sequence" should "be defined" in {
    fibonacciSequence.take(10) shouldBe LazyList(0,1,1,2,3,5,8,13,21,34)
  }

  "Primes" should "be defined" in {
    primes.take(10) shouldBe LazyList(2,3,5,7,11,13,17,19,23,29)
  }

}
