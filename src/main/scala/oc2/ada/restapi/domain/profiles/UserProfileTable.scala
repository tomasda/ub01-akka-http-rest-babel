package oc2.ada.restapi.domain.profiles

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.UserProfile
import slick.lifted.Tag

private[profiles] trait UserProfileTable {

  protected val databaseConnector: DatabaseConnector

  import databaseConnector.profile.api._

  class Profiles(tag: Tag) extends Table[UserProfile](tag, "PROFILES") {
    def id        = column[String]("ID", O.PrimaryKey)
    def firstName = column[String]("FIRST_NAME")
    def lastName  = column[String]("LAST_NAME")
    def tipo_ipf  = column[String]("TIPO_IPF")
    def num_ipf   = column[String]("NUM_IPF")
    def dup_ipf   = column[String]("DUP_IPF")
    def des_ipf   = column[String]("DES_IPF")

    def * = (id, firstName, lastName,tipo_ipf,num_ipf,dup_ipf,des_ipf) <> ((UserProfile.apply _).tupled, UserProfile.unapply)
  }

  protected val profiles = TableQuery[Profiles]

}

