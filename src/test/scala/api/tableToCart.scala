package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object tableToCart extends BaseApi {
  def cartOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/cart/")
        .options("/api/v1/cart/?store=DEFAULT")
    )
  }

  def postCart(): ChainBuilder = {
    exec(
      http("POST api/v1/cart/")
        .post("/api/v1/cart/?store=DEFAULT")
        .body(StringBody("""{"attributes":[],"product":"table1","quantity":2}""")).asJson
        .check(jsonPath("$.code").saveAs(CartId))
    )
  }

  def cartIdOptions(): ChainBuilder = {
    exec(
      http(String.format("OPTIONS api/v1/cart/${%s}?lang=en", CartId))
        .options(String.format("api/v1/cart/${%s}lang=en", CartId))
    )
  }
}
