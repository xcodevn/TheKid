import sbt._
import Keys._
import play.Project

object ApplicationBuild extends Build {
  val appName         = "TheKid"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.webjars" %% "webjars-play" % "2.1.0-3"  exclude("org.scala-stm", "scala-stm_2.10.0") exclude("play", "*"), 
    "org.webjars" % "bootstrap" % "3.0.1"
  )

  val main = Project(appName, appVersion, appDependencies).settings()
}
