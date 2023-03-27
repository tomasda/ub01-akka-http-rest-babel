package oc2.ada.restapi.domain.payments

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.Payment

import scala.concurrent.{ExecutionContext, Future}

sealed trait PaymentStorage {

  def getPayments: Future[Seq[Payment]]
  def getPayments(sit:String, file:String, pAnio:String, pEntidad:String, pRecibo:String): Future[Seq[Payment]]

  def getPayment(anio: String,entidad: String,recibo: String): Future[Option[Payment]]

  def savePayment(payment: Payment): Future[Payment]

}

class JdbcPaymentStorage(val databaseConnector: DatabaseConnector)(implicit executionContext: ExecutionContext)
  extends PaymentTable with PaymentStorage {

  import databaseConnector._
  import databaseConnector.profile.api._

  override def getPayments: Future[Seq[Payment]] = db.run(profiles.result)
  override def getPayments(sit: String, file:String, pAnio:String, pEntidad:String, pRecibo:String): Future[Seq[Payment]] = db.run( profiles
    .filter(_.sit === sit)
    .filter(_.file === file)
    .filterIf(pAnio.nonEmpty)(_.anio === pAnio)
    .filterIf(pEntidad.nonEmpty)(_.entidad === pEntidad)
    .filterIf(pRecibo.nonEmpty)(_.recibo === pRecibo)
    .result )

  override def getPayment(anio: String,entidad: String,recibo: String): Future[Option[Payment]] = {
      db.run(profiles.filter(_.anio === anio).filter(_.entidad === entidad).filter(_.recibo === recibo).result.headOption)
    }

  override def savePayment(pay: Payment): Future[Payment] =
    db.run(profiles.insertOrUpdate(pay)).map(_ => pay)

}

class InMemoryUserProfileStorage extends PaymentStorage {

  private var state: Seq[Payment] = Nil

  override def getPayments: Future[Seq[Payment]] =
    Future.successful(state)


  override def savePayment(pay: Payment): Future[Payment] =
    Future.successful {
      state = state.filterNot(_.ANIO == pay.ANIO)
      state = state :+ pay
      pay
    }

  override def getPayment(anio: String, entidad: String, recibo: String): Future[Option[Payment]] = ???

  override def getPayments(sit: String, file:String, pAnio:String, pEntidad:String, pRecibo:String): Future[Seq[Payment]]= ???
}