
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
/*1.2*/import models.RepoModel

object repos extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[RepoModel],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(repositories: Seq[RepoModel]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Repositories</title>
</head>
<body>
<div>
    """),_display_(/*12.6*/repositories/*12.18*/.map/*12.22*/{ repo =>_display_(Seq[Any](format.raw/*12.31*/("""
    """),format.raw/*13.5*/("""<li>"""),_display_(/*13.10*/repo/*13.14*/.full_name),format.raw/*13.24*/("""</li>""")))}),format.raw/*13.30*/("""
"""),format.raw/*14.1*/("""</div>
</body>
</html>"""))
      }
    }
  }

  def render(repositories:Seq[RepoModel]): play.twirl.api.HtmlFormat.Appendable = apply(repositories)

  def f:((Seq[RepoModel]) => play.twirl.api.HtmlFormat.Appendable) = (repositories) => apply(repositories)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-08-03T15:18:36.165726
                  SOURCE: /Users/connie.bernardin/github/github-task/app/views/repos.scala.html
                  HASH: 507052102d243e73f5c43885d830416f555702b4
                  MATRIX: 432->1|768->26|892->57|919->58|1070->183|1091->195|1104->199|1151->208|1183->213|1215->218|1228->222|1259->232|1296->238|1324->239
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13|37->13|38->14
                  -- GENERATED --
              */
          