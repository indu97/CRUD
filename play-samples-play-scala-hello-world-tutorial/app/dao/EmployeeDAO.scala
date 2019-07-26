package dao

import javax.inject.Inject
import model.{EmployeeDetailsTable, Employeestructure}
//import dto.EmployeeDTO
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

  def updateEmployeestructure(id: Long, iproduct:Employeestructure ): Future[Option[Employeestructure]] = {

    val newRecord: Employeestructure = iproduct.copy(id = Option(id))
    db.run(employeeDetailsTable.filter(_.id === id).update(newRecord)).map {
      case 0 => None
      case _ => Some(newRecord)
    }
  }

  def insert(acceGroup: AccessGroup): Future[AccessGroup] = {
    val currentDate = new Date(Calendar.getInstance().getTime().getTime());
    val acceGroupNew: AccessGroup = acceGroup.copy(createdBy = acceGroup.createdBy, modifidedBy = acceGroup.modifidedBy)

    db.run((accessGroupTable returning accessGroupTable.map(_.id) into ((accessGroupTable, id) => accessGroupTable.copy(id = id))) += acceGroupNew)
  }
}