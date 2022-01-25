import scala.math

object TP4Ex1:

  /* Ce trait définit le type de données abstrait d'une queue (first-in-first-out) */
  trait Queue[A]:
    def enqueue(a: A): Queue[A]
    def dequeue(): Queue[A]
    def peek(): A
    def isEmpty(): Boolean

  /* Donnez une définition concrète à ce type de données. Quelle est la complexité des différentes opérations? */
  class ListQueue[A](l: List[A] = Nil) extends Queue[A]:

    override def enqueue(a: A): Queue[A] = ???

    override def dequeue(): Queue[A] = ???

    override def peek(): A = ???

    override def isEmpty(): Boolean = ???

  /* Afin d'améliorer la complexité, on peut utiliser une implémentation basée sur deux listes:
   * - front contient les premiers éléments ajoutés, de telle manière que front.head est le plus ancien élément de la
   *   queue
   * - rear contient les derniers éléments ajoutés, de telle manière que rear.head est le plus récent élément ajouté
   *   (l'ordre des élément est donc l'inverse de celui de front)
   *
   * Implémentez les différentes opérations, de manière à maintenir ces invariants.
   * Note: on peut aussi ajouter l'invariant suivant (pas obligatoire, mais il permet de simplifier certains cas)
   * - front n'est vide que si toute la queue est vide (c'est-à-dire si rear l'est aussi)
   */
  class DoubleListQueue[A](front: List[A] = Nil, rear: List[A] = Nil) extends Queue[A]:

    override def enqueue(a: A): Queue[A] = ???

    override def dequeue(): Queue[A] = ???

    override def peek(): A = ???

    override def isEmpty(): Boolean = ???

object TP4Ex2:

  /* Ce trait définit le type de données abstrait d'un ensemble. */
  trait Set[A]:
    def elem(a: A): Boolean
    def add(a: A): Set[A]
    def remove(a: A): Set[A]

  /* Donnez une définition concrète à ce type, basée sur une liste. */
  class ListSet[A](l: List[A] = Nil) extends Set[A]:

    override def elem(a: A): Boolean = ???

    override def add(a: A): Set[A] = ???

    override def remove(a: A): Set[A] = ???

  /* Nous allons définir une implémentation plus efficace spécialement pour les types qui héritent du trait Ordered
   * (sur lesquels on peut utiliser les comparaisons <, <=, >= et >) basées sur un arbre binaire de recherche.
   * Pour cela on commence par définir un type de données algébrique pour les arbres binaires, et les opérations
   * associées.
   * Rappel: un arbre t est un arbre binaire de recherche si:
   * - t un arbre vide Leaf(), ou
   * - t est une Branch(x, l, r) qui satisfait les 3 conditions suivantes:
   *   (1) toutes les valeurs dans l'arbre l sont strictement inférieures à x
   *   (2) toutes les valeurs dans l'arbre r sont strictement supérieures à x
   *   (3) l et r sont des arbres binaires de recherche
   */
  enum BinaryTree[A <: Ordered[A]]:
    case Leaf()
    case Branch(x: A, left: BinaryTree[A], right: BinaryTree[A])

  def elemBST[A <: Ordered[A]](t: BinaryTree[A], a: A): Boolean = ???

  def addBST[A <: Ordered[A]](t: BinaryTree[A], a: A): BinaryTree[A] = ???

  def removeBST[A <: Ordered[A]](t: BinaryTree[A], a: A): BinaryTree[A] = ???

  /* Utilisez le type de données BinaryTree pour implémenter la classe suivante qui implémente Set. */
  class BstSet[A <: Ordered[A]](t: BinaryTree[A] = BinaryTree.Leaf[A]()) extends Set[A]:

    override def elem(a: A): Boolean = ???

    override def add(a: A): Set[A] = ???

    override def remove(a: A): Set[A] = ???


object TP4Ex3:

  /* Définissez la classe Fraction qui implémente Ordered. */
  class Fraction(val num: Int, val denum: Int) extends Ordered[Fraction]:

    def negate(): Fraction = ???

    def invert(): Fraction = ???

    def add(that: Fraction): Fraction = ???

    def sub(that: Fraction): Fraction = ???

    def mult(that: Fraction): Fraction = ???

    def div(that: Fraction): Fraction = ???

    override def compare(that: Fraction): Int = ???

    /* compare doit être compatible avec l'égalité: this.compare(that) retourne 0 si et seulement si this == that */
    override def equals(obj: Any): Boolean = ???

    /* deux objets égaux doivent avoir le même hashCode */
    override def hashCode(): Int = ???

