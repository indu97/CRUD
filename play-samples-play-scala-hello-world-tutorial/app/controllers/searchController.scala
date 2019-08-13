package controllers

import dao.EmployeeDAO
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext.Implicits.global

class searchController  @Inject()(cc: ControllerComponents,variab: EmployeeDAO) extends AbstractController(cc) {


  def search(FirstName : String) = Action.async { request =>
    variab.searchEmployeestructure(FirstName).map { result =>
      Ok(Json.toJson(result))
    }
  }

}