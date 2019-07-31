// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Tue Jul 30 18:23:35 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_6: controllers.HomeController,
  // @LINE:11
  EmployeeController_3: controllers.EmployeeController,
  // @LINE:13
  getController_2: controllers.getController,
  // @LINE:14
  delController_1: controllers.delController,
  // @LINE:15
  updateController_4: controllers.updateController,
  // @LINE:16
  createController_0: controllers.createController,
  // @LINE:18
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_6: controllers.HomeController,
    // @LINE:11
    EmployeeController_3: controllers.EmployeeController,
    // @LINE:13
    getController_2: controllers.getController,
    // @LINE:14
    delController_1: controllers.delController,
    // @LINE:15
    updateController_4: controllers.updateController,
    // @LINE:16
    createController_0: controllers.createController,
    // @LINE:18
    Assets_5: controllers.Assets
  ) = this(errorHandler, HomeController_6, EmployeeController_3, getController_2, delController_1, updateController_4, createController_0, Assets_5, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_6, EmployeeController_3, getController_2, delController_1, updateController_4, createController_0, Assets_5, prefix)
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.createController.create"""),
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
    HomeController_6.index,
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
    HomeController_6.explore,
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
    HomeController_6.tutorial,
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
    EmployeeController_3.Getemployee,
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
    getController_2.get(fakeValue[Long]),
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
    delController_1.del(fakeValue[Long]),
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
    updateController_4.update(fakeValue[Long]),
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

  // @LINE:16
  private[this] lazy val controllers_createController_create7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_createController_create7_invoker = createInvoker(
    createController_0.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.createController",
      "create",
      Nil,
      "POST",
      this.prefix + """post""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_6.index)
      }
  
    // @LINE:8
    case controllers_HomeController_explore1_route(params@_) =>
      call { 
        controllers_HomeController_explore1_invoker.call(HomeController_6.explore)
      }
  
    // @LINE:9
    case controllers_HomeController_tutorial2_route(params@_) =>
      call { 
        controllers_HomeController_tutorial2_invoker.call(HomeController_6.tutorial)
      }
  
    // @LINE:11
    case controllers_EmployeeController_Getemployee3_route(params@_) =>
      call { 
        controllers_EmployeeController_Getemployee3_invoker.call(EmployeeController_3.Getemployee)
      }
  
    // @LINE:13
    case controllers_getController_get4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_getController_get4_invoker.call(getController_2.get(id))
      }
  
    // @LINE:14
    case controllers_delController_del5_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_delController_del5_invoker.call(delController_1.del(id))
      }
  
    // @LINE:15
    case controllers_updateController_update6_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_updateController_update6_invoker.call(updateController_4.update(id))
      }
  
    // @LINE:16
    case controllers_createController_create7_route(params@_) =>
      call { 
        controllers_createController_create7_invoker.call(createController_0.create)
      }
  
    // @LINE:18
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
