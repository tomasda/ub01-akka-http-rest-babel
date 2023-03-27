package oc2.ada.restapi

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import oc2.ada.restapi.http.HttpRoute
import oc2.ada.restapi.config.Config
import oc2.ada.restapi.config.db.{DatabaseConnector, DatabaseMigrationManager}
import oc2.ada.restapi.domain.auth.{AuthService, JdbcAuthDataStorage}
import oc2.ada.restapi.domain.files.{FileService, JdbcFileStorage}
import oc2.ada.restapi.domain.mapa_phnmalia.MapaPhntaliaService
import oc2.ada.restapi.domain.payments.{JdbcPaymentStorage, PaymentService}
import oc2.ada.restapi.domain.profiles.{JdbcUserProfileStorage, UserProfileService}
import oc2.ada.restapi.domain.receipts.{JdbcReceiptStorage, ReceiptService}
import org.slf4j

import scala.concurrent.{ExecutionContext, Future}

object Boot extends App {
  private val logger = slf4j.LoggerFactory.getLogger(Boot.getClass)
  def startApplication(): Future[Http.ServerBinding] = {
    implicit val actorSystem: ActorSystem = ActorSystem()
    implicit val executor: ExecutionContext      = actorSystem.dispatcher

    val config = Config.load()

    new DatabaseMigrationManager(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    ).migrateDatabaseSchema()

    val databaseConnector = new DatabaseConnector(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    )

    val authDataStorage     = new JdbcAuthDataStorage(databaseConnector)
    val userProfileStorage  = new JdbcUserProfileStorage(databaseConnector)
    val fileStorage         = new JdbcFileStorage(databaseConnector)
    val paymentStorage      = new JdbcPaymentStorage(databaseConnector)
    val receiptsStorage     = new JdbcReceiptStorage(databaseConnector)

    val authService     = new AuthService(authDataStorage, config.secretKey)
    val usersService    = new UserProfileService(userProfileStorage)
    val fileService     = new FileService(fileStorage)
    val mapaphnmalia    = new MapaPhntaliaService(databaseConnector)
    val paymentService  = new PaymentService(paymentStorage, config.secretKey)
    val receiptService  = new ReceiptService(receiptsStorage, config.secretKey)
    val httpRoute       = new HttpRoute( authService,usersService, fileService, mapaphnmalia, paymentService, receiptService, config.secretKey)

    logger.info(s"🌍 Listening at ${config.http.host}:${config.http.port}")

    Http().newServerAt(config.http.host, config.http.port).bind(httpRoute.route)
  }

  startApplication()

}
