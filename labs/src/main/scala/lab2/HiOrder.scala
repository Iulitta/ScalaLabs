package lab2 {
    // Напишите ваши решения в виде функций.
    object HiOrder {
        val plus: (Int, Int) => Int = _ + _
        val multiply: (Int, Int) => Int = _ * _

        // a) Напишите функцию, которая принимает `f: (Int, Int) => Int`, параменты `a` и `b`
        // и коэффициент умножения `n` и возвращает n * f(a, b). Назовите `nTimes`.
        def nTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = n * f(a, b)

        // Примените вашу функцию (a) здесь, не изменяйте сигнатуру
        def testNTimes(f: (Int, Int) => Int, a: Int, b: Int, n: Int): Int = nTimes(f, a, b, n)

        // b) Напишите анонимную функцию, функцию без идентификатора ((a, b) => ???) для `nTimes` которая
        // выполняет следующее: if (a > b) a else b
        def testAnonymousNTimes(a: Int, b: Int, n: Int): Int = nTimes((a: Int, b: Int) => if (a > b) a else b, a, b, n)

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testNTimes(plus, 5, 1, 6))
            println(testNTimes(multiply, 5, 2, 10))
            println("\nTask b")
            println(testAnonymousNTimes(4, 2, 5))
            println(testAnonymousNTimes(1, 5, 3))
        }
    }

}