package oc2.ada.restapi

import io.circe.Decoder.Result
import io.circe.generic.codec.DerivedAsObjectCodec.deriveCodec
import io.circe.{Decoder, Encoder, HCursor, Json}

import java.sql.{Date, Timestamp}


package object domain {

  type UserId    = String
  type AuthToken = String

  final case class AuthTokenContent(userId: UserId)

  final case class AuthData(ID: UserId, USERNAME: String, EMAIL: String, PASSWORD: String) {
    require(ID.nonEmpty, "ID.empty")
    require(USERNAME.nonEmpty, "USERNAME.empty")
    require(EMAIL.nonEmpty, "EMAIL.empty")
    require(PASSWORD.nonEmpty, "PASSWORD.empty")
  }
  final case class AuthDataUpdate(userName: Option[String]= None, email: Option[String] = None, password: Option[String] = None){
    def merge(auth:AuthData): AuthData =
      AuthData(auth.ID, userName.getOrElse(auth.USERNAME), email.getOrElse(auth.EMAIL), password.getOrElse(auth.PASSWORD))
  }

  final case class UserProfile(ID: UserId, FIRSTNAME: String, LASTNAME: String, TIPO_IPF: String
                               , NUM_IPF: String, DUP_IPF: String, DES_IPF: String) {
    require(ID.nonEmpty, "ID.empty")
    require(FIRSTNAME.nonEmpty, "FIRSTNAME.empty")
    require(LASTNAME.nonEmpty, "LASTNAME.empty")
    require(TIPO_IPF.nonEmpty, "TIPO_IPF.empty")
    require(NUM_IPF.nonEmpty, "NUM_IPF.empty")
    require(DUP_IPF.nonEmpty, "DUP_IPF.empty")
    require(DES_IPF.nonEmpty, "DES_IPF.empty")
  }
  final case class UserProfileUpdate(firstName: Option[String] = None, lastName: Option[String] = None, num_ipf: Option[String] = None) {
    def merge(profile: UserProfile): UserProfile =
      UserProfile(profile.ID, firstName.getOrElse(profile.FIRSTNAME), lastName.getOrElse(profile.LASTNAME)
        , profile.TIPO_IPF, num_ipf.getOrElse(profile.NUM_IPF), profile.DUP_IPF, profile.DES_IPF)
  }

  final case class File(TEXP: String, PEXP: String, AEXP: String, CEXP: String
                        , NEXP: String, DUPEXP: String, DESEXP: String, TIPOIPF: String, NUMIPF: String, DUPIPF: String, DESIPF: String) {
    require(TEXP.nonEmpty, "T_EXP.empty")
    require(PEXP.nonEmpty, "P_EXP.empty")
    require(AEXP.nonEmpty, "A_EXP.empty")
    require(CEXP.nonEmpty, "C_EXP.empty")
    require(NEXP.nonEmpty, "N_EXP.empty")
    require(DUPEXP.nonEmpty, "DU_EXP.empty")
    require(DESEXP.nonEmpty, "DE_EXP.empty")
    require(NUMIPF.nonEmpty, "NUMIPF.empty")

  }
  final case class FileUpdate(exp: Option[String] = None) {
    def merge(file: File): File =
      File(file.TEXP, file.PEXP, file.AEXP , file.CEXP, file.NEXP, file.DUPEXP, file.DESEXP, file.TIPOIPF, file.NUMIPF, file.DUPIPF, file.DESIPF)
  }

  final case class MapaPhntalia(PROGRAMA: String, LIT_CAB: String, EXPEDIENTE: EXPEDIENTE, IPF: IPF){
    require(PROGRAMA.nonEmpty, "T_EXP.empty")
    require(LIT_CAB.nonEmpty, "P_EXP.empty")
    require(EXPEDIENTE.nonEmpty, "EXPEDIENTE.empty")
    require(IPF.nonEmpty, "IPF.empty")
  }
  final case class EXPEDIENTE(TEXP: String, PEXP: String, AEXP: String, CEXP: String
                              , NEXP: String, DUEXP: String, DEEXP: String) {
    require(TEXP.nonEmpty, "T_EXP.empty")
    require(PEXP.nonEmpty, "P_EXP.empty")
    require(AEXP.nonEmpty, "A_EXP.empty")
    require(CEXP.nonEmpty, "C_EXP.empty")
    require(NEXP.nonEmpty, "N_EXP.empty")
    require(DUEXP.nonEmpty, "DU_EXP.empty")
    require(DEEXP.nonEmpty, "DE_EXP.empty")
    def nonEmpty: Boolean = TEXP.nonEmpty
  }
  final case class IPF(TIPOIPF: String, NUMIPF: String ,DUPIPF: String,DESIPF: String) {
//    require(IPF.nonEmpty, "IPF.empty")
    def nonEmpty: Boolean = TIPOIPF.nonEmpty
  }


  final case class Payment(ANIO: String, ENT_PAGO: Int, ENTIDAD: String, FECHA_DESDE: Date,
                           FECHA_HASTA: Date, MOD_PAGO: String, RECIBO: String, SIT: String,
                           SUC_PAGO: Int, TIP_PAGO: String, FILE: String){
    require(ANIO.nonEmpty, "ANIO.empty")
    require(ENT_PAGO!=0, "ENT_PAGO.empty")
    require(ENTIDAD.nonEmpty, "ENTIDAD.empty")
    require(FECHA_DESDE!=null, "FECHA_DESDE.empty")
    require(FECHA_HASTA!=null, "FECHA_HASTA.empty")
    require(MOD_PAGO.nonEmpty, "MOD_PAGO.empty")
    require(RECIBO.nonEmpty, "RECIBO.empty")
    require(SIT.nonEmpty, "SIT.empty")
    require(SUC_PAGO!=0, "SUC_PAGO.empty")
    require(TIP_PAGO.nonEmpty, "TIP_PAGO.empty")
    require(FILE.nonEmpty, "FILE.empty")


  }
  implicit val DateFormat : Encoder[Date] with Decoder[Date] = new Encoder[Date] with Decoder[Date] {
    override def apply(a: Date): Json = Encoder.encodeLong.apply(a.getTime)

    override def apply(c: HCursor): Result[Date] = Decoder.decodeLong.map(s => new Date(s)).apply(c)
  }
  implicit val TimestampFormat : Encoder[Timestamp] with Decoder[Timestamp] = new Encoder[Timestamp] with Decoder[Timestamp] {
    override def apply(a: Timestamp): Json = Encoder.encodeLong.apply(a.getTime)

    override def apply(c: HCursor): Result[Timestamp] = Decoder.decodeLong.map(s => new Timestamp(s)).apply(c)
  }
  implicit val decodePayment:Decoder[Payment] = {
    Decoder.forProduct11("ANIO","ENT_PAGO","ENTIDAD","FECHA_DESDE","FECHA_HASTA","MOD_PAGO","RECIBO","SIT"
    ,"SUC_PAGO","TIP_PAGO","FILE")(Payment.apply)
  }
  implicit val encodePayment:Encoder[Payment] = {
    Encoder.forProduct11("ANIO","ENT_PAGO","ENTIDAD","FECHA_DESDE","FECHA_HASTA","MOD_PAGO","RECIBO","SIT"
      ,"SUC_PAGO","TIP_PAGO","FILE")(p =>
      (p.ANIO,p.ENT_PAGO,p.ENTIDAD,p.FECHA_DESDE,p.FECHA_HASTA,p.MOD_PAGO,p.RECIBO,p.SIT,p.SUC_PAGO,p.TIP_PAGO,p.FILE))
  }
  implicit val decodeUpdatePayment:Decoder[PaymentUpdate] = {
    Decoder.forProduct11("ANIO","ENT_PAGO","ENTIDAD","FECHA_DESDE","FECHA_HASTA","MOD_PAGO","RECIBO","SIT"
      ,"SUC_PAGO","TIP_PAGO","FILE")(PaymentUpdate.apply)
  }
  implicit val encodeUpdatePayment:Encoder[PaymentUpdate] = {
    Encoder.forProduct11("ANIO","ENT_PAGO","ENTIDAD","FECHA_DESDE","FECHA_HASTA","MOD_PAGO","RECIBO","SIT"
      ,"SUC_PAGO","TIP_PAGO","FILE")(p =>
      (p.anio,p.entidadPago,p.entidad,p.fechaDesde,p.fechaHasta,p.modPago,p.recibo,p.sit,p.sucursalPago,p.tipoPago,p.expediente))
  }
  final case class PaymentUpdate(anio: String, entidadPago: Option[Int] = None, entidad:String, fechaDesde: Option[Date] = None,
                                 fechaHasta: Option[Date] = None, modPago: Option[String] = None, recibo:String, sit: Option[String] = None,
                                 sucursalPago: Option[Int] = None, tipoPago: Option[String] = None, expediente: Option[String] = None) {
    def merge(pay: Payment): Payment =
      Payment(pay.ANIO,entidadPago.getOrElse(pay.ENT_PAGO), pay.ENTIDAD,fechaDesde.getOrElse(pay.FECHA_DESDE),
        pay.FECHA_HASTA, modPago.getOrElse(pay.MOD_PAGO), pay.RECIBO, sit.getOrElse(pay.SIT),
        sucursalPago.getOrElse(pay.SUC_PAGO), tipoPago.getOrElse(pay.TIP_PAGO), expediente.getOrElse(pay.FILE))
  }

  final case class Receipt(ANIO_CONTABLE:String, ANNO:String, DIA_CONTABLE:String,
                           DOC_CONTABLE_ANIO:Int, DOC_CONTABLE_DC:String, DOC_CONT_NUM:String,
                           FECHA_EMISION:Date, FECHA_SITU:Date, LIQUIDO_EURO:Double,
                           LIT_NUEVA_SITU:String, LIT_SITU:String, MES_CONTABLE:String,
                           NUEVA_SITU:String, RECIBO:String, SITU:String,
                           TIPO_PAGO:String){
    require(ANIO_CONTABLE.nonEmpty, "ANIO_CONTABLE.empty")
    require(ANNO.nonEmpty, "ANIO.empty")
    require(DIA_CONTABLE.nonEmpty, "DIA_CONTABLE.empty")
    require(DOC_CONTABLE_ANIO!=0, "DOC_CONT_ANIO.empty")
    require(DOC_CONTABLE_DC.nonEmpty, "DOC_CONT_DC.empty")
    require(DOC_CONT_NUM.nonEmpty, "DOC_CONT_NUM.empty")
    require(FECHA_EMISION!=null, "FECHA_EMISION.empty")
    require(FECHA_SITU!=null, "FECHA_SITU.empty")
    require(LIQUIDO_EURO!=0.00, "LIQUIDO_EURO.empty")
    require(LIT_NUEVA_SITU.nonEmpty, "LIT_NUEVA_SITU.empty")
    require(LIT_SITU.nonEmpty, "LIT_SITU.empty")
    require(MES_CONTABLE.nonEmpty, "MES_CONTABLE.empty")
    require(NUEVA_SITU.nonEmpty, "NUEVA_SITU.empty")
    require(RECIBO.nonEmpty, "RECIBO.empty")
    require(SITU.nonEmpty, "SITU.empty")
    require(TIPO_PAGO.nonEmpty, "TIPO_PAGO.empty")
  }

  final case class ReceiptUpdate(anio_contable: Option[String] = None, anio: Option[String] = None, dia_contable: Option[String] = None,
                                 doc_cont_anio: Option[Int] = None, doc_cont_dc: Option[String] = None, doc_cont_num: Option[String] = None,
                                 fecha_emision: Option[Date] = None, fecha_situ: Option[Date] = None, liquido_euro: Option[Double] = None,
                                 lit_nueva_situ: Option[String] = None, lit_situ: Option[String] = None, mes_contable: Option[String] = None,
                                 nueva_situ: Option[String] = None, recibo:String, situ: Option[String] = None, tipo_pago: Option[String] = None) {
    def merge(re: Receipt): Receipt =
      Receipt(anio_contable.getOrElse(re.ANIO_CONTABLE),anio.getOrElse(re.ANNO), dia_contable.getOrElse(re.DIA_CONTABLE),
        doc_cont_anio.getOrElse(re.DOC_CONTABLE_ANIO), doc_cont_dc.getOrElse(re.DOC_CONTABLE_DC), doc_cont_num.getOrElse(re.DOC_CONT_NUM),
        fecha_emision.getOrElse(re.FECHA_EMISION), fecha_situ.getOrElse(re.FECHA_SITU), liquido_euro.getOrElse(re.LIQUIDO_EURO),
        lit_nueva_situ.getOrElse(re.LIT_NUEVA_SITU), lit_situ.getOrElse(re.LIT_SITU), mes_contable.getOrElse(re.MES_CONTABLE),
        nueva_situ.getOrElse(re.NUEVA_SITU), re.RECIBO, situ.getOrElse(re.SITU), tipo_pago.getOrElse(re.TIPO_PAGO))
  }
  implicit val decodeReceipt:Decoder[Receipt] = {
    Decoder.forProduct16("ANIO_CONTABLE","ANIO","DIA_CONTABLE","DOC_CONT_ANIO","DOC_CONT_DC"
    ,"DOC_CONT_NUM","FECHA_EMISION","FECHA_SITU","LIQUIDO_EURO","LIT_NUEVA_SITU","LIT_SITU"
    ,"MES_CONTABLE","NUEVA_SITU","RECIBO","SITU","TIPO_PAGO")(Receipt.apply)
  }
  implicit val encodeReceipt:Encoder[Receipt] = {
    Encoder.forProduct16("ANIO_CONTABLE","ANIO","DIA_CONTABLE","DOC_CONT_ANIO","DOC_CONT_DC"
      ,"DOC_CONT_NUM","FECHA_EMISION","FECHA_SITU","LIQUIDO_EURO","LIT_NUEVA_SITU","LIT_SITU"
      ,"MES_CONTABLE","NUEVA_SITU","RECIBO","SITU","TIPO_PAGO")(p =>
      (p.ANIO_CONTABLE,p.ANNO,p.DIA_CONTABLE,p.DOC_CONTABLE_ANIO,p.DOC_CONTABLE_DC,p.DOC_CONT_NUM,p.FECHA_EMISION,p.FECHA_SITU,p.LIQUIDO_EURO,
        p.LIT_NUEVA_SITU,p.LIT_SITU,p.MES_CONTABLE,p.NUEVA_SITU,p.RECIBO,p.SITU,p.TIPO_PAGO))
  }
  implicit val decodeUpdateReceipt:Decoder[ReceiptUpdate] = {
    Decoder.forProduct16("ANIO_CONTABLE","ANIO","DIA_CONTABLE","DOC_CONT_ANIO","DOC_CONT_DC"
      ,"DOC_CONT_NUM","FECHA_EMISION","FECHA_SITU","LIQUIDO_EURO","LIT_NUEVA_SITU","LIT_SITU"
      ,"MES_CONTABLE","NUEVA_SITU","RECIBO","SITU","TIPO_PAGO")(ReceiptUpdate.apply)
  }
  implicit val encodeUpdateReceipt:Encoder[ReceiptUpdate] = {
    Encoder.forProduct16("ANIO_CONTABLE","ANIO","DIA_CONTABLE","DOC_CONT_ANIO","DOC_CONT_DC"
      ,"DOC_CONT_NUM","FECHA_EMISION","FECHA_SITU","LIQUIDO_EURO","LIT_NUEVA_SITU","LIT_SITU"
      ,"MES_CONTABLE","NUEVA_SITU","RECIBO","SITU","TIPO_PAGO")(p =>
      (p.anio_contable,p.anio,p.dia_contable,p.doc_cont_anio,p.doc_cont_dc,p.doc_cont_num,p.fecha_emision,p.fecha_situ,p.liquido_euro,
        p.lit_nueva_situ,p.lit_situ,p.mes_contable,p.nueva_situ,p.recibo,p.situ,p.tipo_pago))
  }

}
