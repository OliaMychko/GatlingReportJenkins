package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object chairToCart extends BaseApi {

  def cartWithLangOptions(): ChainBuilder = {
    exec(
      http(String.format("OPTIONS api/v1/cart/${%s}", CartId))
        .options(String.format("/api/v1/cart/${%s}?lang=en", CartId))

    )
  }

  def putCart(): ChainBuilder = {
    exec(
      http(String.format("PUT api/v1/cart/${%s}", CartId))
        .put(String.format("api/v1/cart/${%s}/?store=DEFAULT", CartId))
        .body(StringBody("""{"attributes":[],"product":"table1","quantity":2}""")).asJson
        .check(jsonPath("$.code").is(String.format("${%s}", CartId)))
    )
  }
}
 