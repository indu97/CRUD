package controllers

import dao.EmployeeDAO
import javax.inject.Inject
import model.Employeestructure
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

class createController  @Inject()(cc: ControllerComponents,variab: EmployeeDAO) extends AbstractController(cc) {


//  def create = Action.async(parse.json) { request =>
//    request.body.validate[Employeestructure].map(emp =>
//      emp match {
//        case Some() => Future {
//          Conflict(Json.obj("status" -> DOMAINNAME)).as(JSON_CONTETNT_TYPE)
//
//          /*Ok(Json.obj("status" -> DOMAINNAME)).as(JSON_CONTETNT_TYPE)*/
//        }
//        case None => customerDomainDAO.insertOrUpdate(customerId, customerDomain).map {
//          result => Created(Json.toJson(AESCryptographyAlgorithm.buildEncryptResponse(Json.toJson(result)))).as(JSON_CONTETNT_TYPE)
//        }.recoverWith {
//          case e => Future { InternalServerError(APPLICATION_ERROR) }
//        }
//      }).recoverTotal {
//      e => Future { Ok("Bad request") }
//    }
//  }

  def create = Action.async(parse.json) { request =>
    request.body.validate[Employeestructure].map { emp => emp.FirstName match {
      case None => {
         Future {Ok("null") }}

      case _ => variab.insert(emp).map {
        result => Created(Json.toJson(result))
      }
    }
    }.recoverTotal {
      e => Future { Ok("Bad request") }
    }
  }

}


