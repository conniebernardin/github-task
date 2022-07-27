// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/connie.bernardin/github/github-task/conf/routes
// @DATE:Wed Jul 27 11:45:01 BST 2022

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers {

  // @LINE:9
  class ReverseApplicationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getGitHubUser(login:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "library/google/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("login", login)))
    }
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:5
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
