package ASCIIart

class ASCIIart(val largeur: Int, val hauteur: Int, val liste: List[String]) {

  // renvoie la Map qui associe chaque lettre à son ascii art
  // attention : si la lettre n'est pas définie, il fait renvoyer l'ascii-art du symbole ? fourni en derniere position
  lazy val tableLettre: Map[Char, List[String]] = ???


  // renvoie le mot sous forme d'ascii art
  def apply(mot: String): String = ???


}
