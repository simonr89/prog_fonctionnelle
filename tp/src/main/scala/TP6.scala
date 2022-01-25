import scala.collection.mutable.PriorityQueue
import scala.math.Ordering.Implicits.*

object TP6Ex1:

  /* une fonction simple avec un effet de bord (println) pour observer l'évaluation */
  def double(n: Int): Int =
    println(s"evaluating double(${n})")
    n + n

  /* Quelle sera la sortie sur la console si on évalue eagerExample(double(1), double(3))?
   * même question avec lazyExample(double(1), double(3))?
   * et si on remplace le premier argument par double(2)?
   *
   * Écrivez un main pour vérifier vos prédictions.
   */
  def eagerExample(n: Int, m: Int): Int =
    if n * n > 5 then m else 0

  def lazyExample(n: => Int, m: => Int): Int =
    if n * n > 5 then m else 0

  @main def mainTP6Ex0 =
    println("eagerExample(double(1), double(3))")
    eagerExample(double(1), double(3))
    println("eagerExample(double(2), double(3))")
    eagerExample(double(2), double(3))
    println("lazyExample(double(1), double(3))")
    lazyExample(double(1), double(3))
    println("lazyExample(double(2), double(3))")
    lazyExample(double(2), double(3))

object TP6Ex2:

  /* Définissez les fonctions booléennes suivantes, qui se comportent comme les opérateurs "court-circuits" && et ||
     (c'est-à-dire que le deuxième argument de l'opérateur ne doit pas être évalué si sa valeur n'est pas nécessaire).
     La définition n'utilisera pas les opérateurs && et || */
  def lazyAnd(l: Boolean, r: Boolean): Boolean = ???

  def lazyOr(l: Boolean, r: Boolean) = ???

object TP6Ex3:

  /* cette fonction génère un stream d'entiers. L'effet de bord (println) permet d'observer son évaluation */
  def myLazyStream(n: Int): LazyList[Int] =
    println(s"evaluating myLazyStream ${n}")
    n #:: myLazyStream(n+1)

  /* observez l'exécution de ce programme. Que pouvez-vous en déduire sur l'évaluation des structures de données
   * infinies telles que LazyList? Quelles sont les conséquences de cette stratégie d'évaluation en terme de temps
   * de calcul et de mémoire?
   */
  @main def mainTP6Ex3 =
    println("giving the name s1 to myLazyStream(3)")
    val s1 = myLazyStream(3)
    println("forcing the evaluation of s1 up to 3 elements")
    val x1 = s1(2)
    println("forcing the evaluation of s1 up to 5 elements")
    val x2 = s1(4)
    println("giving the name s2 to myLazyStream(1)")
    val s2 = myLazyStream(1)
    println("forcing the evaluation of s2 up to 4 elements")
    val x3 = s2(3)

object TP6Ex4:

  /* Définissez les fonctions suivantes sur les streams */

  /* Renvoie vrai si et seulement si l'élément v est contenu dans le stream s */
  def findValue[A](a: A, s: LazyList[A]): Boolean = ???

  /* Étant donné un stream s = [x0, x1, x2...], differenceStream renvoie le stream [x1-x0, x2-x1, , x3-x2...] */
  def differenceStream(s: LazyList[Double]): LazyList[Double] = ???

  /* Étant donné un stream s = [x0, x1, x2...], mapStream(f) renvoie le stream [f(x0), f(x1), , f(x2)...] */
  def mapStream[A,B](s: LazyList[A], f: A => B): LazyList[B] = ???

object TP6Ex5:

  /* Définissez les streams d'entiers suivants: */

  /* La séquence contenant tous les entiers pairs */
  def evenNumbers: LazyList[Int] = ???

  /* La séquence de Fibonacci */
  def fibonacciSequence: LazyList[Int] = ???

  /* La séquence contenant tous les entiers premiers */
  def primes: LazyList[Int] = ???
