
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/hajjijo/Desktop/MyCRUD (copy2)/conf/routes
// @DATE:Mon Nov 20 01:41:39 IRST 2017


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
