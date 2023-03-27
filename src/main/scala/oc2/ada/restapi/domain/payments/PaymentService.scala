package oc2.ada.restapi.domain.payments

import oc2.ada.restapi.domain.{Payment, PaymentUpdate}
import oc2.ada.restapi.utils.MonadTransformers.FutureOptionMonadTransformer

import scala.concurrent.{ExecutionContext, Future}

class PaymentService(paymentStorage: PaymentStorage, secretKey: String)(implicit executionContext: ExecutionContext) {

  def getPayments: Future[Seq[Payment]] =
    paymentStorage.getPayments
  def getPayments(sit:String, file:String, pAnio:String, pEntidad:String, pRecibo:String): Future[Seq[Payment]] =
    paymentStorage.getPayments(sit,file,pAnio, pEntidad, pRecibo)

  def getPayment(id: String): Future[Option[Payment]] =
    getPayment(id.substring(0,4),id.substring(4,7),id.substring(7,17))
  def getPayment(anio: String,entidad: String,recibo: String): Future[Option[Payment]] =
    paymentStorage.getPayment(anio,entidad,recibo)

  def createPayment(pay: Payment): Future[Payment] =
    paymentStorage.savePayment(pay)

  def updatePayment(id: String, paymentUpdate: PaymentUpdate): Future[Option[Payment]] =
    updatePayment(id.substring(0,4),id.substring(4,7),id.substring(7,17),paymentUpdate)
  def updatePayment(anio: String, entidad: String, recibo: String, paymentUpdate: PaymentUpdate): Future[Option[Payment]] =
    paymentStorage
      .getPayment(anio, entidad, recibo)
      .mapT(paymentUpdate.merge)
      .flatMapTOuter(paymentStorage.savePayment)
}
