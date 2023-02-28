package Sondage

class Sondage(langages: Map[Int, String], resultats: Map[String, List[Int]]) {

  // exemple de paramètres de construction
  // langages = Map(1 -> "Java", 2 -> "Scala", 3 -> "Kotlin", 4 -> "Rust", 5 -> "C", 6 -> "C++", 7 -> "C#", 8 -> "Go")

  //   resultats = Map(
  //    "Alice" -> List(1, 2, 3),
  //    "Bertrand" -> List(1, 2, 4),
  //    "Charles" -> List(4, 5, 6),
  //    "Denise" -> List(2, 4, 5, 6),
  //    "Emilie" -> List(1, 8),
  //    "Fabrice" -> List(1, 2, 3, 7)
  //  )


  //  Associez chaque développeurs avec ces langages préférés
  lazy val developpeursAvecLangage: Map[String, List[String]] = ???


  // Associez chaque langage avec ces développeurs
  lazy val langageAvecDeveloppeurs: Map[String, Set[String]] = ???


  // Renvoyez le ou les langages le plus cités
  def langageMax: Set[String] = ???


  // Renvoyez l'ensemble des inclusions
  // i.e. une paire (l1, l2), tel que tous les développeurs de l1 utilisent également l2
  def inclusions: Set[(String, String)] = ???


}
