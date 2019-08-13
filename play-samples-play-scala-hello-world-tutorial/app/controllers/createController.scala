package controllers

import java.io.FileInputStream

import dao.EmployeeDAO
import javax.inject.Inject
import model.Employeestructure
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.io.Source
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration
//import resource._
//import spray.json._


class createController  @Inject()(cc: ControllerComponents,variab: EmployeeDAO,environment: play.api.Environment) extends AbstractController(cc) {

  def create = Action.async(parse.json) { request =>
    request.body.validate[Employeestructure].map { emp =>
      emp.FirstName match {
        case None => {
          Future {
            Ok("null")
          }
        }

        case _ => variab.insert(emp).map {
          result => Created(Json.toJson(result))
        }
      }
    }.recoverTotal {
      e =>
        Future {
          Ok("Bad request")
        }
    }
  }
//
//  def createFromFile = Action.async(parse.json) {
//    environment.getExistingFile("/app/bulkinput.json").fold {
//      Ok("File Not found")
//    }
//    {file =>
//      //val stream = new FileInputStream(file)
//      Json.parse(new FileInputStream(file))
//      // Do something magic with file
//    }
//  }


//  def createFromFile = Action.async (parse.json){ request =>
//  val stream = new FileInputStream("C:\\Users\\indu.c\\Desktop")
//  val json = try {  Json.parse(stream) } finally { stream.close() }
//  val res = variab.insert(json.users[1])
//    Ok(Json.toJson(json))
//  }

def createFromFile = Action.async (parse.json) { request =>

  val filename = "C:\\Users\\indu.c\\Desktop\\bulkinput.json"

  for(line <-Source.fromFile(filename).getLines){
    val json = Json.toJson(line)
      json.validate[Employeestructure].map{ emp =>
        variab.insert(emp).map {
          result => Created(Json.toJson(result))
        }
      }

    println(line)
  }
  //lines(4).parseJson
  //val record = new Employeestructure(lines(4)\"FirstName")
  request.body.validate[Employeestructure].map { emp =>
    emp.FirstName match {
      case None => {
        Future {
          Ok("null")
        }
      }

      case _ => variab.insert(emp).map {
        result => Created(Json.toJson(result))
      }
    }
  }.recoverTotal {
    e =>
      Future {
        Ok("Bad request")
      }
  }
}

}

