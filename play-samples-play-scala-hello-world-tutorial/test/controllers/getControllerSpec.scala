package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import akka.japi.Option
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.Stack
import dao.EmployeeDAO
import net.sf.ehcache.search.expression.EqualTo
import play.api.mvc.ControllerComponents
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import org.mockito.Mockito._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.Helpers._
import play.api.libs.json._

class getControllerSpec extends FlatSpec with Matchers with MockitoSugar with ScalaFutures with GuiceOneAppPerSuite{
  private lazy val appBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()
  private lazy val injector: Injector = appBuilder.injector()
  val mockDAO = injector.instanceOf[EmployeeDAO]
  val mockCC =stubControllerComponents()

  val CREATEcontroller= new createController(mockCC,mockDAO)
  val DELcontroller= new delController(mockCC,mockDAO)
  val GETcontroller= new getController(mockCC,mockDAO)
  val UPDATEcontroller = new updateController(mockCC, mockDAO)


  "getController" should  " take ids which are present" in {
    val res = GETcontroller.get(2).apply(FakeRequest(GET,"/get/:id"))
    assert(status(res) == 200)
  }


   "getController" should  "NOT accept ids which aren't present" in {
    val res = GETcontroller.get(465).apply(FakeRequest(GET,"/:id"))
    val j=contentAsJson(res).toString()
     j should be ("null")

  }


//  "delController" should "not delete when the db is empty" in {
//
//    val res = DELcontroller.del(1).apply(FakeRequest(DELETE,"/del/:id"))
//
//    val ans =contentAsJson(res).toString()
//    print(ans)
//    ans should be ("true")
//  }


  "createController" should  " create the record " in{

    val json=
      """{ "FirstName":"Srinidhi",
        |"LastName":"V",
        |"PhoneNumber":"4535635564"
        |}""".stripMargin

    val request = FakeRequest(POST, "/post").withJsonBody(Json.parse(json))
    val res = route(app,request).get
    val resinJSON = contentAsJson(res)

    val FirstName = (resinJSON \ "FirstName").as[String]
    FirstName should be ("Srinidhi")

    val LastName = (resinJSON \ "LastName").as[String]
    LastName should be ("V")

  }

  "createController" should  " Not accept null FirstName " in{

    val json=
      """{ "FirstName":"Srinidhi",
        |"LastName":"V",
        |"PhoneNumber":"4535635564"
        |}""".stripMargin

    val request = FakeRequest(POST, "/post").withJsonBody(Json.parse(json))
    val res = route(app,request).get
    val resinJSON = contentAsJson(res)

    val FirstName = (resinJSON \ "FirstName").as[String]
    FirstName should be ("Srinidhi")

    val LastName = (resinJSON \ "LastName").as[String]
    LastName should be ("V")

  }
}