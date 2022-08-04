package service

import baseSpec.BaseSpecWithApplication
import connectors.ApplicationConnector
import models.UserModel
import org.scalamock.scalatest.MockFactory
import play.api.libs.json.OFormat
import services.GitHubService
//import services.GitHubService

import scala.concurrent.{ExecutionContext, Future}


class GitHubServiceSpec extends BaseSpecWithApplication with MockFactory  {

  val mockConnector: ApplicationConnector = mock[ApplicationConnector]
  val testService = new GitHubService(mockConnector)

  val userMock: UserModel = UserModel("connie", "2022-01-06T10:01:06Z", Some("London"), 14, 1)

  "getGitHubUser" should {
    val url: String = "testUrl"

    "return a user when login is entered" in {
      (mockConnector.get[UserModel](_: String)(_: OFormat[UserModel], _: ExecutionContext))
        .expects(*, *, *)
        .returning(Future(Right(userMock)))

      whenReady(testService.getGithubUser("connie")) { result =>
        result shouldBe Right(UserModel("connie", "2022-01-06T10:01:06Z", Some("London"), 14, 1))
      }
    }
}
}
