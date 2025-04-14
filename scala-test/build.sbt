ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.16"

lazy val root = (project in file("."))
  .settings(
    name := "scala-test"
  )

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core"     % "2.9.0",
  "org.typelevel" %% "cats-effect"   % "3.4.8",
  "org.typelevel" %% "cats-free"     % "2.9.0"
)