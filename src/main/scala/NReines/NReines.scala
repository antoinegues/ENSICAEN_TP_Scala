package NReines

class NReines(val n: Int) {


  def _estOK(col: Int, reines: List[Int], deep: Int): Boolean = reines match {
    case Nil => true
    case `col` :: _ => false
    case x :: _ if col + deep == x || col - deep == x => false;
    case _ :: xs => _estOK(col, xs, deep + 1)
  }

  // Question 1 :
  // étant donnée la position des reines précedentes, renvoye vrai si la colone est compatible
  lazy val estOk: (Int, List[Int]) => Boolean = (col: Int, reines: List[Int]) => _estOK(col, reines, 1)

  def cS(set: Set[List[Int]]): Set[List[Int]] = {
    for {
      list <- set
      col <- 0 until n
      if estOk(col, list)
    } yield col :: list
  }

  def cS2(deep: Int): Set[List[Int]] = deep match {
    case 0 => Set(List())
    case _ => cS(cS2(deep - 1))
  }


  // Question 2
  // calcule la liste des solutions
  lazy val solutions: Set[List[Int]] = cS2(n)

  // Question 3
  // Retourne le nombre de solutions
  lazy val nombreSolutions: Int = solutions.size

  def _getSymbol(pos: Int): Char = pos match {
    case 0 => 'X'
    case _ => 'O'
  }
  def _afficheSolutionLigne(pos: Int, deep: Int): String = deep match {
    case 0 => _getSymbol(pos).toString
    case _ => _getSymbol(pos) + " " + _afficheSolutionLigne(pos - 1, deep - 1)
  }

  // question 4
  // transforme une solution en un String afichable
  def afficheSolution(solution: List[Int]): String = solution match {
    case x::xs if xs.nonEmpty => _afficheSolutionLigne(x, n-1) +"\n" + afficheSolution(xs)
    case x::_ => _afficheSolutionLigne(x, n-1)
  }

  def afficheToutesSolutions(): Unit = for {
    (solution, i) <- solutions.zipWithIndex
  } println(s"Solution N°${i + 1} :\n " + afficheSolution(solution))


}
