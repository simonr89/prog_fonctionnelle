import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers._

import TP2Ex1.*, TP2Ex4.*

class TestsTP2 extends AnyFlatSpec {

  val precision = 0.001

  "An empty table" should "associate every word to 0" in {
    valueInTable(emptyTable, "scala") shouldBe 0
  }

  "Table update" should "be defined" in {
    valueInTable(updateTable(emptyTable, "scala", 3), "scala") shouldBe 3
    valueInTable(updateTable(emptyTable, "scala", 3), "java") shouldBe 0
  }

  "An empty set" should "be empty" in {
    import TP2Ex2.*

    elem(15, emptySet) shouldBe false
  }

  "A singleton set" should "have exactly one element" in {
    import TP2Ex2.*

    val s = singleton(3)
    elem(3, s) shouldBe true
    elem(4, s) shouldBe false
  }

  "Set operations" should "be defined" in {
    import TP2Ex2.*

    val multiplesOf2: IntSet = (x: Int) => x % 2 == 0
    val multiplesOf3: IntSet = (x: Int) => x % 3 == 0
    elem(12, intersection(multiplesOf2, multiplesOf3)) shouldBe true
    elem(9, intersection(multiplesOf2, multiplesOf3)) shouldBe false
    elem(8, union(multiplesOf2, multiplesOf3)) shouldBe true
    elem(7, union(multiplesOf2, multiplesOf3)) shouldBe false
    elem(5, complement(multiplesOf2)) shouldBe true
    elem(9, complement(multiplesOf3)) shouldBe false
    elem(16, difference(multiplesOf2, multiplesOf3)) shouldBe true
    elem(15, difference(multiplesOf2, multiplesOf3)) shouldBe false
  }

  "Cartesian product" should "be defined" in {
    import TP2Ex2.*, TP2Ex3.*

    val s1: IntSet = TP2Ex2.singleton(3)
    val s2: IntSet = (x: Int) => x % 3 == 0
    TP2Ex3.elem(3, 6, cartesianProduct(s1, s2)) shouldBe true
    TP2Ex3.elem(3, 18, cartesianProduct(s1, s2)) shouldBe true
    TP2Ex3.elem(3, 5, cartesianProduct(s1, s2)) shouldBe false
    TP2Ex3.elem(2, 6, cartesianProduct(s1, s2)) shouldBe false
  }

  "Function operations" should "be defined" in {
    val f1 = constant(3.0)
    eval(f1, 0.0) shouldBe (3.0 +- precision)
    eval(f1, 2.0) shouldBe (3.0 +- precision)
    val f2 = monomial(5.0, 2)
    eval(f2, 0.0) shouldBe (0.0 +- precision)
    eval(f2, 2.0) shouldBe (20.0 +- precision)

    eval(negate(f2), 0.0) shouldBe (0.0 +- precision)
    eval(negate(f2), 2.0) shouldBe (-20.0 +- precision)
    eval(add(f1,f2), 0.0) shouldBe (3.0 +- precision)
    eval(add(f1,f2), 2.0) shouldBe (23.0 +- precision)
    eval(sub(f1,f2), 0.0) shouldBe (3.0 +- precision)
    eval(sub(f1,f2), 2.0) shouldBe (-17.0 +- precision)
    eval(mult(f1,f2), 0.0) shouldBe (0.0 +- precision)
    eval(mult(f1,f2), 2.0) shouldBe (60.0 +- precision)
    eval(div(f2,f1), 0.0) shouldBe (0.0 +- precision)
    eval(div(f2,f1), 2.0) shouldBe (20.0 / 3.0 +- precision)
  }

  "Function derivation" should "be defined" in {
    val delta = 0.0001

    val f1 = constant(5.0)
    val d1 = approximateDerivative(f1, delta)
    eval(d1, 27.0) shouldBe (0.0 +- precision)

    val f2 = monomial(5.0, 2)
    val d2 = approximateDerivative(f2, delta)
    eval(d2, -1.0) shouldBe (-10.0 +- precision)
    eval(d2, 27.0) shouldBe (270.0 +- precision)
  }

}
