package lab3 {
    import scala.annotation.tailrec

    /* Реализуйте функции для решения следующих задач.
     * Примечание: Попытайтесь сделать все функции с хвостовой рекурсией, используйте аннотацию для подтверждения.
     * Рекурсия будет хвостовой если:
     * 1. Рекурсия реализуется в одном направлении
     * 2. Вызов рекурсивной функции будет последней операцией перед возвратом
     */
    object RecursiveFunc {
        // a) Напишите функцию которая записывает в обратном порядке список
        def reverse[A](list: List[A]): List[A] = {
            @tailrec
            def loop(input: List[A], output: List[A]): List[A] = input.length match {
                case 0 => output
                case _ => loop(input.tail, input.head +: output)
            }
            loop(list, List.empty[A])
        }

        // Используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
        def testReverse[A](list: List[A]): List[A] = reverse(list)

        // b) Напишите функцию, которая применяет функцию к каждому значению списка
        def map[A, B](list: List[A])(f: A => B): List[B] = {
            @tailrec
            def loop(l: List[A], buf: List[B]): List[B] = l.length match {
                case 0 => buf
                case _ => loop(l.tail, buf :+ f(l.head))
            }
            loop(list, List.empty[B])
        }

        // Используйте функцию из пункта  (b) здесь, не изменяйте сигнатуру
        def testMap[A, B](list: List[A], f: A => B): List[B] = map(list)(f)

        // c) Напишите функцию, которая присоединяет один список к другому
        def append[A](l: List[A], r: List[A]): List[A] = {
            @tailrec
            def loop(dst: List[A], src: List[A]): List[A] = src.length match {
                case 0 => dst
                case _ => loop(dst :+ src.head, src.tail)
            }
            loop(l, r)
        }

        // Используйте функцию из пункта  (c) здесь, не изменяйте сигнатуру
        def testAppend[A](l: List[A], r: List[A]): List[A] = append(l, r)

        /* d) Напишите функцию, которая применяет функцию к каждому значению списка:
         *     def flatMap[A, B](list: List[A])(f: A => List[B]): List[B]
         *    она получает функцию, которая создает новый List[B] для каждого элемента типа A в
         *    списке. Поэтому вы создаете List[List[B]].
         */
        def flatMap[A, B](list: List[A])(f: A => List[B]): List[B] = {
            @tailrec
            def loop1(l: List[A], buf: List[List[B]]): List[List[B]] = l.length match {
                case 0 => buf
                case _ => loop1(l.tail, buf :+ f(l.head))
            }
            val ll = loop1(list, List.empty[List[B]])
            @tailrec
            def loop2(ll: List[List[B]], buf: List[B]): List[B] = ll.length match {
                case 0 => buf
                case _ => loop2(ll.tail, append(buf, ll.head))
            }
            loop2(ll, List.empty[B])
        }

        // Используйте функцию из пункта  (d) здесь, не изменяйте сигнатуру
        def testFlatMap[A, B](list: List[A], f: A => List[B]): List[B] = {
            flatMap(list)(f)
        }

        // e) Вопрос: Возможно ли написать функцию с хвостовой рекурсией для `Tree`s? Если нет, почему?
        // Ответ: Невозможно. Хвостовая рекурсия не позволяет вернуться к пройденному элементу, тогда как
        // в рекурсивных алгоритмах обхода двоичных деревьев всегда надо вернуться к пройденному элементу
        // (в том числе к корню двоичного дерева).

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testReverse(List(1, 2, 3)))
            println("\nTask b")
            def func1(in: Int): Int = in * 10
            println(testMap(List(4, 5, 6), func1))
            println("\nTask c")
            println(testAppend(List(7, 8), List(9, 10)))
            println("\nTask d")
            def func2(in: String): List[Char] = in.toUpperCase.toList
            println(testFlatMap(List("First", "Second"), func2))
        }
    }

}