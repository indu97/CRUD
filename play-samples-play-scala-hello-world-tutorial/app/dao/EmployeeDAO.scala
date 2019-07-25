package dao

import javax.inject.Inject
import model.{EmployeeDetailsTable, Employeestructure}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import slick.jdbc.MySQLProfile.api.{longColumnType, optionColumnExtensionMethods, streamableQueryActionExtensionMethods, valueToConstColumn, _}
import slick.lifted.TableQuery

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class EmployeeDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

  val employeeDetailsTable = TableQuery[EmployeeDetailsTable]

  def getEmployeestructure(id: Long): Future[Option[Employeestructure]] = {
    db.run(employeeDetailsTable.filter(_.id  === id).result.headOption)
  }

  def delEmployeestructure(id: Long): Future[Boolean] = {

    db.run(employeeDetailsTable.filter(_.id === id).delete).map { affectedRows =>
      affectedRows > 0
    }
  }

  def updateEmployeestructure(id: Long, FirstName: String, LastName: String, PhoneNumber: String, iproduct:Employeestructure ): Future[Option[Employeestructure]] = {

    val newRecord: Employeestructure = iproduct.copy(id = Option(id), FirstName = FirstName, LastName = LastName, PhoneNumber = PhoneNumber)
    db.run(employeeDetailsTable.filter(_.id === id).update(newRecord)).map {
      case 0 => None
      case _ => Some(newRecord)
    }
  }

}