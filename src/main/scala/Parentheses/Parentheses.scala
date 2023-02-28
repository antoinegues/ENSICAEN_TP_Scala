package object Parentheses {

  def _equilibreGenerique(CO: Char, CF: Char, charList: List[Char], compteur: Int): Boolean = charList match {
    case Nil => compteur == 0
    case CF :: _ if (compteur == 0) => false
    case CO :: _ if (compteur < 0) => false
    case CF :: xs => _equilibreGenerique(CO, CF, xs, compteur - 1)
    case CO :: xs => _equilibreGenerique(CO, CF, xs, compteur + 1)
    case _ :: xs => _equilibreGenerique(CO, CF, xs, compteur)
  }

  // Écrire une fonction récursive qui indique si une phrase dispose de parenthèses bien construite
  lazy val equilibre: String => Boolean = (phrase) => equilibreGenerique('(', ')')(phrase)

  // pareil, mais générique
  def equilibreGenerique(co: Char, cf: Char)(phrase: String): Boolean = phrase.toList match {
    case liste => _equilibreGenerique(co, cf, liste, 0)
    case Nil => true
    case _ => false
  }

  // utiliser la fonction générique pour définir la version xml avec < et > comme caractère ouvrant/fermant
  lazy val equilibreXml: String => Boolean = (phrase) => equilibreGenerique('<', '>')(phrase)

}
