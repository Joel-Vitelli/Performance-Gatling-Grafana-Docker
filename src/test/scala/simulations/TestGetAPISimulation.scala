package simulations;

import config.Configuration._
import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scenarios.TestAPIScenario


class TestGetAPISimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val testGet = TestAPIScenario.testAPIGet
    .inject(
      atOnceUsers(10)
    ).protocols(httpConf)

  setUp(testGet)
}