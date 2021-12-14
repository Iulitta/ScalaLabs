package lab5 {
    // Реализуйте тестовые функции с выводом на экран проверки разработанных функций.
    object Typeclasses {
        // a) Определите тайп-класс Reversable, который представляет в обратном порядке значения.
        trait Reversable[T] {
            def reverse(a: T): T
        }

        // b) Реализуйте функцию Reverse для String.
        case class ReversableString() extends Reversable[String] {
            def reverse(a: String): String = {
                (for (i <- a.length - 1 to 0 by -1) yield a(i)).mkString
            }
        }

        // Примените тайп-класс-решение из пункта (a) здесь
        def testReversableString(str: String): String = ReversableString().reverse(str)

        // c) Определите тайп-класс Smash таким образом чтобы в нем была функция smash,
        // которая выполняет операцию со значениями одного типа.

        trait Smash[T] {
            def smash(a: T, b: T): T
        }

        // d) Реализуйте  функции Smash для типа Int и Double.
        // Используйте сложение для типа Int у умножение для типа Double.
        case class SmashInt() extends Smash[Int] {
            def smash(a: Int, b: Int): Int = a + b
        }

        case class SmashDouble() extends Smash[Double] {
            def smash(a: Double, b: Double): Double = a * b
        }

        // Примените тайп-класс-решение из пункта (d) здесь
        def testSmashInt(a: Int, b: Int): Int = SmashInt().smash(a, b)

        // Примените тайп-класс-решение из пункта (d) здесь
        def testSmashDouble(a: Double, b: Double): Double = SmashDouble().smash(a, b)

        // e) Реализуйте функцию Smash для типа String. Необходимо выполнить конкатенацию строк,
        // которые будут получены в качестве параметра.

        case class SmashString() extends Smash[String] {
            def smash(a: String, b: String): String = a + b
        }

        // Примените тайп-класс-решение из пункта (d) здесь
        def testSmashString(a: String, b: String): String = SmashString().smash(a, b)

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Tasks a-b")
            println(testReversableString("строка"))
            println("\nTasks c-e")
            println(testSmashInt(3, 2))
            println(testSmashDouble(4.0, 5.0))
            println(testSmashString("str1 ", "str2"))
        }
    }

}