package oc2.ada.restapi.domain.profiles

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.UserProfile

import scala.concurrent.{ExecutionContext, Future}

sealed trait UserProfileStorage {

  def getProfiles(): Future[Seq[UserProfile]]

  def getProfile(id: String): Future[Option[UserProfile]]
  def getProfileByIPF(ipf: String): Future[Option[UserProfile]]
  def getProfileByIPF(tipo_ipf: String,num_ipf: String,dup_ipf: String,des_ipf: String): Future[Option[UserProfile]]

  def saveProfile(profile: UserProfile): Future[UserProfile]

}

class JdbcUserProfileStorage(
    val databaseConnector: DatabaseConnector
)(implicit executionContext: ExecutionContext)
    extends UserProfileTable
    with UserProfileStorage {

  import databaseConnector._
  import databaseConnector.profile.api._

  def getProfiles(): Future[Seq[UserProfile]] = db.run(profiles.result)

  def getProfile(id: String): Future[Option[UserProfile]] = db.run(profiles.filter(_.id === id).result.headOption)
  override def getProfileByIPF(ipf: String): Future[Option[UserProfile]] = db.run(profiles.filter(_.tipo_ipf === ipf.substring(0,1))
    .filter(_.num_ipf === ipf.substring(1,11))
    .filter(_.dup_ipf === ipf.substring(11,13))
    .filter(_.des_ipf === ipf.substring(13,15))
    .result.headOption)
  override def getProfileByIPF(tipo_ipf: String, num_ipf: String, dup_ipf: String, des_ipf: String): Future[Option[UserProfile]] =
    db.run(profiles.filter(_.tipo_ipf === tipo_ipf)
    .filter(_.num_ipf === num_ipf)
    .filter(_.dup_ipf === dup_ipf)
    .filter(_.des_ipf === des_ipf)
    .result.headOption)

  def saveProfile(profile: UserProfile): Future[UserProfile] =
    db.run(profiles.insertOrUpdate(profile)).map(_ => profile)
}

class InMemoryUserProfileStorage extends UserProfileStorage {

  private var state: Seq[UserProfile] = Nil

  override def getProfiles(): Future[Seq[UserProfile]] =
    Future.successful(state)

  override def getProfile(id: String): Future[Option[UserProfile]] =
    Future.successful(state.find(_.ID == id))

  override def saveProfile(profile: UserProfile): Future[UserProfile] =
    Future.successful {
      state = state.filterNot(_.ID == profile.ID)
      state = state :+ profile
      profile
    }

  override def getProfileByIPF(ipf: String): Future[Option[UserProfile]] = ???

  override def getProfileByIPF(tipo_ipf: String, num_ipf: String, dup_ipf: String, des_ipf: String): Future[Option[UserProfile]] = ???
}
