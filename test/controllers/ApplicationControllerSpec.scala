package controllers

import baseSpec.BaseSpecWithApplication
import models.{APIError, RepoModel, UserModel}
import org.scalamock.scalatest.MockFactory
import play.api.http.Status
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{AnyContent, AnyContentAsEmpty, Request, Result}
import play.api.test.FakeRequest
import play.api.test.Helpers.{GET, contentAsJson, contentAsString, contentType, defaultAwaitTimeout, route, status, writeableOf_AnyContentAsEmpty}
import services.GitHubService
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper

import scala.concurrent.{ExecutionContext, Future}

class ApplicationControllerSpec extends BaseSpecWithApplication with MockFactory {

  val mockService: GitHubService = mock[GitHubService]
  val mockController: ApplicationController = new ApplicationController(component, mockService) //make instance of controller being tested
  val userMock: UserModel = UserModel("connie", "2022-01-06T10:01:06Z", Some("London"), 14, 1)
  val repoMock: Seq[RepoModel] = Seq(RepoModel("repo1"), RepoModel("repo2"))



  "GithubController .getGiHubUser" should {
    "return an Ok status if user found" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/conniebernardin")
      (mockService.getGithubUser(_: String)(_: ExecutionContext)).expects(*,executionContext).returning(Future(Right(userMock))).once()
      val request: Future[Result] = mockController.getGitHubUser("connie")(buildGetUserRequest)

      status(request) shouldBe Status.OK

      contentType(request) shouldBe Some("text/html")
      contentAsString(request) must include("connie")

    }


    "return a bad API response if user cannot be found" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/user/conniebernardin")
      (mockService.getGithubUser(_: String)(_: ExecutionContext)).expects(*,executionContext).returning(Future(Left(APIError.BadAPIResponse(404, "Cannot find user")))).once()
      val request: Future[Result] = mockController.getGitHubUser("connie")(buildGetUserRequest)

      status(request) shouldBe Status.BAD_REQUEST
    }
  }

  "GithubController .getGitHubRepos" should {
    "return an Ok status if repo found" in {
      val buildGetRepoRequest: FakeRequest[AnyContent] = buildGet("/github/conniebernardin/repos")
      (mockService.getGitHubRepos(_: String)(_: ExecutionContext)).expects(*,executionContext).returning(Future(Right(repoMock))).once()
      val request: Future[Result] = mockController.getGitHubRepos("connie")(buildGetRepoRequest)

      status(request) shouldBe Status.OK

      contentType(request) shouldBe Some("text/html")
        }


    "return a bad API response if user cannot be found" in {
      val buildGetUserRequest: FakeRequest[AnyContent] = buildGet("/github/conniebernardin/repos")
      (mockService.getGitHubRepos(_: String)(_: ExecutionContext)).expects(*,executionContext).returning(Future(Left(APIError.BadAPIResponse(404, "Cannot find repository")))).once()
      val request: Future[Result] = mockController.getGitHubRepos("connie")(buildGetUserRequest)

      status(request) shouldBe Status.BAD_REQUEST
    }
  }
  }
