package oc2.ada.restapi.domain.mapa_phnmalia

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.File

private[mapa_phnmalia] trait MapaPhntaliaTable {

  protected val databaseConnector: DatabaseConnector

  import databaseConnector.profile.api._

  class MapaPhnmalias(tag: Tag) extends Table[File](tag, "FILES") {
    def t_exp   = column[String]("T_EXP")
    def p_exp   = column[String]("P_EXP")
    def a_exp   = column[String]("A_EXP")
    def c_exp   = column[String]("C_EXP")
    def n_exp   = column[String]("N_EXP")
    def du_exp  = column[String]("DU_EXP")
    def de_exp  = column[String]("DE_EXP")
    def tipo_ipf = column[String]("TIPOIPF")
    def num_ipf  = column[String]("NUMIPF")
    def dup_ipf  = column[String]("DUPIPF")
    def des_ipf  = column[String]("DESIPF")


    def * = (t_exp, p_exp, a_exp,c_exp,n_exp,du_exp,de_exp,tipo_ipf,num_ipf,dup_ipf,des_ipf) <> ((File.apply _).tupled, File.unapply)

    def pkey = primaryKey("FILE_PKEY", (t_exp, p_exp, a_exp, c_exp, n_exp, du_exp, de_exp))
  }

  protected val profiles = TableQuery[MapaPhnmalias]

}


