package controllers

import org.scalatest.{FlatSpec, Matchers}


import scala.collection.mutable.Stack
import dao.EmployeeDAO
import play.api.mvc.ControllerComponents
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.test.FakeRequest
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import play.api.inject.Injector
import play.api.inject.guice.GuiceApplicationBuilder


class getControllerSpec extends FlatSpec with Matchers with GuiceOneAppPerSuite with MockitoSugar {

  private lazy val appBuilder: GuiceApplicationBuilder = new GuiceApplicationBuilder()
  private lazy val injector: Injector = appBuilder.injector()
  private val cc: ControllerComponents = injector.instanceOf[ControllerComponents]
  private val mockedEmployeeDAO: EmployeeDAO = mock[EmployeeDAO]

  // var i = 6 don´t use vars

  "getController" should  "take ids which are present" in {

    when(mockedEmployeeDAO.getEmployeestructure(6)).thenReturn(null)

    val fakeRequest = FakeRequest(GET, s"/something")
      .withHeaders(HOST -> "localhost:9000")

    val controller= new getController(cc,mockedEmployeeDAO)// should be called SomethingController

    val result = controller.get(6).apply(fakeRequest)

    status(result) must be OK
    contentAsJson(result) mustBe null // you probably need to tweek this part

  }
}