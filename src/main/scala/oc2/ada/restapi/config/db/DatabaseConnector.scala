package oc2.ada.restapi.config.db

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

class DatabaseConnector(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val restDataSource = {
    val hikariConfig = new HikariConfig()
    hikariConfig.setJdbcUrl(jdbcUrl)
    hikariConfig.setUsername(dbUser)
    hikariConfig.setPassword(dbPassword)

    new HikariDataSource(hikariConfig)
  }

  val profile = slick.jdbc.PostgresProfile
  import profile.api._

  val db = Database.forDataSource(restDataSource, None)
  db.createSession()

}
