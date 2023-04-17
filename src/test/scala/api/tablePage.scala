package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object tablePage{
  def getCategories(): ChainBuilder = {
    exec(
      http("/api/v1/category/")
        .get("/api/v1/category/?count=20&page=0&store=DEFAULT&lang=en")
    )
  }

  def tableProductOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/products/")
        .options("/api/v1/products/?&store=DEFAULT&lang=en&page=0&count=15&category=50 ")
    )
  }

  def getProducts(): ChainBuilder = {
    exec(
      http("GET /api/v1/products/")
        .get("/api/v1/products/?&store=DEFAULT&lang=en&page=0&count=15&category=50")
    )
  }
}

