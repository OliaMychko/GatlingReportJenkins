package simulations

import config.BaseHelpers._
import io.gatling.core.Predef._
import scenarios.CheckoutProductScenario.scnChoseAndCheckoutProduct

class PerfTestSimulation extends Simulation {

  /**
   * Command to run tests: mvn clean gatling:test
   */
  setUp(
    scnChoseAndCheckoutProduct.inject(atOnceUsers(10))
  ).protocols(httpProtocol)

}