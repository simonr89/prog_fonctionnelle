import jdk.management.jfr.RecordingInfo

import scala.collection.immutable.List

object TP3Ex1:

  /* La classification des groupes sanguins la plus couramment utilisée se base sur deux systèmes: le système ABO qui
   * distingue les groupes A, B, AB et O, et le système Rhésus, qui distingue les groupes Rh+ et Rh-. En combinant ces
   * deux systèmes on obtient donc 8 possibilités. Créez un ou plusieurs types de données pour modéliser les groupes
   * sanguins. */

  /* Remplacez cette déclaration de type par une définition utilisant 'enum'*/
  type BloodGroup = Nothing

  /* Complétez la fonction suivante */
  def valueOf(s: String): BloodGroup = s match
    case "A+" => ???
    case "B+" => ???
    case "AB+" => ???
    case "O+" => ???
    case "A-" => ???
    case "B-" => ???
    case "AB-" => ???
    case "O-" => ???
    case _ => throw new IllegalArgumentException

  /* Définissez une fonction qui retourne 'true' si et seulement si la transfusion de sang de type 'donor' est possible
   * pour un receveur de type 'recipient' (cf. https://fr.wikipedia.org/wiki/Groupe_sanguin#Compatibilit%C3%A9) */
  def compatible(donor: BloodGroup, recipient: BloodGroup): Boolean = ???


object TP3Ex2:

  /* Ce type de données représente des expressions arithmétiques. */
  enum ArithExpr:
    case Constant(v: Double)
    case Neg(e: ArithExpr)
    case Add(e1: ArithExpr, e2: ArithExpr)
    case Sub(e1: ArithExpr, e2: ArithExpr)
    case Mult(e1: ArithExpr, e2: ArithExpr)

  /* Définissez une fonction pour évaluer une expression arithmétique. */
  def eval(e: ArithExpr): Double = ???


object TP3Ex3:

  /* Définissez les fonctions suivantes sur les listes.
   * Rappel: une liste (de type List[A]) a deux cas possibles:
   * - Nil (la liste vide)
   * - x :: xs (avec x: A et xs: List[A]) */

  /* Retourne la longueur de la liste */
  def length(l: List[Any]): Int = ???

  /* Retourne 'true ' si et seulement si x est contenu dans l */
  def elem[A](x: A, l: List[A]): Boolean = ???

  /* Retourne la liste l privée de la première occurrence de l'élément a (si l'élément n'est pas présent, retourne une
   * une liste identique à l) */
  def remove[A](a: A, l: List[A]): List[A] = ???

  /* Retourne la concaténation de l1 et l2 */
  def append[A](l1: List[A], l2: List[A]): List[A] = ???

  /* Créé une liste contenant exactement n fois l'élément x */
  def replicate[A](x: A, n: Int): List[A] =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else
      ???

  /* Retourne 'true' si et seulement si la liste ne contient pas deux fois le même élément */
  def unique(l: List[Any]): Boolean = ???

  /* Retourne 'true' si et seulement si l1 est une permutation de l2 (c'est-à-dire contient les mêmes éléments, pas
     nécessairement dans le même ordre) */
  def permutation(l1: List[Any], l2: List[Any]): Boolean = ???

  /* Retourne les n premiers éléments de la liste l */
  def take[A](n: Int, l: List[A]): List[A] = ???

  /* Retourne les (length(l) - n) derniers éléments de la liste l */
  def drop[A](n: Int, l: List[A]): List[A] = ???

  /* Retourne la liste l en sens inverse. */
  def reverse[A](l: List[A]): List[A] = ???

  /* Joint deux listes pour former une liste de pairs. La liste retournée sera seulement aussi longue que la plus courte
   * des deux listes passées en argument). */
  def zip[A,B](l1: List[A], l2: List[B]): List[(A,B)] = ???

  /* Trie une liste d'entiers. */
  def sort(l: List[Int]): List[Int] = ???

  /* Prend une liste, dont certains éléments peuvent des listes (elles-même pouvant contenir des listes et ainsi de
   * suite) et qui retourne une version "applatie" de cette liste, c'est-à-dire qui contient les mêmes éléments mais
   * sans listes imbriquées.
   *
   * Indication: utilisez le pattern matching pour vérifier le type des éléments de la liste
   */
  def flatten(l: List[Any]): List[Any] = ???


object TP3Ex4:

  /* Pour une liste l = [x1, ... xn], retourne [f(x1), ..., f(xn)] */
  def map[A,B](f: A => B, l: List[A]): List[B] = ???

  /* Retourne une liste contenant uniquement les éléments x de l qui satisfont p(x) */
  def filter[A](p: A => Boolean, l: List[A]): List[A] = ???

  /* Retourne le plus long segment initial de l tel que tous les éléments x satisfont p(x) */
  def takeWhile[A](p: A => Boolean, l: List[A]): List[A] = ???

  /* Retourne le complément de takeWhile(p, l) (c'est-à-dire que takeWhile(p, l) ::: dropWhile(p, l) == l) */
  def dropWhile[A](p: A => Boolean, l: List[A]): List[A] = ???

  /* Étant donné une constante e, une fonction f, et une liste [x1,x2,...,xn]
   * foldRight retourne f(x1, f(x2, (..., f(xn, e))) */
  def foldRight[A, B](e: B, f: (A, B) => B, l: List[A]): B = l match
    case Nil => e
    case x :: xs => f(x, foldRight(e,f,xs))

  /* utilisez fold pour redéfinir les méthodes length, append, reverse et map */
  def length2(l: List[Any]): Int = ???

  def append2[A](l1: List[A], l2: List[A]) = ???

  def reverse2[A](l: List[A]): List[A] = ???

  def map2[A,B](f: A => B, l: List[A]): List[B] = ???


object TP3Ex5:

  /* On considère un type d'expressions arithmétiques contenant aussi des divisions */
  enum ArithExpr:
    case Constant(v: Double)
    case Neg(e: ArithExpr)
    case Add(e1: ArithExpr, e2: ArithExpr)
    case Sub(e1: ArithExpr, e2: ArithExpr)
    case Mult(e1: ArithExpr, e2: ArithExpr)
    case Div(e1: ArithExpr, e2: ArithExpr)

  /* L'évaluation devra tenir de la possibilité d'une division par 0, et retournera donc un résultat de type
   * Option[Double]. Les deux cas possibles pour ce type sont:
   * - None si l'expression ne peut pas être évaluée
   * - Some(v) avec v: Double si l'expression est évalué à v
   *
   * Commencez à définir la fonction eval. Vous constaterez qu'une grande partie du code se répète pour tester si le
   * résultat d'une évaluation est None ou Some(v). Afin d'éviter cette duplication, vous pouvez définir et utiliser
   * les fonctions suivantes, qui appliquent une fonction (unaire ou binaire) à des arguments de type Option[T].  */
  def liftOption1[A,B](f: A => B, a: Option[A]): Option[B] = ???

  def liftOption2[A,B,C](f: (A, B) => C, a: Option[A], b: Option[B]): Option[C] = ???

  def eval(e: ArithExpr): Option[Double] = ???
