package lab4 {
    import scala.util.{Try, Failure, Success}

/* Реализуйте следующие функции.
 * List(1, 2) match {
 *   case head :: tail => ???
 *   case Nil          => ???
 *   case l            => ???
 * }
 * Option(1) match {
 *   case Some(a) => ???
 *   case None    => ???
 * }
 * Either.cond(true, 1, "right") match {
 *   case Left(i)  => ???
 *   case Right(s) => ???
 * }
 * Try(impureExpression()) match {
 *   case Success(a)     => ???
 *   case Failure(error) => ???
 * }
 * Try(impureExpression()).toEither
 */
    object Adts {
        // a) Дан List[Int], верните элемент с индексом n
        def GetNth(list: List[Int], n: Int): Option[Int] = {
            list match {
                case Nil => None
                case null => None
                case _ => list.lift(n)
            }
        }

        // Примените функцию из пункта (a) здесь, не изменяйте сигнатуру
        def testGetNth(list: List[Int], n: Int): Option[Int] = GetNth(list, n)

        // b) Напишите функцию, увеличивающую число в два раза.
        def DoubleNum(n: Option[Int]): Option[Int] = {
            n match {
                case Some(a) => Some(a * 2)
                case None => None
            }
        }

        // Примените функцию из пункта (b) здесь, не изменяйте сигнатуру
        def testDouble(n: Option[Int]): Option[Int] = DoubleNum(n)

        // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right.
        // В противном случае, верните Left("Нечетное число.").
        def IsEven(n: Int): Either[String, Int] = {
            Either.cond(n % 2 == 0, n, "Нечетное число") match {
                case Left(i) => Left(i)
                case Right(s) => Right(s)
            }
        }

        // Примените функцию из пункта (c) здесь, не изменяйте сигнатуру
        def testIsEven(n: Int): Either[String, Int] = IsEven(n)

        // d) Напишите функцию, реализующую безопасное деление целых чисел.
        // Верните Right с результатом или Left("Вы не можете делить на ноль.").
        def SafeDivide(a: Int, b: Int): Either[String, Int] = {
            Either.cond(b != 0, a / b, "Вы не можете делить на ноль") match {
                case Left(i) => Left(i)
                case Right(s) => Right(s)
            }
        }

        // Примените функцию из пункта (d) здесь, не изменяйте сигнатуру
        def testSafeDivide(a: Int, b: Int): Either[String, Int] = SafeDivide(a, b)

        // e) Обработайте исключения функции с побочным эффектом вернув 0.
        def GoodOldJava(impure: String => Int, str: String): Try[Int] = {
            Try(impure(str)) match {
                case Success(a) => Success(a)
                case Failure(error) => Failure(error)
            }
        }

        // Примените функцию из пункта (e) здесь, не изменяйте сигнатуру
        def testGoodOldJava(impure: String => Int, str: String): Try[Int] = GoodOldJava(impure, str)

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testGetNth(List(10, 20, 30, 40, 50), 2))
            println(testGetNth(List.empty[Int], -1))
            println(testGetNth(null, 10))
            println("\nTask b")
            println(testDouble(Option(4)))
            println(testDouble(None))
            println("\nTask c")
            println(testIsEven(10))
            println(testIsEven(11))
            println("\nTask d")
            println(testSafeDivide(10, 5))
            println(testSafeDivide(10, 0))
            println("\nTask e")
            def badFunc(str: String): Int = str(0).toInt / 0
            def goodFunc(str: String): Int = str.toInt
            println(testGoodOldJava(goodFunc, "123"))
            println(testGoodOldJava(badFunc, "123"))
        }
    }

}