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
    db.run(employeeDetailsTable.filter(_.id === id).result.headOption)
  }

  def searchEmployeestructure(FirstName : String): Future[List[Employeestructure]] = {
    db.run(employeeDetailsTable.filter(_.FirstName === FirstName).to[List].result)
  }

  def count(): Future[Int] = {
    db.run(employeeDetailsTable.map(_.id).length.result)
  }

  def ListEmployeestructure: Future[List[Employeestructure]] = {

    db.run(employeeDetailsTable.to[List].result)
  }

  def delEmployeestructure(id: Long): Future[Boolean] = {

    db.run(employeeDetailsTable.filter(_.id === id).delete).map { affectedRows =>
      affectedRows > 0
    }
  }

  def updateEmployeestructure(id: Long, iproduct: Employeestructure): Future[Option[Employeestructure]] = {

    val newRecord: Employeestructure = iproduct.copy(id = Option(id))
    db.run(employeeDetailsTable.filter(_.id === id).update(newRecord)).map {
      case 0 => None
      case _ => Some(newRecord)
    }
  }

  def insert(iproduct: Employeestructure): Future[Employeestructure] = {
    //val currentDate = new Date(Calendar.getInstance().getTime().getTime());
    val empNew: Employeestructure = iproduct.copy(id = iproduct.id, FirstName = iproduct.FirstName, LastName = iproduct.LastName, PhoneNumber = iproduct.PhoneNumber)

    db.run((employeeDetailsTable returning employeeDetailsTable.map(_.id) into ((employeeDetailsTable, id) => employeeDetailsTable.copy(id = id))) += empNew)
  }

  //  def insertFromFile(iproduct:Employeestructure): Future[Employeestructure] = {
  //    //val currentDate = new Date(Calendar.getInstance().getTime().getTime());
  //    val empNew: Employeestructure = iproduct.copy(id = iproduct.id, FirstName = iproduct.FirstName, LastName = iproduct.LastName, PhoneNumber = iproduct.PhoneNumber)
  //
  //    db.run((employeeDetailsTable returning employeeDetailsTable.map(_.id) into ((employeeDetailsTable, id) => employeeDetailsTable.copy(id = id))) += empNew)
  //  }
  //
//  def insertFromFile(iproduct: Employeestructure): Future[List[Employeestructure]] = {
//    //val currentDate = new Date(Calendar.getInstance().getTime().getTime());
//
//    val bufferedSource = io.Source.fromFile("/tmp/finance.csv")
//    for (line <- bufferedSource.getLines) {
//      val cols = line.split(",").map(_.trim) // do whatever you want with the columns here
//      println(s"${cols(0)}|${cols(1)}|${cols(2)}|${cols(3)}")  }  bufferedSource.close
//
//      val newProduct: List[Employeestructure] = accessGroupMenu.copy(menuId = accessGroupMenu.menuId, groupId = accessGroupMenu.groupId, active = 1, createdBy = accessGroupMenu.createdBy, createdDate = Some(currentDate), modifidedBy = accessGroupMenu.modifidedBy, modifiedDate = Some(currentDate))
//
//      db.run(employeeDetailsTable += newProduct).map(result => accessGroupMenu)
//    }
//  }


}