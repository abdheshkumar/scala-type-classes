import sbt.Keys.version

lazy val core = (project in file("core"))

lazy val examples = (project in file("."))
  .dependsOn(core)
  .settings(
    name := "examples",
    version := "1.0",
    scalaVersion := "2.12.1"
  )
  .settings(libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.5.1",
    "com.typesafe.akka" %% "akka-stream" % "2.5.1",
    "com.typesafe.akka" %% "akka-stream-testkit" % "2.5.1",
    "com.typesafe.akka" %% "akka-testkit" % "2.5.1"
  ))