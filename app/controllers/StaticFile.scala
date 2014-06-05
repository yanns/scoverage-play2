package controllers

import play.api.mvc.{SimpleResult, Controller, Action}
import scala.io.Source

class StaticFile(app: play.api.Application) extends Controller {

  def resource(fileClasspath: String) = Action {
    app.resourceAsStream(fileClasspath).fold[SimpleResult](NotFound) { is =>
      Ok(Source.fromInputStream(is).mkString).as("text/css")
    }
  }
}

object StaticFile extends StaticFile(play.api.Play.current)