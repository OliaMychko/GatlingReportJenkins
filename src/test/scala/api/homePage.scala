package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object homePage {
  def launchApp(): ChainBuilder = {
    exec(
      http("GET" + HomePage)
        .get(HomePage)
    )
  }

  def groupOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/products/group/FEATURED_ITEM")
        .options("/api/v1/products/group/FEATURED_ITEM?store=DEFAULT&lang=en")
    )
  }

  def getProductsGroup(): ChainBuilder = {
    exec(
      http("GET /api/v1/products/group/FEATURED_ITEM")
        .get("/api/v1/products/group/FEATURED_ITEM?store=DEFAULT&lang=en")
    )
  }
}
        