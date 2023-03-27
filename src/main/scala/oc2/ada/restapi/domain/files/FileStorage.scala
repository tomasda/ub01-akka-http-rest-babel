package oc2.ada.restapi.domain.files

import oc2.ada.restapi.config.db.DatabaseConnector
import oc2.ada.restapi.domain.File

import scala.concurrent.{ExecutionContext, Future}

sealed trait FileStorage {

  def getFiles: Future[Seq[File]]
  def getFilesByIPF(tipo: String, num: String, dup: String, des: String): Future[Seq[File]]

  def getFile(id: String): Future[Option[File]]
  def getFile(t_exp: String,p_exp: String,a_exp: String,
              c_exp: String,n_exp: String,du_exp: String,
              de_exp: String): Future[Option[File]]

  def saveFile(profile: File): Future[File]

}

class JdbcFileStorage(
    val databaseConnector: DatabaseConnector
)(implicit executionContext: ExecutionContext)
    extends FileTable
    with FileStorage {

  import databaseConnector._
  import databaseConnector.profile.api._

  def getFiles: Future[Seq[File]] = {
    db.run(profiles.result)
  }
  def getFilesByIPF(tipo: String, num: String, dup: String, des: String): Future[Seq[File]]
    = db.run(profiles.filter(_.tipo_ipf === tipo)
    .filter(_.num_ipf === num)
    .filter(_.du_exp === dup)
    .filter(_.des_ipf === des).result)

  def getFile(id: String): Future[Option[File]]
   = db.run(profiles.filter(_.t_exp === id.substring(0,1))
    .filter(_.p_exp === id.substring(1,3))
    .filter(_.a_exp === id.substring(3,7))
    .filter(_.c_exp === id.substring(7,8))
    .filter(_.n_exp === id.substring(8,17))
    .filter(_.du_exp === id.substring(17,19))
    .filter(_.de_exp === id.substring(19,21))
    .result.headOption)
  override def getFile(t_exp: String, p_exp: String, a_exp: String,
                       c_exp: String, n_exp: String, du_exp: String,
                       de_exp: String): Future[Option[File]] =
    db.run(profiles.filter(_.t_exp === t_exp)
      .filter(_.p_exp === p_exp)
      .filter(_.a_exp === a_exp)
      .filter(_.c_exp === c_exp)
      .filter(_.n_exp === n_exp)
      .filter(_.du_exp === du_exp)
      .filter(_.de_exp === de_exp)
      .result.headOption)

  def saveFile(file: File): Future[File] =
    db.run(profiles.insertOrUpdate(file)).map(_ => file)

}

class InMemoryFileStorage extends FileStorage {

  private var state: Seq[File] = Nil

  override def getFiles: Future[Seq[File]] =
    Future.successful(state)

  override def getFilesByIPF(tipo: String, num: String, dup: String, des: String): Future[Seq[File]] = ???
    //Future.successful(state.find(_.ipf == id))

  override def getFile(id: String): Future[Option[File]] =
    Future.successful(state.find(_.AEXP == id))

  override def saveFile(file: File): Future[File] =
    Future.successful {
      state = state.filterNot(_.AEXP == file.AEXP)
      state = state :+ file
      file
    }

  override def getFile(t_exp: String, p_exp: String, a_exp: String, c_exp: String, n_exp: String, du_exp: String, de_exp: String): Future[Option[File]] = ???
}
