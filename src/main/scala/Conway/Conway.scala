package Conway

class Conway(init: Int = 1) {

  def countUntilNxt(nb: Int, rang: List[Int]): Int = rang match {
    case `nb` :: xs => 1 + countUntilNxt(nb, xs)
    case _ => 0
  }

  // renvoie le rang suivant : List(1, 1) --> List(2, 1)
  def lire(rang: List[Int]): List[Int] = rang match {
    case x :: _ =>
      val c = countUntilNxt(x, rang)
      List(c, x).concat(lire(rang.slice(c, rang.size)))

    case x :: Nil => List(x)
    case _ => List()
  }

  // la suite infinie de tout les rangs
  val rangs: LazyList[List[Int]] = LazyList.iterate(List(init))(lire)

  // renvoie le rang sous forme de chaine de caractère
  // attention : rang commence à 1
  def apply(rang: Int): String = {
    def toString(data: List[Int]): String = data match {
      case x :: Nil => x.toString
      case x :: xs => x + " " + toString(xs)
    }

    toString(rangs(rang - 1))
  }

}
