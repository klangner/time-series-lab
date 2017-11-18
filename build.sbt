name := "time-series-lab"

version := "0.1"

scalaVersion := "2.12.4"

import sbt.Resolver

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.10",
  "io.github.carldata" %% "flow-script" % "0.7.9",
  // Log dependencies
  "org.slf4j" % "slf4j-api" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  // Test dependencies
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.7"
)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case "reference.conf" => MergeStrategy.concat
  case x => MergeStrategy.first
}

scalacOptions := Seq("-unchecked", "-deprecation")

assemblyJarName in assembly := "timeserieslab.jar"