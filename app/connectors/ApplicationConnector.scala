package connectors

import models.{APIError, FilesModel, RepoModel, UserModel}
import play.api.libs.ws.WSClient

import javax.inject.Inject
import play.api.libs.json.{JsError, JsSuccess, OFormat}

import scala.concurrent.{ExecutionContext, Future}

class ApplicationConnector @Inject()(ws: WSClient){

  def get[Response](url: String)(implicit reads : OFormat[Response], ec: ExecutionContext) : Future[Either[APIError, UserModel]] = {
    val requestResponse = ws.url(url).get()
    requestResponse.map {
      result =>
        result.json.validate[UserModel] match {
          case JsSuccess(validatedModel, _) => Right(validatedModel)
          case JsError(error) => Left(APIError.BadAPIResponse(404, "Cannot find user"))
        }
    }
  }

  def getRepos[Response](url: String)(implicit reads: OFormat[Response], ec: ExecutionContext): Future[Either[APIError, Seq[RepoModel]]]= {
    val request = ws.url(url)
    request.get().map {
      result =>
        result.json.validate[Seq[RepoModel]] match {
          case JsSuccess(validatedRepoModel, _) => Right(validatedRepoModel)
          case JsError(error) => Left(APIError.BadAPIResponse(400, "cannot display repos"))
        }
    }
  }

  def getRepoFiles[Response](url: String)(implicit reads: OFormat[Response], ec: ExecutionContext): Future[Either[APIError, Seq[FilesModel]]]= {
    val request = ws.url(url)
    request.get().map{
      result =>
        result.json.validate[Seq[FilesModel]] match {
          case JsSuccess(validatedFileModel, _) => Right(validatedFileModel)
          case JsError(errors) => Left(APIError.BadAPIResponse(400, "cannot display repo files"))
        }
    }
  }
}
