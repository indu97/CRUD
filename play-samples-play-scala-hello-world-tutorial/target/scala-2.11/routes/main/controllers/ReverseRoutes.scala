// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Mon Aug 12 11:36:07 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:10
package controllers {

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:10
  class ReversegetController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def get(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:11
    def List(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get")
    }
  
  }

  // @LINE:13
  class ReversesearchController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def search(FirstName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("FirstName", FirstName)))
    }
  
  }

  // @LINE:17
  class ReverseupdateController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def update(id:Long): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "put/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:18
  class ReversecreateController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "post")
    }
  
    // @LINE:19
    def createFromFile(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "postFile")
    }
  
  }

  // @LINE:15
  class ReversedelController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def del(id:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "del/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
