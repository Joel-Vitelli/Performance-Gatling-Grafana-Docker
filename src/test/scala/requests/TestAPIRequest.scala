package requests

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestAPIRequest {

  private val headers = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json"
  )

    val testGetAPI = exec(http("request get")
      .get(urlGetAPI)
      .headers(headers)
      .check(status.is(200))
    )

  val testPostAPI = exec(http("request post")
    .post(urlPostAPI)
    .headers(headers)
    .check(status.is(201))

  )

}
