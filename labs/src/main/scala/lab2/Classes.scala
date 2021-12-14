package lab2 {
/*
 * a) Создать класс Animal, который имеет следующие поля:
 *  - name: String (название)
 *  - species: String (вид)
 *  - food: String
 *
 * c) Добавьте следующие метод в Animals:
 *     def eats(food: String): Boolean 
 *    который проверяет ест ли животное определенную пищу
 */

    class AnimalClass(val name: String, val species: String, val food: String) {
        def eats(food: String): Boolean = food == this.food
    }

/* b) Создайте объект-компаньон для класса Animal и добавьте следующие сущности как поля:
 *  - cat, mammal, meat
 *  - parrot, bird, vegetables
 *  - goldfish, fish, plants
 */

    object AnimalClass {
        val cat = new AnimalClass("cat", "mammal", "meat")
        val parrot = new AnimalClass("parrot", "bird", "vegetables")
        val goldfish = new AnimalClass("goldfish", "fish", "plants")
    }

/* d) Переопределите ваш класс Animal как трейт и создайте объекты класса-образца для Mammal, Bird и Fish.
 *    Вам всё ещё нужно поле `species`?
 */

    trait Animal {
        val name: String
        val food: Food
    }

    case class Mammal(val name: String, val food: Food) extends Animal
    case class Bird(val name: String, val food: Food) extends Animal
    case class Fish(val name: String, val food: Food) extends Animal

    /* e) Добавьте следующие функции в объект-компаньон Animal:
 *  def knownAnimal(name: String): Boolean  // true если это имя одного из трех животных из (b)
 *  def apply(name: String): Option[Animal] // возвращает одно из трех животных в соответствии с именем (Some) или ничего (None), см. ниже
 */

    object Animal {
        def knownAnimal(name: String): Boolean = {
            var flag: Boolean = name == "cat" | name == "parrot" | name == "goldfish"
            return flag
        }

        def apply(name: String): Option[Animal] = {
            name match {
                case "cat" => Some(Mammal("cat", Meat))
                case "parrot" => Some(Bird("parrot", Vegetables))
                case "goldfish" => Some(Fish("goldfish", Plants))
                case _ => None
            }
        }
    }

    /* f) Создайте трейт Food со следующими классами-образцами:
 *  - Meat
 *  - Vegetables
 *  - Plants
 *   и добавьте это в определение Animal. Так же добавьте объект-компаньон с методом apply():
 *  def apply(food: String): Option[Food]
 */

    trait Food
    case object Meat extends Food
    case object Vegetables extends Food
    case object Plants extends Food

    object Food {
        def apply(food: String): Option[Food] = {
            food match {
                case "meat" => Some(Meat)
                case "vegetables" => Some(Vegetables)
                case "plants" => Some(Plants)
                case _ => None
            }
        }
    }

    // Для главного метода
    object Classes {
        def main(args: Array[String]): Unit = {
            println(Animal.knownAnimal("cat"))
            println(Animal.knownAnimal("parrot"))
            println(Animal.knownAnimal("goldfish"))
            println(Animal.knownAnimal("dog"))
            println()
            println(Animal.apply("cat"))
            println(Animal.apply("parrot"))
            println(Animal.apply("dog"))
            println()
            println(Food.apply("meat"))
            println(Food.apply("vegetables"))
            println(Food.apply("hotdog"))
        }
    }

}