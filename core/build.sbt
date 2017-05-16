scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % "2.12.1",
  compilerPlugin("org.scalamacros" %% "paradise" % "2.1.0" cross CrossVersion.full)
)