package Conway

class Conway(init: Int = 1) {

  // renvoie le rang suivant : List(1, 1) --> List(2, 1)
  def lire(rang : List[Int]) : List[Int] = ???

  // la suite infinie de tout les rangs
  val rangs : LazyList[List[Int]] = ???

  // renvoie le rang sous forme de chaine de caractère
  // attention : rang commence à 1
  def apply(rang: Int): String = ???

}
