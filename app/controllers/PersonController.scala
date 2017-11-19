package controllers

import javax.inject.Inject
import daos.PersonDA
import model.Person
import play.api.libs.json.JsValue
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future}

class PersonController @Inject()(personDA: PersonDA)(implicit exec: ExecutionContext) extends Controller {

  def index = Action {
    Ok("Server is up now")
  }

  //POST
  //http://localhost:9000/add
  //{"id":1,"name":"Foo","family":"Bar"}
  def AddPerson: Action[JsValue] = Action.async(parse.json) {
    request => {
      for {
        id <- (request.body \ "id").asOpt[Long]
        name <- (request.body \ "name").asOpt[String]
        family <- (request.body \ "family").asOpt[String]
      } yield {
        personDA.insert(Seq(Person(None, name, family))) map { x =>
          Ok(s"operation successful")
        }
      }
    }.getOrElse(Future {
      BadRequest("Wrong json format...")
    })
  }

  //DELETE
  //http://localhost:9000/delete/1
  def deletePerson(id: Long) = Action.async {
    personDA.delete(Seq(id)).map {
      case 0 => Ok("operation failed")
      case many => Ok(s"""{"deleted item":"$many"}""")
    }
  }

  //GET
  //http://localhost:9000/show/1
  def showPerson(id: Long) = Action.async {
    personDA.selectByID(id).map { maybePerson => Ok(s"""{"name":"${maybePerson.map(x => x.name).getOrElse("not found")}","family":"${maybePerson.map(x => x.family).getOrElse("not found")}"}""")
    }
  }

  //PUT
  //http://localhost:9000/edite
  //{"id":1,"name":"Foo2","family":"Bar2"}
  def editPerson() = Action.async(parse.json) {
    request => {
      {
        for {
          id <- (request.body \ "id").asOpt[Long]
          name <- (request.body \ "name").asOpt[String]
          family <- (request.body \ "family").asOpt[String]
        } yield {
          personDA.update(Person(Some(id), name, family)) map { many =>
            Ok("this count update" + many)
          }
        }
      }.getOrElse(Future {
        BadRequest("Wrong json format")
      })
    }
  }

}
