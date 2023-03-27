package oc2.ada.restapi.domain.files

import oc2.ada.restapi.domain.{File, FileUpdate}
import oc2.ada.restapi.utils.MonadTransformers.FutureOptionMonadTransformer

import scala.concurrent.{ExecutionContext, Future}

class FileService(fileStorage: FileStorage
)(implicit executionContext: ExecutionContext) {

  def getFiles: Future[Seq[File]] =
    fileStorage.getFiles

  def getFilesByIPF(tipo: String, num: String, dup: String, des: String): Future[Seq[File]] =
    fileStorage.getFilesByIPF(tipo, num, dup, des)

  def getFile(id: String): Future[Option[File]] =
    fileStorage.getFile(id)
  def getFile(t_exp: String, p_exp: String, a_exp: String,
              c_exp: String, n_exp: String, du_exp: String,
              de_exp: String): Future[Option[File]] =
    fileStorage.getFile(t_exp, p_exp, a_exp, c_exp, n_exp, du_exp, de_exp)

  def createFile(file: File): Future[File] =
    fileStorage.saveFile(file)

  def updateFile(id: String, fileUpdate: FileUpdate): Future[Option[File]] =
    fileStorage
      .getFile(id)
      .mapT(fileUpdate.merge)
      .flatMapTOuter(fileStorage.saveFile)

}
