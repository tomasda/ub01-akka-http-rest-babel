package oc2.ada.restapi.domain.receipts

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.Receipt

import scala.concurrent.{ExecutionContext, Future}

sealed trait ReceiptsStorage {

  def getReceipts: Future[Seq[Receipt]]

  //def getPayments(sit:String): Future[Seq[Receipts]]

  def getReceipt(anio: String, recibo: String): Future[Option[Receipt]]

  def saveReceipt(profile: Receipt): Future[Receipt]


}

class JdbcReceiptStorage(val databaseConnector: DatabaseConnector)(implicit executionContext: ExecutionContext)
  extends ReceiptTable with ReceiptsStorage {

  import databaseConnector._
  import databaseConnector.profile.api._

  override def getReceipts: Future[Seq[Receipt]] =
    db.run(profiles.result)

  override def getReceipt(anio: String, recibo: String): Future[Option[Receipt]] =
    db.run(profiles.filter(_.anio === anio).filter(_.recibo === recibo).result.headOption)

  override def saveReceipt(receipt: Receipt): Future[Receipt] =
    db.run(profiles.insertOrUpdate(receipt)).map(_ => receipt)
}

class InMemoryUserProfileStorage extends ReceiptsStorage {

  private var state: Seq[Receipt] = Nil

  override def getReceipts: Future[Seq[Receipt]] =
    Future.successful(state)

  override def getReceipt(anio: String, recibo: String): Future[Option[Receipt]] =
    Future.successful(state.find(_.ANNO == anio).find(_.RECIBO == recibo))

  override def saveReceipt(receipt: Receipt): Future[Receipt] =
    Future.successful {
      state = state.filterNot(_.RECIBO == receipt.RECIBO)
      state = state :+ receipt
      receipt
    }
}