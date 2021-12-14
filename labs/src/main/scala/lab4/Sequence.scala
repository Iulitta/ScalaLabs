package lab4 {
    import scala.annotation.tailrec

/* Напишите свои решения в тестовых функциях.
 * Seq(1, 2) match {
 *   case head +: tail => ???
 *   case Nil          => ???
 *   case s            => ???
 * }
 * https://www.scala-lang.org/api/2.12.0/scala/collection/Seq.html
 */
    // Примечание: напишите функции с хвостовой рекурсией
    object Sequence {
        // a) Найдите последний элемент Seq.
        def testLastElement[A](seq: Seq[A]): Option[A] = {
            seq match {
                case head :: tail => Some(seq.last)
                case Nil => None
                case null => None
            }
        }

        // b) Объедините две Seqs (то есть Seq(1, 2) и Seq(3, 4) образуют Seq((1, 3), (2, 4))) -
        // если Seq длиннее игнорируйте оставшиеся элементы.
        def testZip[A](a: Seq[A], b: Seq[A]): Seq[(A, A)] = a.zip(b)

        // c) Проверьте, выполняется ли условие для всех элементов в Seq.
        def testForAll[A](seq: Seq[A])(cond: A => Boolean): Boolean = seq.forall(cond)

        // d) Проверьте, является ли Seq палиндромом
        def testPalindrom[A](seq: Seq[A]): Boolean = {
            @tailrec
            def loop(se: Seq[A], num: Int): Int = {
                se.length match {
                    case 0 => num
                    case 1 => num
                    case _ => {
                        if (se.head == se.last) loop(se.tail.init, num + 1)
                        else num
                    }
                }
            }
            val n = loop(seq, 0)
            if (n == (seq.length / 2)) true
            else false
        }

        // e) Реализуйте flatMap используя foldLeft.
        def testFlatMap[A, B](seq: Seq[A])(f: A => Seq[B]): Seq[B] = {
            def operation(out: Seq[B], in: A): Seq[B] = {
                val result = f(in)
                @tailrec
                def loop(output: Seq[B], input: Seq[B]): Seq[B] = input.length match {
                    case 0 => output
                    case _ => loop(output :+ input.head, input.tail)
                }
                loop(out, result)
            }
            seq.foldLeft(Seq.empty[B])(operation)
        }

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testLastElement(Seq(1, 2, 3, 4, 5)))
            println(testLastElement(Seq.empty[Int]))
            println(testLastElement(null))
            println("\nTask b")
            println(testZip(Seq(1, 2), Seq(3, 4)))
            println(testZip(Seq(3, 4, 5), Seq(6, 7, 8, 9)))
            println("\nTask c")
            def predicate(in: Int): Boolean = in < 10
            println(testForAll(Seq(1, 5, 9))(predicate))
            println(testForAll(Seq(1, 11, 9))(predicate))
            println("\nTask d")
            println(testPalindrom(Seq(1, 2, 3, 3, 2, 1)))
            println(testPalindrom(Seq(1, 2, 5, 2, 1)))
            println(testPalindrom(Seq(1, 2, 10, 12, 1)))
            println("\nTask e")
            def func(in: String): Seq[Char] = in.toUpperCase.toSeq
            println(testFlatMap(Seq("One", "Two", "Three"))(func))
        }
    }

}