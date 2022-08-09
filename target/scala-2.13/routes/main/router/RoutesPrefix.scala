// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/connie.bernardin/github/github-task/conf/routes
// @DATE:Tue Aug 09 14:20:43 BST 2022


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
