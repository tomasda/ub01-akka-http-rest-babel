import sbt._

object Dependencies {
  val akkaV = "2.6.13"
  val akkaHttpV = "10.2.4"
  val scalaTestV = "3.2.5"
  val slickVersion = "3.3.3"
  val circeV = "0.12.3"
  val sttpV = "3.2.0"
  val commonDependencies: Seq[ModuleID] = Seq(
    // logging
    "org.slf4j" % "slf4j-api" % "1.7.25",

    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    // HTTP server
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpV,

    // Support of CORS requests, version depends on akka-http
    "ch.megard" %% "akka-http-cors" % "1.1.1",

    // SQL generator
    "com.typesafe.slick" %% "slick" % slickVersion,

    // Postgres driver
    "org.postgresql" % "postgresql" % "42.1.4",

    // Migration for SQL databases
    "org.flywaydb" % "flyway-core" % "4.2.0",

    // Connection pool for database
    "com.zaxxer" % "HikariCP" % "2.7.0",

    // Encoding decoding sugar, used in passwords hashing
    "com.github.fdietze.hasher" %% "hasher" % "75be8ed",

    // Parsing and generating of JWT tokens
    "com.pauldijou" %% "jwt-core" % "5.0.0",

    // Config file parser
    "com.github.pureconfig" %% "pureconfig" % "0.14.1",

    // JSON serialization library
    "io.circe" %% "circe-core" % circeV,
    "io.circe" %% "circe-generic" % circeV,
    "io.circe" %% "circe-parser" % circeV,

    // Sugar for serialization and deserialization in akka-http with circe
    "de.heikoseeberger" %% "akka-http-circe" % "1.36.0",

    // Validation library
    "com.wix" %% "accord-core" % "0.7.6",

    // Http client, used currently only for IT test
    "com.softwaremill.sttp.client3" %% "core" % sttpV % Test,
    "com.softwaremill.sttp.client3" %% "akka-http-backend" % sttpV % Test,

    "com.typesafe.akka" %% "akka-testkit" % akkaV % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaV % Test,

    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV % Test,
    "org.scalatest" %% "scalatest" % scalaTestV % Test,
    "org.mockito" %% "mockito-scala-scalatest" % "1.16.32" % Test,
    "ru.yandex.qatools.embed" % "postgresql-embedded" % "2.10" % Test
  )

  val excludedDependencies = Seq(
    "org.slf4j" % "slf4j-log4j12"
  )

}
