// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Fri Jul 26 14:00:43 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_5: controllers.HomeController,
  // @LINE:11
  EmployeeController_2: controllers.EmployeeController,
  // @LINE:13
  getController_1: controllers.getController,
  // @LINE:14
  delController_0: controllers.delController,
  // @LINE:15
  updateController_3: controllers.updateController,
  // @LINE:19
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_5: controllers.HomeController,
    // @LINE:11
    EmployeeController_2: controllers.EmployeeController,
    // @LINE:13
    getController_1: controllers.getController,
    // @LINE:14
    delController_0: controllers.delController,
    // @LINE:15
    updateController_3: controllers.updateController,
    // @LINE:19
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_5, EmployeeController_2, getController_1, delController_0, updateController_3, Assets_4, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_5, EmployeeController_2, getController_1, delController_0, updateController_3, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """explore""", """controllers.HomeController.explore"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tutorial""", """controllers.HomeController.tutorial"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getemployee""", """controllers.EmployeeController.Getemployee"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get/""" + "$" + """id<[^/]+>""", """controllers.getController.get(id:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """del/""" + "$" + """id<[^/]+>""", """controllers.delController.del(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """put/""" + "$" + """id<[^/]+>""", """controllers.updateController.update(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_5.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_explore1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("explore")))
  )
  private[this] lazy val controllers_HomeController_explore1_invoker = createInvoker(
    HomeController_5.explore,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "explore",
      Nil,
      "GET",
      this.prefix + """explore""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_tutorial2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tutorial")))
  )
  private[this] lazy val controllers_HomeController_tutorial2_invoker = createInvoker(
    HomeController_5.tutorial,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "tutorial",
      Nil,
      "GET",
      this.prefix + """tutorial""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_EmployeeController_Getemployee3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getemployee")))
  )
  private[this] lazy val controllers_EmployeeController_Getemployee3_invoker = createInvoker(
    EmployeeController_2.Getemployee,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.EmployeeController",
      "Getemployee",
      Nil,
      "GET",
      this.prefix + """getemployee""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_getController_get4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_getController_get4_invoker = createInvoker(
    getController_1.get(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.getController",
      "get",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """get/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_delController_del5_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("del/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_delController_del5_invoker = createInvoker(
    delController_0.del(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.delController",
      "del",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """del/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_updateController_update6_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("put/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_updateController_update6_invoker = createInvoker(
    updateController_3.update(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.updateController",
      "update",
      Seq(classOf[Long]),
      "PUT",
      this.prefix + """put/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_5.index)
      }
  
    // @LINE:8
    case controllers_HomeController_explore1_route(params@_) =>
      call { 
        controllers_HomeController_explore1_invoker.call(HomeController_5.explore)
      }
  
    // @LINE:9
    case controllers_HomeController_tutorial2_route(params@_) =>
      call { 
        controllers_HomeController_tutorial2_invoker.call(HomeController_5.tutorial)
      }
  
    // @LINE:11
    case controllers_EmployeeController_Getemployee3_route(params@_) =>
      call { 
        controllers_EmployeeController_Getemployee3_invoker.call(EmployeeController_2.Getemployee)
      }
  
    // @LINE:13
    case controllers_getController_get4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_getController_get4_invoker.call(getController_1.get(id))
      }
  
    // @LINE:14
    case controllers_delController_del5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_delController_del5_invoker.call(delController_0.del(id))
      }
  
    // @LINE:15
    case controllers_updateController_update6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_updateController_update6_invoker.call(updateController_3.update(id))
      }
  
    // @LINE:19
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
