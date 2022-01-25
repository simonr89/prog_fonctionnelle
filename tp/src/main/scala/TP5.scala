object TP5Ex1:

  /* La fonction suivante calcule la moyenne d'une liste de nombre. Son évaluation traverse la liste deux fois: une
   * fois pour calculer la somme et une autre pour la longueur. */
  def naiveAverage(l: List[Double]): Double =
    if l.isEmpty then 0.0 else l.sum / l.length

  /* Définissez une fonction qui effectue le même calcul, en ne traversant la liste qu'une seule fois. */
  def onePassAverage(l: List[Double]): Double = ???

  @main def mainTP5Ex1 =
    val r = scala.util.Random
    val l = List.tabulate(1000)(_ => r.nextDouble())
    println("start")
    val start1 = System.nanoTime
    val res1 = naiveAverage(l)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = onePassAverage(l)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(f"Average of list is ${res1}%1.3f")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")


object TP5Ex2:

  /* Définissez une fonction récursive terminale pour calculer la factorielle d'un nombre. */
  def tailRecursiveFactorial(n: BigInt): BigInt = ???

  @main def mainTP5Ex2 =
    val n = 2000
    println("start")
    val start1 = System.nanoTime
    val res1 = TP1Ex1.factorial(n)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = tailRecursiveFactorial(n)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(s"Factorial of ${n} is ${res1}")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")


object TP5Ex3:

  /* Définissez une fonction récursive terminale pour inverser une liste.
   *
   * Quelle est sa complexité? Quelle est la complexité de la version définie dans le TP3? */
  def optimizedReverse[A](l: List[A]): List[A] = ???

  @main def mainTP5Ex3 =
    val r = scala.util.Random
    val l = List.tabulate(4000)(identity)
    println("start")
    val start1 = System.nanoTime
    val res1 = TP3Ex3.reverse(l)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = optimizedReverse(l)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(s"Head of reversed list is ${res1.head}")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")


object TP5Ex4:

  /* Cette fonction calcule le nième nombre de Fibonacci. Quelle est sa complexité? */
  def naiveFibonacci(n: Int): Int =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else if n < 2 then
      n
    else
      naiveFibonacci(n - 1) + naiveFibonacci(n - 2)

  /* Définissez une fonction de complexité linéaire pour calculer le même résultat. */
  def optimizedFibonacci(n: Int): Int = ???

  @main def mainTP5Ex4 =
    val n = 42
    println("start")
    val start1 = System.nanoTime
    val res1 = naiveFibonacci(n)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = optimizedFibonacci(n)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(s"the ${n}th Fibonnaci number is ${naiveFibonacci(n)}")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")


object TP5Ex5:

  /* Définissez une version plus efficace de la fonction d'exponentiation en utilisant l'observation suivante:
   * pour un nombre n, power(b, n) = power(b, n / 2) * power(b, n / 2).
   *
   * Pour un nombre n, combien d'appel récursifs sont effectués par power(b, n), et combien par fastPower(b, n)? */
  def fastExponentiation(b: BigInt, n: Int): BigInt =
    if n < 0 then
      throw new IllegalArgumentException("negative integer")
    else
      ???

  @main def mainTP5Ex5 =
    val b = 3
    val n = 300
    println("start")
    val start1 = System.nanoTime
    val res1 = TP1Ex1.power(b, n)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = fastExponentiation(b, n)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(s"${b} raised to the power of ${n} is ${res1}")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")

object TP5Ex6:
  /* Ces différentes égalités peuvent être utilisées pour réécrire un programme sans en changer le sens */
  // l.map(f).map(g) == l.map(g.compose(f))
  // l.filter(p).filter(q) == l.filter(x => p(x) && q(x))
  // l.reverse.filter(p) == l.filter(p).reverse
  // l.reverse.map(f) == l.map(f).reverse
  // l.reverse.reverse = l
  def dataProcessing(l: List[Double]): List[Double] =
    l.reverse.map(x => math.sin(x)).map(x => x * 2.0).filter(x => x >= 0.0).filter(x => x <= 1.0).reverse

  /* Utilisez-les pour définir une fonction qui calcule la même chose que dataProcessing, mais plus efficacement */
  def optimizedDataProcessing(l: List[Double]): List[Double] = ???

  /* On peut aussi éviter d'établir une liste de résultats intermédiaires lorsqu'un map est suivi d'un filter (ou
   * l'inverse), mais il faudra alors utiliser foldRight pour la réécriture.
   *
   * Compléter les équations suivantes (indication: voir TP3Ex4 pour la formulation de map en termes de foldRight)
   *
   * l.map(f).filter(p) = l.foldRight(???)(???)
   * l.filter(p).map(f) = l.foldRight(???)(???)
   *
   * puis les utiliser pour réécrire optimizedDataprocessing
   */

  @main def mainTP5Ex6 =
    val r = scala.util.Random
    val l = List.tabulate(100000)(_ => r.nextDouble())
    println("start")
    val start1 = System.nanoTime
    val res1 = dataProcessing(l)
    val time1 = System.nanoTime - start1
    val start2 = System.nanoTime
    val res2 = optimizedDataProcessing(l)
    val time2 = System.nanoTime - start2
    assert(res1 == res2)
    println(f"Length of list is ${res1.length}")
    println(f"Computed in ${time1 / 1e6}%1.2f ms with naive function")
    println(f"Computed in ${time2 / 1e6}%1.2f ms with optimized function")