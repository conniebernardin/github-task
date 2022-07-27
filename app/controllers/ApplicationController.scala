package controllers

import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
import models.UserModel
import models.UserModel.formats
import play.api.libs.json.Format.GenericFormat
import play.api.libs.json.Json
import play.api.libs.json.OFormat.oFormatFromReadsAndOWrites
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.{ApplicationService, GitHubService}

//import java.awt.Desktop.Action
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ApplicationController @Inject()(val controllerComponents: ControllerComponents, val service: GitHubService, val applicationService: ApplicationService)(implicit val ec: ExecutionContext) extends BaseController {

//  def index(): Action[AnyContent] = Action.async { implicit request =>
//    val users: Future[Seq[UserModel]] = dataRepository.collection.find().toFuture()
//    users.map(items => Json.toJson(items)).map(result => Ok(result))
//  }

//  def read(login: String): Action[AnyContent] = Action.async { implicit request =>
//    applicationService.read(login).map{
//      case Right (user: UserModel) => Ok(UserModel.formats.writes(user)) //wrapped in right
//      case Left(error) => Status(error.httpResponseStatus)(Json.toJson(error.reason)) //returns 500 and reason wrapped in left
//    }
//  }

  def getGitHubUser(login: String): Action[AnyContent] = Action.async { implicit request =>
    service.getGithubUser(login).map {
        case Right(user) => Ok(views.html.user(user))
        case Left(error) => BadRequest
      }
    }

}
