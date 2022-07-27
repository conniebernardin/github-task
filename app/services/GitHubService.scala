package services

import cats.data.EitherT
import connectors.ApplicationConnector
import models.{APIError, UserModel}

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class GitHubService @Inject()(connector: ApplicationConnector){

  def getGithubUser(login: String)(implicit ec: ExecutionContext): Future [Either[APIError, UserModel]] =
    connector.get[UserModel](s"https://api.github.com/users/$login")

}