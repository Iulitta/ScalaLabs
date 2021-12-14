package lab4 {
    import scala.annotation.tailrec

/* Напишите вашу реализацию в тестовые функции.
 * https://docs.scala-lang.org/overviews/collections/maps.html
 */
    object Maps {
        case class User(name: String, age: Int)

    /* a) В данной Seq[User] сгруппируйте пользователей по имени (`groupBy`)
     * и вычислите средний возраст: `name -> averageAge`. Вы можете реализовать 
     * ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
     */
        def testGroupUsers(users: Seq[User]): Map[String, Int] = {
            def avg(xs: Seq[Int]): Int = xs.sum / xs.length
            users.groupBy(_.name).map {
                kv => (kv._1, avg(kv._2.map(_.age)))
            }
        }

    /* b) Дана `Map[String, User]` состоящая из имен пользователей `User`, сколько имен пользователей,
     * содержащихся в Map, содержат подстроку "Adam"? Вы можете реализовать ваше решение в 
     * теле тестовой функции. Не изменяйте сигнатуру.
     */
        def testNumberFrodos(map: Map[String, User]): Int = {
            val const = "Adam"
            @tailrec
            def loop(in: List[(String, User)], out: Int): Int = in.length match {
                case 0 => out
                case _ => {
                    val one = in.head._1
                    val two = in.head._2.name
                    if (one.contains(const) || two.contains(const)) loop(in.tail, out + 1)
                    else loop(in.tail, out)
                }
            }
            loop(map.toList, 0)
        }

    /* c) Удалите всех пользователей возраст которых менее 35 лет.
     * Вы можете реализовать ваше решение в теле тестовой функции. Не изменяйте сигнатуру.
     */
        def testUnderaged(map: Map[String, User]): Map[String, User] = {
            map.filter((t) => t._2.age > 35)
        }

        // Точка входа в программу
        def main(args: Array[String]): Unit = {
            println("Task a")
            println(testGroupUsers(Seq(User("Ada", 10), User("Ada", 20), User("Sam", 16), User("Sam", 18))))
            println("\nTask b")
            val map = Map("Fisr" -> User("Howdy", 19), "Adam" -> User("Adam", 25), "AdiAla" -> User("Adamcher", 40))
            println(testNumberFrodos(map))
            println("\nTask c")
            println(testUnderaged(map))
        }
    }

}