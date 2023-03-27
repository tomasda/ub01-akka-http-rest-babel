package oc2.ada.restapi.http.routes

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.syntax._
import oc2.ada.restapi.domain.{UserProfile, UserProfileUpdate}
import oc2.ada.restapi.domain.profiles.UserProfileService

import scala.concurrent.ExecutionContext

class ProfileRoute(
    secretKey: String,
    usersService: UserProfileService
)(implicit executionContext: ExecutionContext)
    extends FailFastCirceSupport {

  import StatusCodes._
  import usersService._

  val route: Route = pathPrefix("profiles") {
      pathPrefix("all") {
        pathEndOrSingleSlash {
          get {
            complete(getProfiles().map(_.asJson))
          }
        }
    } ~
    pathPrefix("profile") {
      pathEndOrSingleSlash {
        get{
          parameters("id".as[String]){ value =>
            complete(getProfile(value).map {
              case Some(profile) =>
                OK -> profile.asJson
              case None =>
                BadRequest -> None.asJson
            })
          }
        } ~
          get{
            parameters("ipf".as[String]){ ipf =>
              complete(getProfileByIPF(ipf))
            }
          }~
          get{
            parameters("tipo_ipf".as[String],"num_ipf".as[String],"dup_ipf".as[String],"des_ipf".as[String]){ (tipo_ipf,num_ipf,dup_ipf,des_ipf) =>{
              complete(getProfileByIPF(tipo_ipf,num_ipf,dup_ipf,des_ipf))
            }
            }
          }~
          post {
            parameters("id".as[String]) { value =>
              entity(as[UserProfileUpdate]) { userUpdate =>
                complete(updateProfile(value, userUpdate).map(_.asJson))
              }
            }
          } ~
          put{
            entity(as[UserProfile]){ user =>
              complete(createProfile(user).map(_.asJson))
            }
          }
      }
    }
  }

  private case class PK(value:String)

}
