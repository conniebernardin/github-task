package models

import play.api.libs.json.{Json, OFormat}

case class FilesModel(name: String)

object FilesModel {
  implicit val formats: OFormat[FilesModel] = Json.format[FilesModel]
}
