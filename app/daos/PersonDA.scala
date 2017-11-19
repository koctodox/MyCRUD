package daos

import javax.inject.{Inject, Singleton}
import model.Person
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait PersonDAImpl {
  def insert(person:Seq[Person]):Future[List[Long]]
  def selectByID(id:Long):Future[Option[Person]]
  def delete(id:Seq[Long]):Future[Int]
  def update(person: Person):Future[Int]
}

@Singleton
class PersonDA @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)extends PersonDAImpl with HasDatabaseConfigProvider[JdbcProfile]{

  import driver.api._
  private val PersonQuery = TableQuery[PersonTable]

  override def insert(phrases: Seq[Person]): Future[List[Long]] ={
    db.run(PersonQuery returning PersonQuery.map(_.id) ++= phrases).map(x => x.toList)
  }

  override def selectByID(id: Long): Future[Option[Person]] = db.run(PersonQuery.filter(_.id===id).result.headOption)

  override def delete(id:Seq[Long]): Future[Int] ={
    db.run(PersonQuery.filter(_.id inSet(id)).delete)
  }

  override def update(person: Person): Future[Int] ={
    db.run(PersonQuery.filter(_.id === person.id).update(person))
  }

  private class PersonTable (tag :Tag) extends Table[Person](tag,"person"){
  def id = column[Long]("ID" , O.PrimaryKey ,O.AutoInc )
  def name = column[String]("NAME")
  def family = column[String]("FAMILY")
  def * = (id.?, name , family) <> ((Person.apply _).tupled ,Person.unapply _)
  }
}
