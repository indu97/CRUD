package dto

/*
import play.api.libs.functional.syntax.toFunctionalBuilderOps
import play.api.libs.json.JsPath
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.Writes

case class EmployeeDTO(
                        id:Option[Long],
                       FirstName : String,
                       LastName : String,
                       PhoneNumber : String)

object EmployeeDTO {

  implicit val writes = new Writes[EmployeeDTO] {
    def writes(employeeDTO: EmployeeDTO) = Json.obj(
      "id" -> employeeDTO.id,
      "FirstName" -> employeeDTO.FirstName,
      "LastName" -> employeeDTO.LastName,
      "PhoneNumber" -> employeeDTO.PhoneNumber)
  }

  implicit val reads: Reads[EmployeeDTO] = (
    (JsPath \ "id").readNullable[Long] and
      (JsPath \ "FirstName").read[String] and
      (JsPath \ "LastName").read[String] and
      (JsPath \ "PhoneNumber").read[String])(EmployeeDTO.apply _)
}

 */