package oc2.ada.restapi.domain.profiles

import oc2.ada.restapi.domain.{UserProfile, UserProfileUpdate}
import oc2.ada.restapi.utils.MonadTransformers.FutureOptionMonadTransformer

import scala.concurrent.{ExecutionContext, Future}

class UserProfileService(
    userProfileStorage: UserProfileStorage
)(implicit executionContext: ExecutionContext) {

  def getProfiles(): Future[Seq[UserProfile]] =
    userProfileStorage.getProfiles()

  def getProfile(id: String): Future[Option[UserProfile]] =
    userProfileStorage.getProfile(id)
  def getProfileByIPF(ipf: String): Future[Option[UserProfile]] =
    userProfileStorage.getProfileByIPF(ipf)
  def getProfileByIPF(tipo_ipf: String,num_ipf: String,dup_ipf: String,des_ipf: String): Future[Option[UserProfile]] =
    userProfileStorage.getProfileByIPF(tipo_ipf,num_ipf,dup_ipf,des_ipf)

  def createProfile(profile: UserProfile): Future[UserProfile] =
    userProfileStorage.saveProfile(profile)

  def updateProfile(id: String, profileUpdate: UserProfileUpdate): Future[Option[UserProfile]] =
    userProfileStorage
      .getProfile(id)
      .mapT(profileUpdate.merge)
      .flatMapTOuter(userProfileStorage.saveProfile)

}
