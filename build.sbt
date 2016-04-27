
name := "textie"

version := "1.0"

scalaVersion := "2.11.8"

resourceDirectory in Compile := baseDirectory.value / "src" / "resources"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.5" % "test",
  "junit" % "junit" % "4.11",
  "iguana" % "iguana" % "0.1.0",
  "com.googlecode.kiama" %% "kiama" % "1.8.0" % "test",
  "org.scalaz" %% "scalaz-concurrent" % "7.1.4",
  "org.scalaz" %% "scalaz-core" % "7.1.4",
  "org.scalaz" %% "scalaz-scalacheck-binding" % "7.1.4" % "test"
)