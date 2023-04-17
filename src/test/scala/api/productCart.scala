package api

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object productCart extends BaseApi {

  def productReviewOptions(id: Int = 1): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/products/$id/reviews?store=DEFAULT ")
        .options(s"api/v1/products/$id/reviews?store=DEFAULT ")
    )
  }

  def getProductReview(id: Int = 1): ChainBuilder = {
    exec(
      http(s"GET api/v1/products/$id/reviews?store=DEFAULT")
        .get(s"api/v1/products/$id/reviews?store=DEFAULT")
    )
  }

  def productOptions(id: Int = 1): ChainBuilder = {
    exec(
      http(s"OPTIONS api/v1/products/$id?lang=en&store=DEFAULT")
        .options(s"api/v1/products/$id?lang=en&store=DEFAULT")
    )
  }

  def getProduct(id: Int = 1): ChainBuilder = {
    exec(
      http(s"GET api/v1/products/$id?lang=en&store=DEFAULT")
        .get(s"api/v1/products/$id?lang=en&store=DEFAULT")
        .check(regex("id"))
    )
  }

  def getCartId(): ChainBuilder = {
    exec(
      http(String.format("GET api/v1/cart/${%s}?lang=en", CartId))
        .get(String.format("api/v1/cart/${%s}?lang=en", CartId))
        .check(jsonPath("$.code").is(String.format("${%s}", CartId)))
    )
  }

  def cartIdWithStoreOptions(): ChainBuilder = {
    exec(
      http(String.format("OPTIONS api/v1/cart/${%s}?store=DEFAULT", CartId))
        .options(String.format("api/v1/cart/${%s}?store=DEFAULT", CartId))
    )
  }

  def getCartIdWithStore(): ChainBuilder = {
    exec(
      http(String.format("GET api/v1/cart/${%s}?store=DEFAULT", CartId))
        .get(String.format("api/v1/cart/${%s}?store=DEFAULT", CartId))
        .check(jsonPath("$.code").is(String.format("${%s}", CartId)))
    )
  }

  def cartTotalOptions(): ChainBuilder = {
    exec(
      http(String.format("OPTIONS api/v1/cart/${%s}/total/", CartId))
        .options(String.format("api/v1/cart/${%s}/total/", CartId))
    )
  }

  def getCartTotal(): ChainBuilder = {
    exec(
      http(String.format("GET api/v1/cart/${%s}/total/", CartId))
        .get(String.format("api/v1/cart/${%s}/total/", CartId))
        .check(regex("total"))
    )
  }

  def cartShippingOptions(): ChainBuilder = {
    exec(
      http(String.format("OPTIONS api/v1/cart/${%s}/shipping/", CartId))
        .options(String.format("api/v1/cart/${%s}/shipping/", CartId))
    )
  }
}