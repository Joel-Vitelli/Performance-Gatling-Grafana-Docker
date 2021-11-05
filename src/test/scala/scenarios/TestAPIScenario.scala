package scenarios

import io.gatling.core.Predef._
import requests.TestAPIRequest

object TestAPIScenario {

  val testAPIPost = scenario("TEST API SCENARIO GET" )
    .exec(TestAPIRequest.testPostAPI)

}