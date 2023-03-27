package oc2.ada.restapi.domain.payments

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.Payment
import slick.lifted.Tag

import java.sql.{Date, Time, Timestamp}


private[payments] trait PaymentTable {

  protected val databaseConnector: DatabaseConnector
  import databaseConnector.profile.api._

  class Payments(tag: Tag) extends Table[Payment](tag, "PAYMENTS") {
    def anio         = column[String]("ANIO")
    def ent_pago     = column[Int]("ENT_PAGO")
    def entidad      = column[String]("ENTIDAD")
    def fecha_desde  = column[Date]("FECHA_DESDE")
    def fecha_hasta  = column[Date]("FECHA_HASTA")
    def mod_pago     = column[String]("MOD_PAGO")
    def recibo       = column[String]("RECIBO")
    def sit          = column[String]("SIT")
    def suc_pago     = column[Int]("SUC_PAGO")
    def tip_pago     = column[String]("TIP_PAGO")
    def file         = column[String]("FILE")

    def * = (anio, ent_pago, entidad, fecha_desde,
      fecha_hasta, mod_pago, recibo, sit, suc_pago, tip_pago, file) <> ((Payment.apply _).tupled, Payment.unapply)

    def pkey = primaryKey("PAYMENT_PKEY", (anio, entidad, recibo))
  }

  protected val profiles = TableQuery[Payments]

}