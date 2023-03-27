package oc2.ada.restapi.http.routes

import akka.http.scaladsl.model.StatusCodes.{BadRequest, OK}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.syntax._
import oc2.ada.restapi.domain.payments.PaymentService
import oc2.ada.restapi.domain.{Payment, PaymentUpdate}

import scala.concurrent.ExecutionContext

class PaymentRoute(secretKey: String, paymentService: PaymentService)
                  (implicit executionContext: ExecutionContext)
  extends FailFastCirceSupport {

  import paymentService._

  val route: Route =
    pathPrefix("payments") {
      pathPrefix("all") {
        pathEndOrSingleSlash {
          get {
            complete(getPayments.map(_.asJson))
          }
        }
      }~
      pathPrefix("bySit&File") {
        pathEndOrSingleSlash {
          get{
            /**
             * Petición como parámetro
             */
              parameters("sit".as[String],"file".as[String],"pAnio".as[String],"pEntidad".as[String],"pRecibo".as[String]){ (sit, file, pAnio, pEntidad, pRecibo) =>
                complete(getPayments(sit, file, pAnio, pEntidad,pRecibo).map(_.asJson))
              }
          }~
          get {
            /**
             * Petición como entidad
             */
            entity(as[SF]){ value =>
              complete(
                getPayments(value.situacion, value.file, value.pAnio, value.pEntidad, value.pRecibo).map(_.asJson)
              )
            }
          }
        }
      }~
      pathPrefix("payment"){
        parameters("anio".as[String],"entidad".as[String],"recibo".as[String]){ (anio, entidad, recibo) =>
          pathEndOrSingleSlash {
            get {
              complete(getPayment(anio, entidad, recibo).map {
                case Some(pay) =>
                  OK -> pay.asJson
                case None =>
                  BadRequest -> None.asJson
              })
            } ~
              post {
                entity(as[PaymentUpdate]) { payUpdate =>
                  complete(updatePayment(anio, entidad, recibo, payUpdate).map {
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
            entity(as[Payment]){ pay =>
              complete(createPayment(pay).map(_.asJson))
            }
          }
      }
  }

  private case class PK(anio: String, entidad: String, recibo: String)
  private case class SF(situacion: String, file: String, pAnio:String, pEntidad:String, pRecibo:String)
  private case class Pay(anio: String, entidad: String, recibo: String, sit: String, mod_pago:String ,
                         fecha_desde:String ,fecha_hasta:String ,tip_pago:String ,suc_pago:Int ,ent_pago:Int)

}
