ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "eventfinder",
    idePackagePrefix := Some("cat.cultura.eventfinder"),
    assembly / mainClass := Some("cat.cultura.eventfinder.AkkaController"),
    assembly / assemblyJarName := "eventfinder.jar",
  )

val AkkaVersion = "2.7.0"
val AkkaHttpVersion = "10.4.0"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.5.0-M1"
)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.14"

libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.6"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.5"

ThisBuild / assemblyMergeStrategy :={
  case "module-info.class"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (ThisBuild / assemblyMergeStrategy).value
    oldStrategy(x)
}


enablePlugins(JavaAppPackaging)

