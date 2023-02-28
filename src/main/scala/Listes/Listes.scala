


package object Listes {

  // définir une méthode qui renvoie le dernier élément d'une liste s'il existe
  // s'il n'existe pas, on génére une exception NoSuchElementException
  @throws[NoSuchElementException]
  def dernier[T](liste: List[T]): T = liste match {
    case Nil => throw new NoSuchElementException
    case x :: Nil => x
    case _ :: xs => dernier(xs)
  }

  // définir une méthode qui renvoie le k-ieme élément d'une liste, en commençant par 0, s'il existe
  // s'il n'existe pas, on génére une exception IndexOutOfBoundsException
  @throws[IndexOutOfBoundsException]
  def kieme[T](liste: List[T], k: Int): T = liste match {
    case Nil => throw new IndexOutOfBoundsException()
    case x::_ if(k ==0) => x
    case _::xs => kieme(xs, k-1)
  }

  // définir une méthode qui renvoie le nombre d'élément de la liste
  def taille[T](liste: List[T]): Int = liste match {
    case Nil => 0
    case _::xs => taille(xs) + 1
  }


  // définir une méthode qui renvoie true si l'élément x est présent dans la liste
  def contient[T](liste: List[T], x: T): Boolean = liste match {
    case Nil => false
    case head::_ if(head == x) => true
    case _::xs  =>  contient(xs, x)
  }

  // méthode custom pour manipuler les listes
  def concat[T](liste1: List[T], liste2: List[T]): List[T] = liste1 match {
    case x::Nil => x::liste2
    case d::xs => d::concat(xs, liste2)
  }

  // définir une méthode qui renvoie une nouvelle liste avec le k-ième élement supprimé
  // si k <= 0, on supprime le premier élément
  // si k>= taille, on renvoie la même liste
  def supprimerKieme[T](liste: List[T], k: Int): List[T] = liste match {
    case Nil if(k <= 0) => liste
    case _::xs if(k <= 0) => xs
    case _ if(k >= taille(liste)) => liste
    case x::xs => x::supprimerKieme(xs, k-1)
  }



  // définir une méthode qui renvoie une nouvelle liste avec l'élément e en k-ième position
  // si k <= 0, on l'ajoute en premier élément
  // si k>= taille, on l'ajoute en dernier
  def ajouterKieme[T](liste: List[T], k: Int, e: T): List[T] = liste match {
    case _ if (k <= 0) => e::liste
    case Nil => List(e)
    case x :: xs => x :: ajouterKieme(xs, k - 1, e)
  }

  // définir une méthode qui renvoie true si les deux listes sont identiques
  def identique[T](liste1: List[T], liste2: List[T]): Boolean = liste1 match {
    case Nil if(liste2.isEmpty) => true
    case Nil => false
    case _ if(liste2.isEmpty) => false
    case x::xs if(x == liste2.head) => identique(xs, liste2.tail)
    case _::_ => false
  }

  // définir une méthode qui renvoie une nouvelle liste en ne gardant que les éléments qui renvoie true au prédicat
  def filtrer[T](liste: List[T], predicat: T => Boolean): List[T] = liste match {
    case Nil => liste
    case x::xs if(predicat(x)) => x::filtrer(xs, predicat)
    case _::xs => filtrer(xs, predicat)
  }

  // définir une méthode qui renvoie une nouvelle liste où les éléments sont les résultats de f
  def image[T, U](liste: List[T], f: T => U): List[U] = liste match {
    case Nil => List()
    case x::xs => f(x)::image(xs, f)
  }




}
