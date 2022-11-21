ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "eventfinder",
    idePackagePrefix := Some("cat.cultura.eventfinder")
  )
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "2.7.5"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jdbc" % "2.7.5"
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-data-jpa" % "2.7.5"
libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.30"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.5.6"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test"
libraryDependencies += "com.google.code.gson" % "gson" % "2.10"


//  ,
//  "org.springframework.boot" % "spring-boot-starter-data-jdbc" % "2.7.5",
//  "org.springframework.boot" % "spring-boot-starter-data-rest" % "2.7.5",
//  "mysql" % "mysql-connector-java"

//)