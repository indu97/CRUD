package controllers

import akka.actor.ActorSystem
import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import akka.japi.Option
import akka.parboiled2.RuleTrace.Fail
import akka.stream.ActorMaterializer
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.Stack
import dao.EmployeeDAO
import net.sf.ehcache.search.expression.EqualTo
import play.api.mvc.{ControllerComponents, RequestHeader}
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.{FakeHeaders, FakeRequest}
import org.mockito.Mockito._
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test.Helpers._
import play.api.libs.json._
import play.http.HttpErrorHandler
import play.api.mvc._
import play.api.mvc.Results._

import scala.concurrent._
import javax.inject.Singleton
import play.api.http.Writeable

import scala.concurrent.Future

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


//  "delController" should "delete when the id exists in db" in {
//
//    val res = DELcontroller.del(11).apply(FakeRequest(DELETE,"/del/:id"))
//
//    val ans =contentAsJson(res).toString()
//    print(ans)
//    assert(status(res) == 200)
//    ans should be ("true")
//  }

  "delController" should "NOT delete when the id doesn't exist in db" in {

    val res = DELcontroller.del(3215).apply(FakeRequest(DELETE,"/del/:id"))

    val ans =contentAsJson(res).toString()
    //print(ans)
    assert(status(res) == 200)
    ans should be ("false")
  }


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


  "createController" should  " Not accept null FirstName " in {

    val json =
      """{
        |    "FirstName": "SriNidhi",
        |    "LastName": "Varadarajan",
        |    "PhoneNumber": "123456778"
        |}""".stripMargin

    implicit val sys = ActorSystem("MyTest")
    implicit val mat = ActorMaterializer()
    val request = FakeRequest(POST, "/post").withJsonBody(Json.parse(json))
    //val res = CREATEcontroller.create.apply(request)
    //val res = route(FakeRequest(POST, "/post", FakeHeaders(Seq(CONTENT_TYPE->Seq("application/json"))), jsonStr))(Writeable(_.getBytes, None)).get
    val res = route(app, request).get
    //val resinJSON = contentAsJson(res)

    assert(status(res) == 201)
    }



"putController" should  " update values in the db if id exists " in {

  val json =
  """{
    |    "FirstName": "poornima",
    |    "LastName": "uihyn",
    |    "PhoneNumber": "12345"
    |}""".stripMargin

  implicit val sys = ActorSystem("MyTest")
  implicit val mat = ActorMaterializer()
  //val request = FakeRequest(PUT, "/put/:id").withJsonBody(Json.parse(json))
 // val res =UPDATEcontroller.update(18).apply(request)
  //val res = route(FakeRequest(POST, "/post", FakeHeaders(Seq(CONTENT_TYPE->Seq("application/json"))), jsonStr))(Writeable(_.getBytes, None)).get
 //val re = route(app, request).get
  //val resinJSON = contentAsJson(res)

  val request=FakeRequest(PUT,"/put/2").withJsonBody(Json.parse(json))
  val res = route(app, request).get
  //print(status(res))
  assert(status(res) == 200)


}

}
