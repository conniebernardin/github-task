// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/connie.bernardin/github/github-task/conf/routes
// @DATE:Tue Aug 09 14:20:43 BST 2022

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:2
package controllers.javascript {

  // @LINE:7
  class ReverseApplicationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getGitHubRepos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.getGitHubRepos",
      """
        function(login0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("login", login0)) + "/repos"})
        }
      """
    )
  
    // @LINE:7
    def getGitHubUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.getGitHubUser",
      """
        function(login0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "library/google/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("login", login0))})
        }
      """
    )
  
    // @LINE:11
    def getRepoFiles: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApplicationController.getRepoFiles",
      """
        function(login0,repoName1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "github/users/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("login", login0)) + "/repos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("repoName", repoName1))})
        }
      """
    )
  
  }

  // @LINE:2
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:2
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:5
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:5
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
