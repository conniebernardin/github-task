package services

import cats.data.EitherT
import connectors.ApplicationConnector
import models.{APIError, RepoModel, UserModel}
import play.api.mvc.{Action, AnyContent}

import java.awt.Desktop.Action
import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}
import scala.xml.Properties.userName

@Singleton
class GitHubService @Inject()(connector: ApplicationConnector){

  def getGithubUser(login: String)(implicit ec: ExecutionContext): Future [Either[APIError, UserModel]] =
    connector.get[UserModel](s"https://api.github.com/users/$login")

  def getGitHubRepos(login: String)(implicit ec: ExecutionContext): Future[Either[APIError, Seq[RepoModel]]] =
    connector.getRepos[RepoModel](s"https://api.github.com/users/$login/repos")
}