package oc2.ada.restapi.domain.auth

import java.util.UUID
import oc2.ada.restapi.domain.{AuthData, AuthDataUpdate, AuthToken, AuthTokenContent, UserId}
import oc2.ada.restapi.utils.MonadTransformers._
import com.roundeights.hasher.Implicits._
import pdi.jwt.{Jwt, JwtAlgorithm}
import io.circe.syntax._
import io.circe.generic.auto._

import scala.concurrent.{ExecutionContext, Future}

class AuthService(
    authDataStorage: AuthDataStorage,
    secretKey: String
)(implicit executionContext: ExecutionContext) {

  def signIn(login: String, password: String): Future[Option[AuthToken]] = {
    //println(password.sha256.hex)
    authDataStorage
      .findAuthData(login)
      .filterT(_.PASSWORD == password.sha256.hex)
      .mapT(authData => encodeToken(authData.ID))
  }

  def signUp(login: String, email: String, password: String): Future[AuthToken] =
    authDataStorage
      .saveAuthData(AuthData(UUID.randomUUID().toString, login, email, password.sha256.hex))
      .map(authData => encodeToken(authData.ID))

  def getUserById(_id:String): Future[Option[AuthData]] =
    authDataStorage
      .findAuthDataById(_id)

  def updateUser(id: String,  userUpdate: AuthDataUpdate): Future[Option[AuthData]] =
    authDataStorage
      .findAuthDataById(id)
      .mapT(userUpdate.merge)
      .flatMapTOuter(authDataStorage.saveAuthData)

  def createUser(pay: AuthData): Future[AuthData] =
    authDataStorage.saveAuthData(pay)

  private def encodeToken(userId: UserId): AuthToken =
    Jwt.encode(AuthTokenContent(userId).asJson.noSpaces, secretKey, JwtAlgorithm.HS256)

}
