package oc2.ada.restapi.http.routes

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.syntax._
import oc2.ada.restapi.domain.{File, FileUpdate}
import oc2.ada.restapi.domain.files.FileService
import oc2.ada.restapi.domain.mapa_phnmalia.MapaPhntaliaService

import scala.concurrent.ExecutionContext

class FileRoute(secretKey: String,
                filesService: FileService,
                mapaPhnmaliaService: MapaPhntaliaService)
               (implicit executionContext: ExecutionContext)
  extends FailFastCirceSupport {

  import filesService._
  import mapaPhnmaliaService._

  val route: Route =
    pathPrefix( pm ="mapaphntalia") {
      pathPrefix(pm ="all") {
        pathEndOrSingleSlash {
          get {
            complete(
              getMapaPhntalias.map(_.asJson)
            )
          }
        }
      } ~
        pathPrefix(pm="getById"){
          pathEndOrSingleSlash{
            get{
              parameters("id".as[String]){ id =>
                complete(
                  getMapaPhntaliaById(id).map(_.asJson)
                )
              }
            }
          }
        }
    } ~
      pathPrefix(pm ="files") {
        //val route: Route = pathPrefix("files") {
        pathPrefix(pm ="all") {
          pathEndOrSingleSlash {
            get {
              complete(getFiles.map(_.asJson))
            }
          }
        } ~
          pathPrefix(pm ="file") {
            pathEndOrSingleSlash {
              get{
                parameters("id".as[String]){ id =>
                  complete(
                    getFile(id).map(_.asJson)
                  )
                }
              }~
                get{
                  parameters("t_exp": String, "p_exp".as[String], "a_exp".as[String],
                    "c_exp".as[String], "n_exp".as[String], "du_exp".as[String],
                    "de_exp".as[String]){ (t_exp, p_exp, a_exp, c_exp, n_exp, du_exp, de_exp) =>
                    complete(
                      getFile(t_exp, p_exp, a_exp, c_exp, n_exp, du_exp, de_exp).map(_.asJson)
                    )
                  }
                }~
                get{
                  parameters("tipo_ipf".as[String],"num_ipf".as[String],"dup_ipf".as[String],"des_ipf".as[String]){ (tipo_ipf,num_ipf,dup_ipf,des_ipf) =>
                    complete(
                      getFilesByIPF(tipo_ipf,num_ipf,dup_ipf,des_ipf).map(_.asJson)
                    )
                  }
                }~
                post {
                  parameters("id".as[String]) { id =>
                    entity(as[FileUpdate]) { value =>
                      complete(
                        updateFile(id,value).map(_.asJson)
                      )
                    }
                  }
                }~
                put{
                  entity(as[File]){ value =>
                    complete(createFile(value).map(_.asJson))
                  }
                }
            }
          }
      }

  private case class IPF(ipf: String)
}
