resolvers += Classpaths.sbtPluginReleases
logLevel := Level.Warn

addSbtPlugin("io.spray" %% "sbt-revolver" % "0.9.1")
addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.12")
addSbtPlugin("com.typesafe.sbt" %% "sbt-native-packager" % "1.7.6")
//addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.4")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.1")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.4.2")

