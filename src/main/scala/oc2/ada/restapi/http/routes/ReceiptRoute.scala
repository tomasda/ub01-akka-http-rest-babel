package oc2.ada.restapi.http.routes

import akka.http.scaladsl.model.StatusCodes.{BadRequest, OK}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import io.circe.generic.auto._
import io.circe.syntax.EncoderOps
import oc2.ada.restapi.domain.{Receipt, ReceiptUpdate}
import oc2.ada.restapi.domain.receipts.ReceiptService

import scala.concurrent.ExecutionContext

class ReceiptRoute(secretKey: String, receiptService: ReceiptService)
                  (implicit executionContext: ExecutionContext)
  extends FailFastCirceSupport {

  import receiptService._

  val route: Route =
    pathPrefix("receipts") {
      pathPrefix("all") {
        pathEndOrSingleSlash {
          get {
            complete(getReceipts.map(_.asJson))
          }
        }
      } ~
        pathPrefix("receipt") {
          parameters("anio".as[String],"recibo".as[String]) { (anio,recibo) =>
            pathEndOrSingleSlash {
              get {
                complete(getReceipt(anio,recibo).map {
                  case Some(pay) =>
                    OK -> pay.asJson
                  case None =>
                    BadRequest -> None.asJson
                })
              } ~
                post {
                  entity(as[ReceiptUpdate]) { receiptUpdate =>
                    complete(updateReceipt(anio,recibo, receiptUpdate).map {
                      case Some(receipt) =>
                        OK -> receipt.asJson
                      case None =>
                        BadRequest -> None.asJson
                    })
                  }
                }
            }
          } ~
            put {
              entity(as[Receipt]) { receipt =>
                complete(createReceipt(receipt).map(_.asJson))
              }
            }
        }
    }

  private case class PK(recibo: String)

}
