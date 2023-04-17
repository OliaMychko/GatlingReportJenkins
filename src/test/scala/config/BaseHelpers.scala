package config

import io.gatling.core.Predef._
import io.gatling.core.structure._
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

object BaseHelpers {

  val HomePage = "http://localhost:8080/"

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(HomePage)
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate, br")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8")
    .upgradeInsecureRequestsHeader("1")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/110.0.0.0 Safari/537.36")


  def thinkTimer(min: Int = 2, max: Int = 5): ChainBuilder = {
    pause(min, max)
  }

  def initScenario(scenarioName: String): ScenarioBuilder = {
    scenario(scenarioName)
      .exec(flushHttpCache)
      .exec(flushCookieJar)
  }

}
