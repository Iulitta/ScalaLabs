package lab4 {

/* Напишите ваши решения в тестовых функциях.
 * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
 */
    object Strings {
        // a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
        def testUppercase(str: String): String = str.toUpperCase

        // b) Вставьте следующие значения в строку:
        //     Hi my name is <name> and I am <age> years old.
        def testInterpolations(name: String, age: Int): String = {
            s"Hi my name is $name and I am $age years old."
        }

    /* c) Добавьте два числа в следующую строку:
     *       Hi,
     *       now follows a quite hard calculation. We try to add:
     *         a := <value of a>
     *         b := <value of b>
     *         result is <a + b>
     */
        def testComputation(a: Int, b: Int): String = {
            s"Hi,\nnow follows a quite hard calculation. We try to add:\na := $a \nb := $b \nresult is ${a + b}"
        }

        // d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
        def testTakeTwo(str: String): String = {
            if (str.length <= 2) str
            else str.take(2)
        }

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testUppercase("upper"))
            println("\nTask b")
            println(testInterpolations("Iulitta", 20))
            println("\nTask c")
            println(testComputation(2, 2))
            println("\nTask d")
            println(testTakeTwo("pi"))
            println(testTakeTwo("test"))
            println(testTakeTwo("1"))
        }
    }

}