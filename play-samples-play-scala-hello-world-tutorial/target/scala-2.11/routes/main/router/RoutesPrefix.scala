// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Fri Aug 02 16:44:08 IST 2019


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
