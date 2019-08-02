package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
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
import scala.util.parsing.json._
import play.api.libs.json.Json
import spray.json._


class getControllerSpec extends FlatSpec with Matchers with MockitoSugar with GuiceOneAppPerSuite{
  private lazy val appBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()
  private lazy val injector: Injector = appBuilder.injector()
  val mockDAO = injector.instanceOf[EmployeeDAO]
  val mockCC =stubControllerComponents()

  val CREATEcontroller= new createController(mockCC,mockDAO)
  val DELcontroller= new delController(mockCC,mockDAO)
  val GETcontroller= new getController(mockCC,mockDAO)
  val UPDATEcontroller = new updateController(mockCC, mockDAO)

  "createController" should  "not create records with duplicate ids" in {

    val jsonrecord = """{"id": 2,
      "FirstName": "Poornima",
      "LastName": "AP",
      "PhoneNumber": "123456989"}""".parseJson


    val res = CREATEcontroller.create().apply(FakeRequest(POST,"/post"))
    val j=contentAsJson(res).toString()
    j should be ("null")

  }




  "getController" should  "get records for only existing ids" in {


    val res = GETcontroller.get(2).apply(FakeRequest(GET,"/:id"))
    val j=contentAsJson(res).toString()
    j should be ("null")

  }

   "getController" should  "not take ids which are not present in db" in {

    val res = GETcontroller.get(4).apply(FakeRequest(GET,"/:id"))
    val j=contentAsJson(res).toString()
     j should be ("null")

  }

  "delController" should "not delete when the db is empty" in {

    val res = DELcontroller.del(1).apply(FakeRequest(DELETE,"/del/:id"))

    val ans =contentAsJson(res).toString()
    print(ans)
    ans should be ("true")
  }


}