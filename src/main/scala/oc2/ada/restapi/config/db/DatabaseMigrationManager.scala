package oc2.ada.restapi.config.db

import org.flywaydb.core.Flyway

import scala.language.postfixOps

class DatabaseMigrationManager(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val flyway = new Flyway()
  flyway.setDataSource(jdbcUrl, dbUser, dbPassword)
  flyway.setBaselineOnMigrate(true)
  flyway.repair()

  def migrateDatabaseSchema(): Unit = flyway.migrate()

  def dropDatabase(): Unit = flyway.clean()

}
