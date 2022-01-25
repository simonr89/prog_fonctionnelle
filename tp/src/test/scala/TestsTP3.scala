import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe
import TP3Ex1.*
import TP3Ex3.*
import TP3Ex4.*

import scala.math.Numeric.IntIsIntegral

class TestsTP3 extends AnyFlatSpec {

  val precision = 0.0001

  "Blood type comparison" should "be defined" in {
    compatible(valueOf("A-"), valueOf("A+")) shouldBe true
    compatible(valueOf("B+"), valueOf("AB+")) shouldBe true
    compatible(valueOf("O-"), valueOf("B+")) shouldBe true
    compatible(valueOf("AB-"), valueOf("AB-")) shouldBe true
    compatible(valueOf("B+"), valueOf("O-")) shouldBe false
    compatible(valueOf("AB-"), valueOf("A-")) shouldBe false
    compatible(valueOf("A+"), valueOf("A-")) shouldBe false
    compatible(valueOf("O+"), valueOf("B-")) shouldBe false
  }

  "Eval" should "be defined" in {
    import TP3Ex2.*

    val v1 = 0.2
    val e1 = ArithExpr.Constant(v1)
    val v2 = 3.45
    val e2 = ArithExpr.Constant(v2)
    eval(e1) shouldBe v1
    eval(e2) shouldBe v2
    eval(ArithExpr.Neg(e1)) shouldBe -v1
    eval(ArithExpr.Add(e1, e2)) shouldBe v1 + v2
    eval(ArithExpr.Sub(e1, e2)) shouldBe v1 - v2
    eval(ArithExpr.Mult(e1, e2)) shouldBe v1 * v2
    eval(ArithExpr.Add(e2, ArithExpr.Mult(e1, ArithExpr.Sub(e2, e1)))) shouldBe v2 + (v1 * (v2 - v1))
  }
  
  "Length" should "be defined" in {
    length(List()) shouldBe 0
    length(List("lists", "are", "great")) shouldBe 3
  }

  "Elem" should "be defined" in {
    elem(3, List(1,2,3)) shouldBe true
    elem(3, List()) shouldBe false
    elem(4, List(1,2,3)) shouldBe false
  }

  "Remove" should "be defined" in {
    remove(2, List(1,2,3,2)) shouldBe List(1,3,2)
    remove(4, List(1,2,3,2)) shouldBe List(1,2,3,2)
  }

  "Append" should "be defined" in {
    append(List(1,2,3), List(4,5)) shouldBe List(1,2,3,4,5)
  }

  "Replicate" should "be defined" in {
    replicate("a", 3) shouldBe List("a","a","a")
  }

  "Unique" should "be defined" in {
    unique(List(1,2,3,4)) shouldBe true
    unique(List(1,2,3,4,2)) shouldBe false
  }

  "Permutation" should "be defined" in {
    permutation(List(1,2,3,4), List(2,3,4,1)) shouldBe true
    permutation(List(1,2,3,5), List(2,3,4,1)) shouldBe false
    permutation(List(1,2,3,4,2), List(1,2,3,4)) shouldBe false
  }

  "Take" should "be defined" in {
    take(3, List(1,2,3,4,5)) shouldBe List(1,2,3)
    take(6, List(1,2,3,4,5)) shouldBe List(1,2,3,4,5)
  }

  "Drop" should "be defined" in {
    drop(3, List(1,2,3,4,5)) shouldBe List(4,5)
    drop(6, List(1,2,3,4,5)) shouldBe List()
  }

  "Reverse" should "be defined" in {
    reverse(List(8,4,6,2,3)) shouldBe List(3,2,6,4,8)
  }

  "Zip" should "be defined" in {
    zip(List("one", "two", "three"), List(1,2,3)) shouldBe List(("one", 1), ("two", 2), ("three", 3))
    zip(List("one", "two", "three"), List(1,2)) shouldBe List(("one", 1), ("two", 2))
    zip(List("one", "two"), List(1,2,3)) shouldBe List(("one", 1), ("two", 2))
  }

  "Sort" should "be defined" in {
    sort(List(7,6,5,1,3)) shouldBe List(1,3,5,6,7)
  }

  "Flatten" should "be defined" in {
    flatten(List(1, List(2, 3, List(4)), 5, List(6, 7))) shouldBe List(1,2,3,4,5,6,7)
  }

  "Map" should "be defined" in {
    map((x: Int) => x * 2, List(1,2,3,4,5)) shouldBe List(2,4,6,8,10)
    map((s: String) => s.length, List("maps", "are", "awesome")) shouldBe List(4,3,7)
  }

  "Filter" should "be defined" in {
    filter((x: Int) => x % 2 == 0, List(1,2,3,4,5,6)) shouldBe List(2,4,6)
    filter((s: String) => s != "frakkin", List("maps", "are", "frakkin", "awesome")) shouldBe List("maps", "are", "awesome")
  }

  "TakeWhile" should "be defined" in {
    takeWhile((x: Int) => x >= 0, List(1,2,-3,4,-5,6)) shouldBe List(1,2)
  }

  "DropWhile" should "be defined" in {
    dropWhile((x: Int) => x >= 0, List(1,2,-3,4,-5,6)) shouldBe List(-3,4,-5,6)
  }

  "Length2" should "be defined" in {
    length2(List()) shouldBe 0
    length2(List("lists", "are", "great")) shouldBe 3
  }

  "Append2" should "be defined" in {
    append2(List(1,2,3), List(4,5)) shouldBe List(1,2,3,4,5)
  }

  "Reverse2" should "be defined" in {
    reverse2(List(8,4,6,2,3)) shouldBe List(3,2,6,4,8)
  }

  "Map2" should "be defined" in {
    map2((x: Int) => x * 2, List(1,2,3,4,5)) shouldBe List(2,4,6,8,10)
    map2((s: String) => s.length, List("maps", "are", "awesome")) shouldBe List(4,3,7)
  }

  "Eval with division" should "be defined" in {
    import TP3Ex5.*

    val v1 = 0.2
    val e1 = ArithExpr.Constant(v1)
    val v2 = 3.45
    val e2 = ArithExpr.Constant(v2)
    val v3 = 0.0
    val e3 = ArithExpr.Constant(v3)
    eval(e1) shouldBe Some(v1)
    eval(e2) shouldBe Some(v2)
    eval(ArithExpr.Neg(e1)) shouldBe Some(-v1)
    eval(ArithExpr.Add(e1, e2)) shouldBe Some(v1 + v2)
    eval(ArithExpr.Sub(e1, e2)) shouldBe Some(v1 - v2)
    eval(ArithExpr.Mult(e1, e2)) shouldBe Some(v1 * v2)
    eval(ArithExpr.Div(e1, e2)) shouldBe Some(v1 / v2)
    eval(ArithExpr.Div(e1, e3)) shouldBe None
    eval(ArithExpr.Div(ArithExpr.Add(e2, ArithExpr.Mult(e1, ArithExpr.Sub(e2, e1))), e1)) shouldBe Some((v2 + (v1 * (v2 - v1))) / v1)
    eval(ArithExpr.Div(e2, ArithExpr.Sub(e1, e1))) shouldBe None
  }

}
