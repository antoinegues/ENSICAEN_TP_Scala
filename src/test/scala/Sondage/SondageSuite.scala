package Sondage

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SondageSuite extends AnyFunSuite with Matchers {

  val langages: Map[Int, String] = Map(1 -> "Java", 2 -> "Scala", 3 -> "Kotlin", 4 -> "Rust", 5 -> "C", 6 -> "C++", 7 -> "C#", 8 -> "Go")

  val resultats: Map[String, List[Int]] = Map(
    "Alice" -> List(1, 2, 3),
    "Bertrand" -> List(1, 2, 4),
    "Charles" -> List(4, 5, 6, 7),
    "Denise" -> List(2, 4, 5, 6, 8),
    "Emilie" -> List(1, 5, 8),
    "Fabrice" -> List(1, 2, 3, 7)
  )

  val s = new Sondage(langages, resultats)

  // question 1
  test("developpeursAvecLangage") {
    s.developpeursAvecLangage shouldBe Map(
      "Alice" -> List("Java", "Scala", "Kotlin"),
      "Bertrand" -> List("Java", "Scala", "Rust"),
      "Charles" -> List("Rust", "C", "C++", "C#"),
      "Denise" -> List("Scala", "Rust", "C", "C++", "Go"),
      "Emilie" -> List("Java", "C", "Go"),
      "Fabrice" -> List("Java", "Scala", "Kotlin", "C#")
    )
  }


  // question 2
  test("langageAvecDeveloppeurs") {
    s.langageAvecDeveloppeurs shouldBe Map(
      "Scala" -> Set("Denise", "Alice", "Bertrand", "Fabrice"),
      "C#" -> Set("Fabrice", "Charles"),
      "Rust" -> Set("Denise", "Charles", "Bertrand"),
      "Go" -> Set("Denise", "Emilie"),
      "C" -> Set("Denise", "Charles", "Emilie"),
      "C++" -> Set("Denise", "Charles"),
      "Kotlin" -> Set("Alice", "Fabrice"),
      "Java" -> Set("Emilie", "Alice", "Bertrand", "Fabrice")
    )
  }

  // question 3
  test("langageMax") {
    s.langageMax shouldBe Set("Scala", "Java")
  }

  // question 4
  test("inclusions") {
    s.inclusions shouldBe Set(
      ("Kotlin", "Java"),
      ("Kotlin", "Scala"),
      ("Go", "C"),
      ("C++", "Rust"),
      ("C++", "C"))
  }

}
