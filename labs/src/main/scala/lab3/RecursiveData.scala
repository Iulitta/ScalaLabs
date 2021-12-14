package lab3 {
  // sealed trait List[A]
  // case class Cons[A](head: A, tail: List[A]) extends List[A]
  // case class Nil[A](value: A) extends List[A]

  // Напишите свои решения в виде функций.
  object RecursiveData {
    // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
    def ListIntEmpty(list: List[Int]): Boolean = list match {
      case Nil => true
      case null => true
      case _ => false
    }

    // Используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
    def testListIntEmpty(list: List[Int]): Boolean = ListIntEmpty(list)

    // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
    def ListIntHead(list: List[Int]): Int = {
      if (ListIntEmpty(list)) -1
      else list.head
    }

    // Используйте функцию из пункта (b) здесь, не изменяйте сигнатуру
    def testListIntHead(list: List[Int]): Int = ListIntHead(list)

    // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
    // Ответ: скорее всего, нет.

    /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
     *      node - левое и правое дерево (Tree)
     *      leaf - переменная типа A
     */
    sealed trait Tree[A]
    case class Node[A](leftNode: Tree[A], rightNode: Tree[A]) extends Tree[A]
    case class Leaf[A](value: A) extends Tree[A]

    // Точка входа в программу
    def main(args: Array[String]): Unit = {
      println("Task a")
      println(testListIntEmpty(List(1, 2, 3)))
      println(testListIntEmpty(List()))
      println(testListIntEmpty(null))
      println("\nTask b")
      println(testListIntHead(List(300, 200, 100)))
      println(testListIntHead(List()))
      println(testListIntHead(null))
    }
  }

}