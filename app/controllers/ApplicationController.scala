package controllers

//import akka.http.scaladsl.model.HttpHeader.ParsingResult.Ok
//import models.{RepoModel, UserModel}
//import models.UserModel.formats
//import play.api.libs.json.Format.GenericFormat
//import play.api.libs.json.Json
//import play.api.libs.json.OFormat.oFormatFromReadsAndOWrites
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import services.{ApplicationService, GitHubService}

//import java.awt.Desktop.Action
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class ApplicationController @Inject()(val controllerComponents: ControllerComponents, val service: GitHubService)(implicit val ec: ExecutionContext) extends BaseController {


  def getGitHubUser(login: String): Action[AnyContent] = Action.async { implicit request =>
    service.getGithubUser(login).map {
        case Right(user) => Ok(views.html.user(user))
        case Left(error) => BadRequest
      }
    }

def getGitHubRepos(login: String): Action[AnyContent] = Action.async{ implicit request =>
  service.getGitHubRepos(login).map {
    case Right(repos) => Ok(views.html.repos(repos))
    case Left(error) => BadRequest
  }
}

  def getRepoFiles(login: String, repoName: String): Action[AnyContent] = Action.async{ implicit request =>
    service.getRepoFiles(login, repoName).map{
      case Right(files) => Ok(views.html.files(files))
      case Left(error) => BadRequest
    }
  }

}
