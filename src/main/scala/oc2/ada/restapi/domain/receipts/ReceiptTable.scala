package oc2.ada.restapi.domain.receipts

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.Receipt

import java.sql.Date

private[receipts] trait ReceiptTable {

  protected val databaseConnector: DatabaseConnector
  import databaseConnector.profile.api._

  class Receipts(tag: Tag) extends Table[Receipt](tag, "RECEIPTS") {
    def anio_contable   = column[String]("ANIO_CONTABLE")
    def anio            = column[String]("ANIO")
    def dia_contable    = column[String]("DIA_CONTABLE")
    def doc_cont_anio   = column[Int]("DOC_CONT_ANIO")
    def doc_cont_dc     = column[String]("DOC_CONT_DC")
    def doc_cont_num    = column[String]("DOC_CONT_NUM")
    def fecha_emision   = column[Date]("FECHA_EMISION")
    def fecha_situ      = column[Date]("FECHA_SITU")
    def liquido_euro    = column[Double]("LIQUIDO_EURO")
    def lit_nueva_situ  = column[String]("LIT_NUEVA_SITU")
    def lit_situ        = column[String]("LIT_SITU")
    def mes_contable    = column[String]("MES_CONTABLE")
    def nueva_situ      = column[String]("NUEVA_SITU")
    def recibo          = column[String]("RECIBO", O.PrimaryKey)
    def situ            = column[String]("SITU")
    def tipo_pago       = column[String]("TIPO_PAGO")

    def * = (anio_contable,anio, dia_contable, doc_cont_anio, doc_cont_dc, doc_cont_num,
    fecha_emision, fecha_situ, liquido_euro,lit_nueva_situ, lit_situ,mes_contable,nueva_situ,
      recibo,situ,tipo_pago) <> ((Receipt.apply _).tupled, Receipt.unapply)

  }

  protected val profiles = TableQuery[Receipts]

}