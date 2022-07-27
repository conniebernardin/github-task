// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/connie.bernardin/github/github-task/conf/routes
// @DATE:Wed Jul 27 11:45:01 BST 2022


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
