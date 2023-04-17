package api

import config.BaseHelpers._
import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._

object checkOut {

  def shippingCountryOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/shipping/country?store=DEFAULT&lang=en")
        .options("api/v1/shipping/country?store=DEFAULT&lang=en")
    )
  }

  def getShippingCountry(): ChainBuilder = {
    exec(
      http("GET api/v1/shipping/country?store=DEFAULT&lang=en")
        .get("api/v1/shipping/country?store=DEFAULT&lang=en")
    )
  }

  def zonesOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/zones/")
        .options("api/v1/zones/")
        .queryParam("code", "")
    )
  }

  def getZones(): ChainBuilder = {
    exec(
      http("GET api/v1/zones/")
        .get("api/v1/zones/")
        .queryParam("code", "")
    )
  }

  def configOptions(): ChainBuilder = {
    exec(
      http("OPTIONS api/v1/config/")
        .options("api/v1/config/")
    )
  }

  def getConfig(): ChainBuilder = {
    exec(
      http("GET api/v1/config/")
        .get("api/v1/config/")
        .check(regex("facebook"))
    )
  }

}
