// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Mon Aug 12 11:36:07 IST 2019


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
