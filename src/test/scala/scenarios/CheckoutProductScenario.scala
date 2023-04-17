package scenarios

import config.BaseHelpers.{initScenario, thinkTimer}
import io.gatling.core.Predef._
import io.gatling.core.structure._

object CheckoutProductScenario {

  private val ChairBuyersPercent = 15d;
  private val ChairAndTableBuyersPercent = 30d;
  private val TableBuyersPercent = 50d;

  def scnChoseAndCheckoutProduct: ScenarioBuilder = initScenario("Scenario Add and Checkout Product")
    .exitBlockOnFail(
      group("Open home page") {
        exec(api.homePage.launchApp()
          .exec(api.commonApi.actuatorHealthOptions())
          .exec(api.commonApi.getActuatorHealth())
          .exec(api.commonApi.contentBoxesOptions())
          .exec(api.homePage.groupOptions())
          .exec(api.commonApi.contentPagesOptions())
          .exec(api.commonApi.storeOptions())
          .exec(api.commonApi.categoryOptions())
          .exec(api.homePage.getProductsGroup())
          .exec(api.commonApi.getStore())
          .exec(api.commonApi.getContentPages())
          .exec(api.commonApi.getCategory())
          .exec(api.commonApi.productPriceOptions(51))
          .exec(api.commonApi.productPriceOptions())
          .exec(api.commonApi.postProductPrice())
          .exec(api.commonApi.productPriceOptions(50))
          .exec(api.commonApi.productPriceOptions(50))
          .exec(api.commonApi.productPriceOptions(52))
          .exec(api.commonApi.postProductPrice(51))
          .exec(thinkTimer()))
      }
        .group("Open tables tab") {
          exec(api.commonApi.actuatorHealthOptions())
            .exec(api.commonApi.getActuatorHealth())
            .exec(api.commonApi.contentBoxesOptions())
            .exec(api.tablePage.tableProductOptions())
            .exec(api.commonApi.contentPagesOptions())
            .exec(api.commonApi.storeOptions())
            .exec(api.commonApi.getStore())
            .exec(api.commonApi.getContentPages())
            .exec(api.tablePage.getProducts())
            .exec(api.commonApi.categoryOptions())
            .exec(api.commonApi.getCategory())
            .exec(api.commonApi.productPriceOptions())
            .exec(api.commonApi.categoryOptions())
            .exec(api.commonApi.postProductPrice())
            .exec(api.commonApi.getCategory(50, "tables"))
            .exec(api.commonApi.categoryManufacturersOptions(50))
            .exec(api.commonApi.getCategoryManufacturers(50))
            .exec(thinkTimer())
        }
        .group("Click random table") {
          exec(api.commonApi.actuatorHealthOptions())
            .exec(api.commonApi.getActuatorHealth())
            .exec(api.commonApi.contentBoxesOptions())
            .exec(api.productCart.productReviewOptions())
            .exec(api.productCart.productOptions())
            .exec(api.commonApi.categoryOptions())
            .exec(api.productCart.getProduct())
            .exec(api.commonApi.storeOptions())
            .exec(api.productCart.getProductReview())
            .exec(api.commonApi.contentPagesOptions())
            .exec(api.commonApi.getCategory())
            .exec(api.commonApi.getStore())
            .exec(api.commonApi.getContentPages())
            .exec(api.commonApi.productPriceOptions())
            .exec(api.commonApi.postProductPrice())
            .exec(thinkTimer())
        }
        .group("Add table to cart") {
          exec(api.tableToCart.cartOptions())
            .exec(api.tableToCart.postCart())
            .exec(api.tableToCart.cartIdOptions())
            .exec(api.productCart.getCartId())
            .exec(thinkTimer())
        }
        .randomSwitch(
          ChairBuyersPercent -> group("Open chairs tab") {
            exec(api.commonApi.actuatorHealthOptions())
            exec(api.commonApi.getActuatorHealth())
            exec(api.commonApi.contentBoxesOptions())
            exec(api.chairPage.chairProductOptions())
            exec(api.commonApi.storeOptions())
            exec(api.commonApi.getStore())
            exec(api.commonApi.contentPagesOptions())
            exec(api.commonApi.getContentPages())
            exec(api.commonApi.categoryOptions())
            exec(api.chairPage.getChairProducts())
            exec(api.commonApi.getCategory())
            exec(api.commonApi.productPriceOptions(50))
            exec(api.commonApi.productPriceOptions(51))
            exec(api.commonApi.categoryOptionsId(51))
            exec(api.commonApi.getCategory(51, "chairs"))
            exec(api.commonApi.productPriceOptions(52))
            exec(api.commonApi.postProductPrice(50))
            exec(api.commonApi.postProductPrice(51))
            exec(api.commonApi.postProductPrice(52))
            exec(api.commonApi.categoryManufacturersOptions(51))
            exec(api.commonApi.getCategoryManufacturers(51))
              .exec(thinkTimer())
          }
            .group("Click random chair") {
              exec(api.commonApi.actuatorHealthOptions())
                .exec(api.commonApi.getActuatorHealth())
                .exec(api.productCart.productReviewOptions(51))
                .exec(api.productCart.getProductReview())
                .exec(api.commonApi.contentBoxesOptions())
                .exec(api.commonApi.storeOptions())
                .exec(api.commonApi.getStore())
                .exec(api.commonApi.contentPagesOptions())
                .exec(api.commonApi.getContentPages()
              )
              .exec(api.productCart.productOptions())
                .exec(api.commonApi.categoryOptions())
                .exec(api.commonApi.getCategory())
                .exec(api.productCart.getProduct(51))
                .exec(api.commonApi.productPriceOptions(51))
                .exec(api.commonApi.postProductPrice(51))
                .exec(thinkTimer())
            }
            .group("Add chair to cart") {
              exec(api.productCart.cartIdWithStoreOptions())
                .exec(api.chairToCart.putCart())
                .exec(api.chairToCart.cartWithLangOptions())
                .exec(api.productCart.getCartId())
                .exec(thinkTimer())
            }
            .randomSwitch(
              ChairAndTableBuyersPercent -> exec(groups.CheckoutProductGroups.openCartAndCheckout())
            ),
          TableBuyersPercent -> exec(groups.CheckoutProductGroups.openCartAndCheckout())
        )
    )
}
