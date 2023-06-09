package oc2.ada.restapi.config

import pureconfig.loadConfig
import pureconfig.generic.auto._

case class Config(secretKey: String, http: HttpConfig, database: DatabaseConfig)

object Config {
  def load() =
    loadConfig[Config] match {
      case Right(config) => config
      case Left(error) =>
        throw new RuntimeException("Cannot read config file, errors:\n" + error.toList.mkString("\n"))
    }
}

private[config] case class HttpConfig(host: String, port: Int)
private[config] case class DatabaseConfig(jdbcUrl: String, username: String, password: String)
