package oc2.ada.restapi.domain.receipts

import oc2.ada.restapi.domain.{Receipt, ReceiptUpdate}
import oc2.ada.restapi.utils.MonadTransformers.FutureOptionMonadTransformer

import scala.concurrent.{ExecutionContext, Future}

class ReceiptService(receiptStorage: ReceiptsStorage, secretKey: String)(implicit executionContext: ExecutionContext) {

  def getReceipts: Future[Seq[Receipt]] =
    receiptStorage.getReceipts

  def getReceipt(anio: String,recibo: String): Future[Option[Receipt]] =
    receiptStorage.getReceipt(anio, recibo)

  def createReceipt(profile: Receipt): Future[Receipt] =
    receiptStorage.saveReceipt(profile)

  def updateReceipt(anio: String,recibo: String, paymentUpdate: ReceiptUpdate): Future[Option[Receipt]] =
    receiptStorage
      .getReceipt(anio, recibo)
      .mapT(paymentUpdate.merge)
      .flatMapTOuter(receiptStorage.saveReceipt)
}
