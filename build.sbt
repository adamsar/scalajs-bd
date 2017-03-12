import com.lihaoyi.workbench.Plugin._
import org.scalajs.sbtplugin.ScalaJSPlugin

enablePlugins(ScalaJSPlugin)

name := "Blazing duels"

crossScalaVersions := Seq("2.11.8", "2.12.1")

scalaVersion := "2.12.1"

workbenchSettings

bootSnippet := "net.andrew.App().main();"

testFrameworks += new TestFramework("utest.runner.Framework")

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.1",
  "com.lihaoyi"  %%% "scalatags"   % "0.6.3",
  "com.lihaoyi"  %%% "utest"       % "0.4.5" % "test",
  "io.suzaku"    %%% "diode-core"  % "1.1.1",
  "org.scalaz" %%%  "scalaz-core" % "7.2.9",
  "com.github.japgolly.scalacss" %%% "core" % "0.5.1",
  "com.github.japgolly.scalacss" %%% "ext-scalatags" % "0.5.1"
)
