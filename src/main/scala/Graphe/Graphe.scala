package Graphe

case class Noeud(nom: String)

case class Arc(extremite1: String, extremite2: String)

case class Graphe(noeuds: Set[Noeud], arcs: Set[Arc]) {

  // ajout d'un arc
  def +(arc: Arc): Graphe = ???

  // ajout d'un autre graphe
  def +(autre: Graphe): Graphe = ???

  // les voisins d'un noeud
  def voisins(noeud: Noeud): Set[Noeud] = ???

  // le nombre de voisins d'un noeud
  def degre(noeud: Noeud): Int = ???

  // le nombre de triangle dans le graphe
  lazy val nombreTriangle: Int = ???

  // la distance du chemin le plus court, s'il existe, entre depart et arrive
  def distance(depart: Noeud, arrive: Noeud): Option[Int] = ???

  // l'ensemble des composantes connexes du graphes
  lazy val composantesConnexes: Set[Set[Noeud]] = ???

  // le graphe est-il bi-coloriable
  lazy val estBicoloriable: Boolean = ???

}
