package oc2.ada.restapi.domain.mapa_phnmalia

import oc2.ada.restapi.domain.MapaPhntalia

import scala.concurrent.Future

sealed trait MapaPhntaliaStorage {

  def getMapaPhnmalias: Future[Seq[MapaPhntalia]]
  def getMapaPhnmaliasByIPF(id: String): Future[Seq[MapaPhntalia]]

  def getMapaPhnmalia(id: String): Future[Option[MapaPhntalia]]
  def getMapaPhnmalia(t_exp: String,p_exp: String,a_exp: String,
              c_exp: String,n_exp: String,du_exp: String,
              de_exp: String): Future[Option[MapaPhntalia]]

  def saveMapaPhnmalia(profile: MapaPhntalia): Future[MapaPhntalia]

}

//class JdbcFileStorage(
//    val databaseConnector: DatabaseConnector
//)(implicit executionContext: ExecutionContext)
//    extends MapaPhnmaliaTable
//    with FileStorage {
//  override def getMapaPhnmalias: Future[Seq[MapaPhnmalia]] = ???
//
//  override def getMapaPhnmaliasByIPF(id: String): Future[Seq[MapaPhnmalia]] = ???
//
//  override def getMapaPhnmalia(id: String): Future[Option[MapaPhnmalia]] = ???
//
//  override def getMapaPhnmalia(t_exp: String, p_exp: String, a_exp: String, c_exp: String, n_exp: String, du_exp: String, de_exp: String): Future[Option[MapaPhnmalia]] = ???
//
//  override def saveMapaPhnmalia(profile: MapaPhnmalia): Future[MapaPhnmalia] = ???
//}
//
//  import databaseConnector._
//  import databaseConnector.profile.api._
//
//  def getMapaPhnmalias: Future[Seq[MapaPhnmalia]] = {
//    db.run(profiles.result)
//  }
//  def getFilesByIPF(id: String): Future[Seq[File]] = db.run(profiles.filter(_.ipf === id).result)
//
//  def getFile(id: String): Future[Option[File]] = db.run(profiles.filter(_.t_exp === id.substring(0,1))
//    .filter(_.p_exp === id.substring(1,3))
//    .filter(_.a_exp === id.substring(3,7))
//    .filter(_.c_exp === id.substring(7,8))
//    .filter(_.n_exp === id.substring(8,17))
//    .filter(_.du_exp === id.substring(17,19))
//    .filter(_.de_exp === id.substring(19,21))
//    .result.headOption)
//  override def getFile(t_exp: String, p_exp: String, a_exp: String,
//                       c_exp: String, n_exp: String, du_exp: String,
//                       de_exp: String): Future[Option[File]] =
//    db.run(profiles.filter(_.t_exp === t_exp)
//      .filter(_.p_exp === p_exp)
//      .filter(_.a_exp === a_exp)
//      .filter(_.c_exp === c_exp)
//      .filter(_.n_exp === n_exp)
//      .filter(_.du_exp === du_exp)
//      .filter(_.de_exp === de_exp)
//      .result.headOption)
//
//  def saveFile(file: File): Future[File] =
//    db.run(profiles.insertOrUpdate(file)).map(_ => file)
//
//}

//class InMemoryFileStorage extends FileStorage {
//
//  private var state: Seq[File] = Nil
//
//  override def getFiles: Future[Seq[File]] =
//    Future.successful(state)
//
//  override def getFilesByIPF(id: String): Future[Seq[File]] = ???
//    //Future.successful(state.find(_.ipf == id))
//
//  override def getFile(id: String): Future[Option[File]] =
//    Future.successful(state.find(_.A_EXP == id))
//
//  override def saveFile(file: File): Future[File] =
//    Future.successful {
//      state = state.filterNot(_.A_EXP == file.A_EXP)
//      state = state :+ file
//      file
//    }
//
//  override def getFile(t_exp: String, p_exp: String, a_exp: String, c_exp: String, n_exp: String, du_exp: String, de_exp: String): Future[Option[File]] = ???
//}
