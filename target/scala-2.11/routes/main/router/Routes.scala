
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/hajjijo/Desktop/MyCRUD (copy2)/conf/routes
// @DATE:Mon Nov 20 01:41:39 IRST 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  PersonController_1: controllers.PersonController,
  // @LINE:17
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    PersonController_1: controllers.PersonController,
    // @LINE:17
    Assets_0: controllers.Assets
  ) = this(errorHandler, PersonController_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add""", """controllers.PersonController.AddPerson"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete/""" + "$" + """id<[^/]+>""", """controllers.PersonController.deletePerson(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """show/""" + "$" + """id<[^/]+>""", """controllers.PersonController.showPerson(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """edit""", """controllers.PersonController.editPerson"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~
 Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_AddPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add")))
  )
  private[this] lazy val controllers_PersonController_AddPerson1_invoker = createInvoker(
    PersonController_1.AddPerson,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "AddPerson",
      Nil,
      "POST",
      """""",
      this.prefix + """add"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PersonController_deletePerson2_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PersonController_deletePerson2_invoker = createInvoker(
    PersonController_1.deletePerson(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "deletePerson",
      Seq(classOf[Long]),
      "DELETE",
      """""",
      this.prefix + """delete/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_PersonController_showPerson3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("show/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PersonController_showPerson3_invoker = createInvoker(
    PersonController_1.showPerson(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "showPerson",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """show/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_PersonController_editPerson4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("edit")))
  )
  private[this] lazy val controllers_PersonController_editPerson4_invoker = createInvoker(
    PersonController_1.editPerson,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "editPerson",
      Nil,
      "PUT",
      """""",
      this.prefix + """edit"""
    )
  )

  // @LINE:17
  private[this] lazy val controllers_Assets_at5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at5_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_PersonController_index0_route(params) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_1.index)
      }
  
    // @LINE:7
    case controllers_PersonController_AddPerson1_route(params) =>
      call { 
        controllers_PersonController_AddPerson1_invoker.call(PersonController_1.AddPerson)
      }
  
    // @LINE:9
    case controllers_PersonController_deletePerson2_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PersonController_deletePerson2_invoker.call(PersonController_1.deletePerson(id))
      }
  
    // @LINE:11
    case controllers_PersonController_showPerson3_route(params) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_PersonController_showPerson3_invoker.call(PersonController_1.showPerson(id))
      }
  
    // @LINE:13
    case controllers_PersonController_editPerson4_route(params) =>
      call { 
        controllers_PersonController_editPerson4_invoker.call(PersonController_1.editPerson)
      }
  
    // @LINE:17
    case controllers_Assets_at5_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at5_invoker.call(Assets_0.at(path, file))
      }
  }
}
