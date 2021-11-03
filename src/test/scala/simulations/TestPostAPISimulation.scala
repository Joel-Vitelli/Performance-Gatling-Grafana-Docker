package simulations

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios.TestAPIScenario


class TestPostAPISimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val testPost = TestAPIScenario.testAPIGet
    .inject(
      atOnceUsers(1)
    ).protocols(httpConf)

  setUp(testPost)
}