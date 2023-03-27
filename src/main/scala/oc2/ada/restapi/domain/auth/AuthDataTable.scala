package oc2.ada.restapi.domain.auth

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.AuthData
import slick.lifted.Tag

private[auth] trait AuthDataTable {

  protected val databaseConnector: DatabaseConnector
  import databaseConnector.profile.api._

  class AuthDataSchema(tag: Tag) extends Table[AuthData](tag, "AUTH") {
    def ID       = column[String]("ID", O.PrimaryKey)
    def username = column[String]("USERNAME")
    def email    = column[String]("EMAIL")
    def password = column[String]("PASSWORD")

    def * = (ID, username, email, password) <> ((AuthData.apply _).tupled, AuthData.unapply)
  }

  protected val auth = TableQuery[AuthDataSchema]

}
