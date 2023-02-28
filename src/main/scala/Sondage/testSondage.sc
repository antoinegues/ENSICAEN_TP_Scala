import Sondage._

val langages = Map(1 -> "Java", 2 -> "Scala", 3 -> "Kotlin", 4 -> "Rust", 5 -> "C", 6 -> "C++", 7 -> "C#", 8 -> "Go")

val resultats = Map(
  "Alice" -> List(1, 2, 3),
  "Bertrand" -> List(1, 2, 4),
  "Charles" -> List(4, 5, 6, 7),
  "Denise" -> List(2, 4, 5, 6, 8),
  "Emilie" -> List(1, 5, 8),
  "Fabrice" -> List(1, 2, 3, 7)
)

val sondage = new Sondage(langages, resultats)

sondage.developpeursAvecLangage

sondage.langageAvecDeveloppeurs

sondage.langageMax

sondage.inclusions