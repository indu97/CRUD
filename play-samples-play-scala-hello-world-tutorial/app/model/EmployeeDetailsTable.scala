package model

import play.api.libs.functional.syntax.{toFunctionalBuilderOps, unlift}
import play.api.libs.json.{JsPath, Reads, Writes}
import slick.jdbc.MySQLProfile.api.{Table, anyToShapedValue, longColumnType, stringColumnType}
import slick.lifted.Tag

case class Employeestructure (

                                            id:Option[Long],
                                            FirstName : String,
                                            LastName : String,
                                            PhoneNumber : String
                                          )



class EmployeeDetailsTable(tag: Tag) extends Table[Employeestructure](tag, "employee_details") {
  def id = column[Option[Long]]("id", O.PrimaryKey,O.AutoInc)
  def FirstName = column[String]("FirstName")
  def LastName = column[String]("LastName")
  def PhoneNumber = column[String]("PhoneNumber")


def * = (
id,
FirstName,
LastName,
PhoneNumber) <> (
(Employeestructure.apply _).tupled,
  Employeestructure.unapply)
}


object Employeestructure {
  implicit val EmployeeStructureRead: Reads[Employeestructure] = (
    (JsPath \ "id").readNullable[Long] and
      (JsPath \ "FirstName").read[String] and
      (JsPath \ "LastName").read[String] and
      (JsPath \ "PhoneNumber").read[String] )(Employeestructure.apply _)

  implicit val EmployeeStructureWrite: Writes[Employeestructure] = (
    (JsPath \ "id").writeNullable[Long] and
      (JsPath \ "FirstName").write[String] and
      (JsPath \ "LastName").write[String] and
      (JsPath \ "PhoneNumber").write[String]
    )(unlift(Employeestructure.unapply))
}