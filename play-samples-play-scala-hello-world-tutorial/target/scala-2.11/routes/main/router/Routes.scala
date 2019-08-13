// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Mon Aug 12 11:36:07 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:10
  getController_3: controllers.getController,
  // @LINE:13
  searchController_2: controllers.searchController,
  // @LINE:15
  delController_1: controllers.delController,
  // @LINE:17
  updateController_4: controllers.updateController,
  // @LINE:18
  createController_0: controllers.createController,
  // @LINE:22
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:10
    getController_3: controllers.getController,
    // @LINE:13
    searchController_2: controllers.searchController,
    // @LINE:15
    delController_1: controllers.delController,
    // @LINE:17
    updateController_4: controllers.updateController,
    // @LINE:18
    createController_0: controllers.createController,
    // @LINE:22
    Assets_5: controllers.Assets
  ) = this(errorHandler, getController_3, searchController_2, delController_1, updateController_4, createController_0, Assets_5, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, getController_3, searchController_2, delController_1, updateController_4, createController_0, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get/""" + "$" + """id<[^/]+>""", """controllers.getController.get(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get""", """controllers.getController.List"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search/""" + "$" + """FirstName<[^/]+>""", """controllers.searchController.search(FirstName:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """del/""" + "$" + """id<[^/]+>""", """controllers.delController.del(id:Long)"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """put/""" + "$" + """id<[^/]+>""", """controllers.updateController.update(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """post""", """controllers.createController.create"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """postFile""", """controllers.createController.createFromFile"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:10
  private[this] lazy val controllers_getController_get0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_getController_get0_invoker = createInvoker(
    getController_3.get(fakeValue[Long]),
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

  // @LINE:11
  private[this] lazy val controllers_getController_List1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get")))
  )
  private[this] lazy val controllers_getController_List1_invoker = createInvoker(
    getController_3.List,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.getController",
      "List",
      Nil,
      "GET",
      this.prefix + """get""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_searchController_search2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search/"), DynamicPart("FirstName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_searchController_search2_invoker = createInvoker(
    searchController_2.search(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.searchController",
      "search",
      Seq(classOf[String]),
      "GET",
      this.prefix + """search/""" + "$" + """FirstName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_delController_del3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("del/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_delController_del3_invoker = createInvoker(
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

  // @LINE:17
  private[this] lazy val controllers_updateController_update4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("put/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_updateController_update4_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_createController_create5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("post")))
  )
  private[this] lazy val controllers_createController_create5_invoker = createInvoker(
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

  // @LINE:19
  private[this] lazy val controllers_createController_createFromFile6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("postFile")))
  )
  private[this] lazy val controllers_createController_createFromFile6_invoker = createInvoker(
    createController_0.createFromFile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.createController",
      "createFromFile",
      Nil,
      "POST",
      this.prefix + """postFile""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
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
  
    // @LINE:10
    case controllers_getController_get0_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_getController_get0_invoker.call(getController_3.get(id))
      }
  
    // @LINE:11
    case controllers_getController_List1_route(params@_) =>
      call { 
        controllers_getController_List1_invoker.call(getController_3.List)
      }
  
    // @LINE:13
    case controllers_searchController_search2_route(params@_) =>
      call(params.fromPath[String]("FirstName", None)) { (FirstName) =>
        controllers_searchController_search2_invoker.call(searchController_2.search(FirstName))
      }
  
    // @LINE:15
    case controllers_delController_del3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_delController_del3_invoker.call(delController_1.del(id))
      }
  
    // @LINE:17
    case controllers_updateController_update4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_updateController_update4_invoker.call(updateController_4.update(id))
      }
  
    // @LINE:18
    case controllers_createController_create5_route(params@_) =>
      call { 
        controllers_createController_create5_invoker.call(createController_0.create)
      }
  
    // @LINE:19
    case controllers_createController_createFromFile6_route(params@_) =>
      call { 
        controllers_createController_createFromFile6_invoker.call(createController_0.createFromFile)
      }
  
    // @LINE:22
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
