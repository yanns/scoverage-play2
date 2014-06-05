package controllers

import org.specs2.mutable.Specification
import play.api.test.{FakeRequest, FakeApplication}
import play.api.test.Helpers._

class StaticFileTest extends Specification {

  "StaticFile" should {

    "deliver public/stylesheets/main.css" in {
      val result = new StaticFile(FakeApplication()).resource("public/stylesheets/main.css").apply(FakeRequest())
      status(result) must_== 200
    }

    "not deliver blabla.css" in {
      val result = new StaticFile(FakeApplication()).resource("blabla.css").apply(FakeRequest())
      status(result) must_== 404
    }
  }

}
