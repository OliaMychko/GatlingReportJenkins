package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object commonApi {

  def actuatorHealthOptions(): ChainBuilder = {
    exec(
      http("OPTIONS actuator/health/ping")
        .options("actuator/health/ping")
    )
  }

  def getActuatorHealth(status: String = "UP"): ChainBuilder = {
    exec(
      http("GET actuator/health/ping")
        .get("actuator/health/ping").asJson
        .check(jsonPath("$.status").is(s"$status"))
    )
  }

  def contentBoxesOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/content/boxes/headerMessage/?lang=en")
        .options("api/v1/content/boxes/headerMessage/?lang=en")
    )
  }

  def storeOptions(): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/store/DEFAULT")
        .options(s"api/v1/store/DEFAULT")
    )
  }

  def getStore(): ChainBuilder = {
    exec(
      http(s"GET api/v1/store/DEFAULT")
        .get(s"api/v1/store/DEFAULT ")
    )
  }

  def getContentPages(): ChainBuilder = {
    exec(
      http("GET api/v1/content/pages/?page=0&count=20&store=DEFAULT&lang=en")
        .get("api/v1/content/pages/?page=0&count=20&store=DEFAULT&lang=en ")
    )
  }

  def contentPagesOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/content/pages/?page=0&count=20&store=DEFAULT&lang=en")
        .options("api/v1/content/pages/?page=0&count=20&store=DEFAULT&lang=en ")
    )
  }

  def categoryOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/category/?page=0&count=20&store=DEFAULT&lang=en")
        .options("api/v1/category/?page=0&count=20&store=DEFAULT&lang=en")
    )
  }

  def getCategory(): ChainBuilder = {
    exec(
      http("GET api/v1/category/")
        .get("api/v1/category/")
    )
  }

  def productPriceOptions(id: Int = 1): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/product/$id/price/")
        .options(s"api/v1/product/$id/price/")
    )
  }

  def postProductPrice(id: Int = 1): ChainBuilder = {
    exec(
      http(s"POST api/v1/product/$id/price/")
        .post(s"api/v1/product/$id/price/")
        .body(StringBody("""{"options":[]}""")).asJson
        .check(jsonPath("$.id").ofType[Int].is(0))
    )
  }

  def categoryOptionsId(id: Int = 1): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/category/$id?store=DEFAULT&lang=en")
        .options(s"api/v1/category/$id?store=DEFAULT&lang=en")
    )
  }

  def getCategory(id: Int = 1, code: String): ChainBuilder = {
    exec(
      http(s"GET api/v1/category/$id?store=DEFAULT&lang=en")
        .get(s"api/v1/category/$id?store=DEFAULT&lang=en")
        .check(jsonPath("$.code").is(s"$code"))
    )
  }

  def categoryManufacturersOptions(id: Int = 1): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/category/$id/manufacturers/?store=DEFAULT&lang=en")
        .options(s"api/v1/category/$id/manufacturers/?store=DEFAULT&lang=en")
    )
  }

  def getCategoryManufacturers(id: Int = 1): ChainBuilder = {
    exec(
      http(s"GET api/v1/category/$id/manufacturers/?manufacturers")
        .get(s"api/v1/category/$id/manufacturers/?manufacturers")
    )
  }
}