name := "crossword"
version := ".1"
scalaVersion := "2.12.2"

/*scalacOptions := Seq(
  "-encoding",
  "UTF-8",
  "-target:jvm-1.8")
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-language:postfixOps")*/

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

// libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.13.4" //using for generators % "test
