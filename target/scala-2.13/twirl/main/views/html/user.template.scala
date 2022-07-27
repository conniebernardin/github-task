
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
/*1.2*/import models.UserModel

object user extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[UserModel,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(user: UserModel):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User</title>
</head>
<body>
    <div>
        <p> Username: """),_display_(/*12.24*/user/*12.28*/.login),format.raw/*12.34*/(""" """),format.raw/*12.35*/("""</p>
        <p> Followers: """),_display_(/*13.25*/user/*13.29*/.followers),format.raw/*13.39*/(""" """),format.raw/*13.40*/("""</p>
    </div>
</body>
</html>"""))
      }
    }
  }

  def render(user:UserModel): play.twirl.api.HtmlFormat.Appendable = apply(user)

  def f:((UserModel) => play.twirl.api.HtmlFormat.Appendable) = (user) => apply(user)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2022-07-27T15:28:49.768006
                  SOURCE: /Users/connie.bernardin/github/github-task/app/views/user.scala.html
                  HASH: b2032b6caada34af6c19a8871d9bcc63550c6419
                  MATRIX: 432->1|762->26|873->44|900->45|1066->184|1079->188|1106->194|1135->195|1191->224|1204->228|1235->238|1264->239
                  LINES: 17->1|22->2|27->3|28->4|36->12|36->12|36->12|36->12|37->13|37->13|37->13|37->13
                  -- GENERATED --
              */
          