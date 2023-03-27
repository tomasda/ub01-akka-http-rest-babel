package oc2.ada.restapi.http.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.syntax._
import oc2.ada.restapi.domain.{AuthData, AuthDataUpdate, UserProfileUpdate}
import oc2.ada.restapi.domain.auth.AuthService

import scala.concurrent.ExecutionContext

class AuthRoute(authService: AuthService)(implicit executionContext: ExecutionContext) extends FailFastCirceSupport {

  import StatusCodes._
  import authService._

  val route = pathPrefix("auth") {
    path("signIn") {
      pathEndOrSingleSlash {
        post {
          entity(as[LoginPassword]) { loginPassword =>
            complete(
              signIn(loginPassword.login, loginPassword.password).map {
                case Some(token) => OK         -> token.asJson
                case None        => BadRequest -> None.asJson
              }
            )
          }
        }
      }
    } ~
    path("signUp") {
      pathEndOrSingleSlash {
        post {
          entity(as[UsernamePasswordEmail]) { userEntity =>
            complete(Created -> signUp(userEntity.username, userEntity.email, userEntity.password))
          }
        }
      }
    } ~
    pathPrefix("me") {
      parameters("id".as[String]){ id =>
          pathEndOrSingleSlash {
            get {
              complete(getUserById(id).map {
                case Some(profile) => OK -> profile.asJson
                case None => BadRequest -> None.asJson
              })
            } ~
            post {
              entity(as[AuthDataUpdate]) { userUpdate =>
                complete(updateUser(id, userUpdate).map {
                  case Some(profile) =>
                    OK -> profile.asJson
                  case None =>
                    BadRequest -> None.asJson
                })
              }
            }
          }
      }~
        put{
          entity(as[AuthData]) { userUpdate =>
            complete(createUser(userUpdate).map(_.asJson ))
          }
        }
    }

  }

  private case class LoginPassword(login: String, password: String)
  private case class UsernameEmail(username: String, email: String)
  private case class UsernamePasswordEmail(username: String, email: String, password: String)

}
