package models

import play.api.libs.json.{Json, OFormat}

case class UserModel(login: String,
                     created_at: String,
                     location: Option[String],
                     followers: Int,
                     following: Int
                    )

object UserModel{
  implicit val formats: OFormat[UserModel] = Json.format[UserModel]}

