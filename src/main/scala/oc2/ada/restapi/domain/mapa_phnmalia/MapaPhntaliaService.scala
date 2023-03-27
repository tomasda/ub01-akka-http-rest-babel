package oc2.ada.restapi.domain.mapa_phnmalia

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain
import oc2.ada.restapi.domain.files.JdbcFileStorage
import oc2.ada.restapi.domain.{EXPEDIENTE, IPF, MapaPhntalia}

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

class MapaPhntaliaService(val databaseConnector: DatabaseConnector
)(implicit executionContext: ExecutionContext) {

  def getMapaPhntaliaById(id: String) : Future[MapaPhntalia] =  Future {
    val fileStorage: JdbcFileStorage = new JdbcFileStorage(databaseConnector)
    val file: Future[Option[domain.File]] = fileStorage.getFile(id)

    val res = Await.ready(file, Duration.Inf).value.get
    val r:MapaPhntalia = res match {
      case Success(t) =>
        val res = Right(t).value.get
        val e = EXPEDIENTE(TEXP = res.TEXP,PEXP = res.PEXP ,AEXP = res.AEXP ,CEXP = res.CEXP ,NEXP = res.NEXP,DUEXP = res.DUPEXP,DEEXP = res.DESEXP)
        val i =  IPF(TIPOIPF = res.TIPOIPF ,NUMIPF = res.NUMIPF ,DUPIPF = res.DUPIPF ,DESIPF = res.DESIPF )
        val a =  MapaPhntalia(PROGRAMA = "prog", LIT_CAB = "litcab", EXPEDIENTE = e, IPF = i)
        a
      case Failure(e) =>
        //Left(e)
        val e = EXPEDIENTE(TEXP = "",PEXP = "" ,AEXP = "" ,CEXP = "" ,NEXP = "",DUEXP = "",DEEXP = "")
        val i =  IPF(TIPOIPF = "" ,NUMIPF = "" ,DUPIPF = "" ,DESIPF = "" )
        MapaPhntalia(PROGRAMA = "", LIT_CAB = "", EXPEDIENTE = e, IPF = i)
    }
    r
  }

  def getMapaPhntalias: Future[Seq[MapaPhntalia]] =  Future {
    val e = EXPEDIENTE(TEXP = "test",PEXP = "test",AEXP = "test",CEXP = "test",NEXP = "test",DUEXP = "test",DEEXP = "test")
    val i = IPF(TIPOIPF = "test" ,NUMIPF = "test" ,DUPIPF = "test" ,DESIPF = "test" )
    val a = MapaPhntalia(PROGRAMA = "prog", LIT_CAB = "litcab", EXPEDIENTE = e, IPF = i)
    val r = Seq(a)
    r
  }


//  def getFilesByIPF(id:String): Future[Seq[File]] =
//    fileStorage.getFilesByIPF(id)
//
//  def getFile(id: String): Future[Option[File]] =
//    fileStorage.getFile(id)
//  def getFile(t_exp: String, p_exp: String, a_exp: String,
//              c_exp: String, n_exp: String, du_exp: String,
//              de_exp: String): Future[Option[File]] =
//    fileStorage.getFile(t_exp, p_exp, a_exp, c_exp, n_exp, du_exp, de_exp)
//
//  def createFile(file: File): Future[File] =
//    fileStorage.saveFile(file)
//
//  def updateFile(id: String, fileUpdate: FileUpdate): Future[Option[File]] =
//    fileStorage
//      .getFile(id)
//      .mapT(fileUpdate.merge)
//      .flatMapTOuter(fileStorage.saveFile)

}
