package controllers

import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents, Request}

import scala.collection.mutable.ListBuffer



class EmployeeController @Inject()(cc: ControllerComponents) extends AbstractController(cc){


  def addvalues():ListBuffer[Person]= {
    implicit val addressFormat = Json.format[Address]
    implicit val personFormat = Json.format[Person]
    var employees  = new ListBuffer[Person]()
    var entry = Person("Fred", Address("R9", "The Burrow"))
    var entry2 = Person("George", Address("R10", "The Burrow"))
    var entry3 = Person("Ron", Address("R11", "The Burrow"))
    employees += entry
    employees += entry2
    employees += entry3

    return employees
  }

  def Getemployee() = Action {
    implicit val addressFormat = Json.format[Address]
    implicit val personFormat = Json.format[Person]
    var employees  = new ListBuffer[Person]()
    employees = addvalues()
    Ok(Json.stringify(Json.toJson(employees )))
  }

  def f1(id: Int) = Action {
    implicit val addressFormat = Json.format[Address]
    implicit val personFormat = Json.format[Person]
    var employees  = new ListBuffer[Person]()
    employees = addvalues()
    Ok(Json.stringify(Json.toJson(employees(id))))
  }
}
