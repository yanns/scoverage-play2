import sbt._
import sbt.Keys._
import com.typesafe.sbt.web.Import.TestAssets
import com.typesafe.sbt.web.Import.WebKeys.assets
import scoverage.ScoverageSbtPlugin._

object ScoverageIntegration {

  val settings = instrumentSettings ++ Seq(
    ScoverageKeys.excludedPackages in ScoverageCompile :=
      """views\..*;controllers\..*Reverse.*;controllers\..*javascript.*;controllers\..*ref.*;Routes.*""",

    fullClasspath in ScoverageTest ++= {
      val testAssetDirs = ((assets in TestAssets) ?).all(ScopeFilter(inDependencies(ThisProject))).value.flatten
      testAssetDirs.map(dir => Attributed.blank(dir.getParentFile))
    }

  )
}
