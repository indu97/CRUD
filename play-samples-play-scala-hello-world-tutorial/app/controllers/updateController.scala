package controllers

import dao.EmployeeDAO
import javax.inject.Inject
import model.Employeestructure
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class updateController  @Inject()(cc: ControllerComponents,variab: EmployeeDAO) extends AbstractController(cc) {

  /* def update(id: Long, FirstName: String, LastName: String, PhoneNumber: String ) = Action.async { request =>
    variab.updateEmployeestructure(id,FirstName,LastName,PhoneNumber).map { result =>
      Ok(Json.toJson(result))
    }
  }*/
  def update(id: Long) = Action.async(parse.json) { request =>
    request.body.validate[Employeestructure].map { product =>
      variab.updateEmployeestructure(id, product).map { result =>

        Created(Json.toJson(AESCryptographyAlgorithm.buildEncryptResponse(Json.toJson(Json.toJson(result))))).as(JSON_CONTETNT_TYPE)
        Ok(Json.toJson(result))
      }
    }

  }
}