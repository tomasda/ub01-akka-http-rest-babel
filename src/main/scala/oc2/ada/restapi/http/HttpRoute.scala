package oc2.ada.restapi.http

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._
import oc2.ada.restapi.domain.auth.AuthService
import oc2.ada.restapi.domain.files.FileService
import oc2.ada.restapi.domain.mapa_phnmalia.MapaPhntaliaService
import oc2.ada.restapi.domain.payments.PaymentService
import oc2.ada.restapi.domain.profiles.UserProfileService
import oc2.ada.restapi.domain.receipts.ReceiptService
import oc2.ada.restapi.http.routes.{AuthRoute, FileRoute, PaymentRoute, ProfileRoute, ReceiptRoute}

import scala.concurrent.ExecutionContext

class HttpRoute(
                 authService: AuthService,
                 userProfileService: UserProfileService,
                 fileService: FileService,
                 mapaPhnmaliaService: MapaPhntaliaService,
                 paymentService: PaymentService,
                 receiptService: ReceiptService,
                 secretKey: String
)(implicit executionContext: ExecutionContext) {

  private val authRouter  = new AuthRoute(authService)
  private val usersRouter = new ProfileRoute(secretKey, userProfileService)
  private val fileRouter = new FileRoute(secretKey, fileService, mapaPhnmaliaService)
  private val paymentRoute = new PaymentRoute(secretKey, paymentService)
  private val receiptRoute = new ReceiptRoute(secretKey, receiptService)

  val route: Route =
    cors() {
      pathPrefix("v1") {
        authRouter.route ~
        usersRouter.route ~
        fileRouter.route ~
        paymentRoute.route ~
        receiptRoute.route
      } ~
      pathPrefix("healthcheck") {
        get {
          complete("OK")
        }
      }
    }

}


