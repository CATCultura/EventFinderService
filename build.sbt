ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "eventfinder",
    idePackagePrefix := Some("cat.cultura.eventfinder"),
    assembly / mainClass := Some("cat.cultura.eventfinder.EventFinderApplication"),
    assembly / assemblyJarName := "eventfinder.jar",
//    ThisBuild / assemblyMergeStrategy := {
//      case _ => MergeStrategy.deduplicate
//    }
  )
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.7.6"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14"

//libraryDependencies += "org.springframework" % "spring-webmvc" % "6.0.0"

libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.13"

libraryDependencies += "org.json4s" %% "json4s-native" % "4.0.6"


enablePlugins(JavaAppPackaging)

//  ,
//  "org.springframework.boot" % "spring-boot-starter-data-jdbc" % "2.7.5",
//  "org.springframework.boot" % "spring-boot-starter-data-rest" % "2.7.5",
//  "mysql" % "mysql-connector-java"

//)