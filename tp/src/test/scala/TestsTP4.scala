import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.shouldBe

import TP4Ex1.*, TP4Ex2.*, TP4Ex3.*
import scala.math.BigInt

class TestsTP4 extends AnyFlatSpec {

  "ListQueue" should "be defined" in {
    val q1 = new ListQueue[Int]().enqueue(1).enqueue(2).enqueue(3)
    q1.peek() shouldBe 1
    val q2 = q1.dequeue().dequeue()
    q2.peek() shouldBe 3
  }

  "DoubleListQueue" should "be defined" in {
    val q1 = new DoubleListQueue[Int]().enqueue(1).enqueue(2).enqueue(3)
    q1.peek() shouldBe 1
    val q2 = q1.dequeue().dequeue()
    q2.peek() shouldBe 3
  }

  "ListSet" should "be defined" in {
    val s1 = new ListSet[Int]()
    s1.elem(0) shouldBe false
    val s2 = s1.add(0).add(1).add(1)
    s2.elem(0) shouldBe true
    s2.elem(1) shouldBe true
    s2.elem(2) shouldBe false
    val s3 = s2.remove(1).add(3)
    s3.elem(3) shouldBe true
    s3.elem(1) shouldBe false
  }

  "BstSet" should "be defined" in {
    // BigInt est une sous-classe de Ordered, contrairement à Int qui utilise Ordering
    val s1 = new BstSet[BigInt]()
    s1.elem(BigInt(0)) shouldBe false
    val s2 = s1.add(BigInt(0)).add(BigInt(1)).add(BigInt(1))
    s2.elem(BigInt(0)) shouldBe true
    s2.elem(BigInt(1)) shouldBe true
    s2.elem(BigInt(2)) shouldBe false
    val s3 = s2.remove(BigInt(1)).add(BigInt(3))
    s3.elem(BigInt(3)) shouldBe true
    s3.elem(BigInt(1))  shouldBe false
  }

  "Fraction" should "be ordered" in {
    val fr1 = new Fraction(1, 4)
    val fr2 = new Fraction(3, 8)
    val fr3 = new Fraction(1,2)
    fr1 < fr2 shouldBe true
    fr2 < fr3 shouldBe true
    fr1 < fr3 shouldBe true
  }

  "Fraction" should "redefine equality and hashCode" in {
    val fr1 = new Fraction(3, 8)
    val fr2 = new Fraction(9, 24)
    fr1 shouldBe fr2
    fr1.hashCode() shouldBe fr2.hashCode()
  }

  "Fraction operations" should "be defined" in {
    val fr1 = new Fraction(1, 4)
    val fr2 = new Fraction(3, 8)
    fr1.negate() shouldBe Fraction(-1, 4)
    fr1.invert() shouldBe Fraction(4, 1)
    fr1.add(fr2) shouldBe Fraction(5, 8)
    fr1.sub(fr2) shouldBe Fraction(-1, 8)
    fr1.mult(fr2) shouldBe Fraction(3, 32)
    fr1.div(fr2) shouldBe Fraction(2, 3)
  }

}
