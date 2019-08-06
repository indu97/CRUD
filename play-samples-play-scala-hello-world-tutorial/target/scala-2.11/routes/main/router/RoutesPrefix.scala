// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Mon Aug 05 16:24:06 IST 2019


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
