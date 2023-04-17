package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object chairPage {

  def chairProductOptions(categoryId: Int = 51): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/products/")
        .options("/api/v1/products/{$categoryId}?lang=en&store=DEFAULT")
    )
  }

  def getChairProducts(categoryId: Int = 51): ChainBuilder = {
    exec(
      http("GET api/v1/products/")
         .get("/api/v1/products/{$categoryId}?lang=en&store=DEFAULT")
    )
  }
}
  