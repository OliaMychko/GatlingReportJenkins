package groups

import config.BaseHelpers.thinkTimer
import io.gatling.core.Predef._
import io.gatling.core.structure.ChainBuilder

object CheckoutProductGroups {

  def openCartAndCheckout(): ChainBuilder = {
    group("Open cart") {
      exec(api.commonApi.actuatorHealthOptions())
        .exec(api.commonApi.getActuatorHealth())
        .exec(api.commonApi.contentBoxesOptions())
        .exec(api.productCart.cartIdWithStoreOptions())
        .exec(api.commonApi.contentPagesOptions())
        .exec(api.commonApi.categoryOptions())
        .exec(api.commonApi.getCategory())
        .exec(api.commonApi.storeOptions())
        .exec(api.commonApi.getStore())
        .exec(api.commonApi.getContentPages())
        .exec(api.productCart.getCartIdWithStore())
        .exec(thinkTimer())
    }
      .group("Proceed to checkout") {
        exec(api.commonApi.actuatorHealthOptions())
          .exec(api.commonApi.getActuatorHealth())
          .exec(api.checkOut.shippingCountryOptions())
          .exec(api.productCart.cartIdWithStoreOptions())
          .exec(api.productCart.cartTotalOptions())
          .exec(api.commonApi.contentBoxesOptions())
          .exec(api.checkOut.zonesOptions())
          .exec(api.checkOut.getZones())
          .exec(api.commonApi.contentPagesOptions())
          .exec(api.commonApi.getContentPages())
          .exec(api.checkOut.configOptions())
          .exec(api.productCart.cartShippingOptions())
          .exec(api.commonApi.storeOptions())
          .exec(api.commonApi.categoryOptions())
          .exec(api.checkOut.getShippingCountry())
          .exec(api.commonApi.getCategory())
          .exec(api.commonApi.getStore())
          .exec(api.productCart.getCartIdWithStore())
          .exec(api.checkOut.getConfig())
          .exec(api.productCart.getCartTotal())
          .exec(thinkTimer())
      }
  }
}
