import scoverage.ScoverageSbtPlugin._

object ScoverageIntegration {

  val settings = instrumentSettings ++ Seq(
    ScoverageKeys.excludedPackages in ScoverageCompile :=
      """views\..*;controllers\..*Reverse.*;controllers\..*javascript.*;controllers\..*ref.*;Routes.*"""
  )
}
