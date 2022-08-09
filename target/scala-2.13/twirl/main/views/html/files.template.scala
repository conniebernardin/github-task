
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
/*1.2*/import models.FilesModel

object files extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[FilesModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(files: Seq[FilesModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Repo Files</title>
</head>
<body>
<div>
    """),_display_(/*12.6*/files/*12.11*/.map/*12.15*/{ file =>_display_(Seq[Any](format.raw/*12.24*/("""
    """),format.raw/*13.5*/("""<li>"""),_display_(/*13.10*/file/*13.14*/.name),format.raw/*13.19*/("""</li>""")))}),format.raw/*13.25*/("""
"""),format.raw/*14.1*/("""</div>
</body>
</html>"""))
      }
    }
  }

  def render(files:Seq[FilesModel]): play.twirl.api.HtmlFormat.Appendable = apply(files)

  def f:((Seq[FilesModel]) => play.twirl.api.HtmlFormat.Appendable) = (files) => apply(files)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-09T11:39:21.818913
                  SOURCE: /Users/connie.bernardin/github/github-task/app/views/files.scala.html
                  HASH: 68d1f83a0236ca043ca7f9e79e6fb1bd84018edc
                  MATRIX: 432->1|770->27|888->52|915->53|1064->176|1078->181|1091->185|1138->194|1170->199|1202->204|1215->208|1241->213|1278->219|1306->220
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|38->14
                  -- GENERATED --
              */
          