package EnsemblesFonctions

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class EnsembleFonctionSuite extends AnyFunSuite with Matchers {

  val ensemblePair: Ensemble = (x: Int) => x % 2 == 0

  test("contient fonctionne") {
    contient(x => true, 1000) shouldBe true
    contient(ensemblePair, 10) shouldBe true
    contient(ensemblePair, 9) shouldBe false
  }

  test("ensemblePositif contient des éléments positifs") {
    contient(ensemblePositif, 1000) shouldBe true
    contient(ensemblePositif, 10) shouldBe true
    contient(ensemblePositif, 0) shouldBe true

    contient(ensemblePositif, -1000) shouldBe false
    contient(ensemblePositif, -10) shouldBe false
    contient(ensemblePositif, -1) shouldBe false
  }


  test("ensemble10a20 contient des éléments de 10 à 20") {
    contient(ensemble10a20, 10) shouldBe true
    contient(ensemble10a20, 15) shouldBe true
    contient(ensemble10a20, 20) shouldBe true

    contient(ensemble10a20, -1000) shouldBe false
    contient(ensemble10a20, 0) shouldBe false
    contient(ensemble10a20, 21) shouldBe false
  }

  test("singleton(x) contient x") {
    contient(singleton(1), 1) shouldBe true
    contient(singleton(2), 1) shouldBe false

    contient(singleton(1), 2) shouldBe false
    contient(singleton(2), 2) shouldBe true
  }

  test("union contient ces éléments") {
    val s = union(ensemblePair, ensemblePositif)

    contient(s, -2) shouldBe true
    contient(s, -1) shouldBe false
    contient(s, 1) shouldBe true
    contient(s, 2) shouldBe true
    contient(s, 3) shouldBe true
  }

  test("intersection contient ces éléments") {
    val s = intersection(ensemblePair, ensemblePositif)

    contient(s, -2) shouldBe false
    contient(s, -1) shouldBe false
    contient(s, 1) shouldBe false
    contient(s, 2) shouldBe true
    contient(s, 3) shouldBe false
  }

  test("difference contient ces éléments") {
    val s = difference(ensemblePair, ensemblePositif)

    contient(s, -2) shouldBe true
    contient(s, -1) shouldBe false
    contient(s, 1) shouldBe false
    contient(s, 2) shouldBe false
    contient(s, 3) shouldBe false
  }

  test("complement contient ces éléments") {
    val s = complement(ensemblePositif)

    contient(s, -2) shouldBe true
    contient(s, -1) shouldBe true
    contient(s, 1) shouldBe false
    contient(s, 2) shouldBe false
    contient(s, 3) shouldBe false
  }


  test("filter") {
    val s = filtrer(ensemblePositif, x => x <= 2)

    contient(s, -1) shouldBe false
    contient(s, 1) shouldBe true
    contient(s, 2) shouldBe true
    contient(s, 3) shouldBe false
  }

  test("pourTout") {
    pourTout(ensemblePositif, x => x > -10) shouldBe true
    pourTout(ensemblePositif, x => x < 10) shouldBe false
  }

  test("ilExiste") {
    ilExiste(ensemblePositif, x => x < 2) shouldBe true
    ilExiste(ensemblePositif, x => x > 2) shouldBe true
    ilExiste(ensemblePositif, x => x > 0) shouldBe true
    ilExiste(ensemblePositif, x => x < 0) shouldBe false
  }

  test("image") {
    val s = image(ensemblePair, x => x * x)

    pourTout(s, x => x >= 0) shouldBe true

    contient(s, 1) shouldBe false
    contient(s, 2) shouldBe false
    contient(s, 3) shouldBe false
    contient(s, 4) shouldBe true
    contient(s, 9) shouldBe false
    contient(s, 16) shouldBe true
    contient(s, 25) shouldBe false
    contient(s, 36) shouldBe true
    contient(s, 42) shouldBe false
  }

}
