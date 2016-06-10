name := """aton"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala, DebianPlugin)

maintainer in Linux := "Camilo Sampedro <camilo.sampedro@udea.edu.co>"

packageSummary in Linux := "Aton, Laboratory Administrator"

packageDescription := "Computer laboratory administrator with useful tools. Built on top of SSH."

scalaVersion := "2.11.7"

resolvers += "JAnalyse Repository" at "http://www.janalyse.fr/repository/"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq(
  //jdbc,
  "jp.t2v" %% "play2-auth" % "0.14.2",
  "jp.t2v" %% "play2-auth-test" % "0.14.2" % "test",
  cache,
  ws,
  specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "mysql" % "mysql-connector-java" % "5.1.34",
  "com.typesafe.play" %% "play-slick" % "2.0.2",
  "org.webjars" %% "webjars-play" % "2.5.0",
  "com.typesafe.play" %% "play-slick-evolutions" % "2.0.2",
  "com.typesafe.akka" %% "akka-actor" % "2.4.5",
  "fr.janalyse" %% "janalyse-ssh" % "0.9.19" % "compile"
)

libraryDependencies ++= Seq(
  "org.webjars" % "bootstrap" % "3.3.6",
  "org.webjars" % "jquery" % "2.2.1",
  "org.webjars" % "requirejs" % "2.2.0",
  "org.webjars" % "ionicons" % "2.0.1"
)



