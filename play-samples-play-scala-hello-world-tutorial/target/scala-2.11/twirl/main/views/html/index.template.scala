
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("Welcome")/*3.17*/ {_display_(Seq[Any](format.raw/*3.19*/("""
"""),_display_(/*4.2*/defining(play.core.PlayVersion.current)/*4.41*/ { version =>_display_(Seq[Any](format.raw/*4.54*/("""

"""),format.raw/*6.1*/("""<section id="content">
  <div class="wrapper doc">
    <article>

    </article>
    <aside>
      """),_display_(/*12.8*/commonSidebar()),format.raw/*12.23*/("""
    """),format.raw/*13.5*/("""</aside>
  </div>
</section>
""")))}),format.raw/*16.2*/("""
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-07-31T11:52:01.446
                  SOURCE: C:/Users/indu.c/Downloads/play-samples-play-scala-hello-world-tutorial/app/views/index.scala.html
                  HASH: 5766db80becfe392cd3a685fb2cefd4ba0f86631
                  MATRIX: 722->1|818->3|848->8|871->23|910->25|938->28|985->67|1035->80|1065->84|1197->190|1233->205|1266->211|1329->244
                  LINES: 21->1|26->1|28->3|28->3|28->3|29->4|29->4|29->4|31->6|37->12|37->12|38->13|41->16
                  -- GENERATED --
              */
          