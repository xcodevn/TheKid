name := "TheKid"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
	"org.mindrot" % "jbcrypt" % "0.3m"
)     

play.Project.playScalaSettings
