package service

import baseSpec.BaseSpecWithApplication
import connectors.ApplicationConnector
import models.APIError.BadAPIResponse
import models.{APIError, RepoModel, UserModel}
import org.scalamock.scalatest.MockFactory
import play.api.libs.json.{OFormat, __}
import services.GitHubService
//import services.GitHubService

import scala.concurrent.{ExecutionContext, Future}


class GitHubServiceSpec extends BaseSpecWithApplication with MockFactory  {

  val mockConnector: ApplicationConnector = mock[ApplicationConnector]
  val testService = new GitHubService(mockConnector)

  val userMock: UserModel = UserModel("connie", "2022-01-06T10:01:06Z", Some("London"), 14, 1)
  val repoMock: Seq[RepoModel] = Seq(RepoModel("repoName"), RepoModel("anotherRepoName"))

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

    "return an error if user can't be found" in {
      (mockConnector.get[UserModel](_: String)(_: OFormat[UserModel], _: ExecutionContext))
        .expects(*, *, *)
        .returning(Future(Left(APIError.BadAPIResponse(404, "User not found"))))

      whenReady(testService.getGithubUser("connie")) { result =>
        result shouldBe Left(APIError.BadAPIResponse(404, "User not found"))

      }
    }

    "return a list of repositories when login is entered" in {
      (mockConnector.getRepos(_: String)(_: OFormat[RepoModel], _: ExecutionContext))
        .expects(*, *, *)
        .returning(Future(Right(repoMock)))

      whenReady(testService.getGitHubRepos("connie")) { result =>
        result shouldBe Right(Seq(RepoModel("repoName"), RepoModel("anotherRepoName")))
      }
    }

    "return an error if repositories can't be found" in {
      (mockConnector.getRepos(_: String)(_: OFormat[RepoModel], _: ExecutionContext))
        .expects(*, *, *)
        .returning(Future(Left(APIError.BadAPIResponse(404, "Repo not found"))))

      whenReady(testService.getGitHubRepos("connie")) { result =>
        result shouldBe Left(APIError.BadAPIResponse(404, "Repo not found"))

      }
    }
}
}
