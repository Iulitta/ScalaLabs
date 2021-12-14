package com.application {

  import akka.actor.testkit.typed.scaladsl.ActorTestKit
  import akka.actor.typed.{ActorRef, ActorSystem}
  import akka.http.scaladsl.marshalling.Marshal
  import akka.http.scaladsl.model._
  import akka.http.scaladsl.server.Route
  import akka.http.scaladsl.testkit.ScalatestRouteTest
  import org.scalatest.concurrent.ScalaFutures
  import org.scalatest.matchers.should.Matchers
  import org.scalatest.wordspec.AnyWordSpec

  class UserRoutesSpec extends AnyWordSpec with Matchers with ScalaFutures with ScalatestRouteTest {
    lazy val testKit: ActorTestKit = ActorTestKit()

    implicit def typedSystem: ActorSystem[Nothing] = {
      testKit.system
    }

    override def createActorSystem(): akka.actor.ActorSystem = {
      testKit.system.classicSystem
    }

    val userRegistry: ActorRef[UserRegistry.Command] = testKit.spawn(UserRegistry())
    lazy val routes: Route = new UserRoutes(userRegistry).userRoutes

    import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
    import JsonFormats._

    "UserRoutes" should {
      "return no users if no present (GET /users)" in {
        val request = HttpRequest(uri = "http://localhost:1234/users")
        request ~> routes ~> check {
          status should ===(StatusCodes.OK)
          contentType should ===(ContentTypes.`application/json`)
          entityAs[String] should ===("""{"users":[]}""")
        }
      }

      "be able to add users (POST /users)" in {
        val user = User("Karl", 42, "ru")
        val userEntity = Marshal(user).to[MessageEntity].futureValue
        val request = Post("http://localhost:1234/users").withEntity(userEntity)
        request ~> routes ~> check {
          status should ===(StatusCodes.Created)
          contentType should ===(ContentTypes.`application/json`)
          entityAs[String] should ===("""{"description":"User Karl created."}""")
        }
      }

      "be able to remove users (DELETE /users)" in {
        val request = Delete(uri = "http://localhost:1234/users/Karl")
        request ~> routes ~> check {
          status should ===(StatusCodes.OK)
          contentType should ===(ContentTypes.`application/json`)
          entityAs[String] should ===("""{"description":"User Karl deleted."}""")
        }
      }
    }
  }

}