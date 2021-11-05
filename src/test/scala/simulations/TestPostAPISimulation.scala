package simulations

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scenarios.TestAPIScenario

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps


class TestPostAPISimulation extends Simulation {

  val httpConf = http.baseUrl(baseUrl)

  private val testPost = TestAPIScenario.testAPIPost
    .inject(
      rampUsersPerSec(1) to 35 during (20 seconds)
    ).protocols(httpConf)

  private val peakLoadTest = TestAPIScenario.testAPIPost
    .inject(
      rampUsersPerSec(1) to 35 during (20 seconds), //aumento durante 1 minuto la cant de request hasta llegar a 2100
      constantUsersPerSec(35) during (20 seconds), //ya en 2100, voy ejecutando 35 requests por segundo
      rampUsersPerSec(35) to (1) during(20 seconds) //baja la curva a 1 user
    ).protocols(httpConf)

  private val normalExpectedUtilisation = TestAPIScenario.testAPIPost
    .inject(
      constantUsersPerSec(8) during (180 seconds) //ejecuta 20 request por segundos durante 60 segundos
    ).protocols(httpConf)

  private val spikeTest = TestAPIScenario.testAPIPost
    .inject(
      constantUsersPerSec(20) during (10 seconds),//vengo haciendo 20request/seg durante 10 segs
      atOnceUsers(50), //hasta que a los 10 segs meto 50 request de una
      constantUsersPerSec(20) during (50 seconds) //sigo metiendo durante 50 segundos restante, como venia antes
    ).protocols(httpConf)

  private val parallelExecution = TestAPIScenario.testAPIPost
    .inject(
      nothingFor(20 seconds), //espero 20 segundos mientras de fondo sigue correidno el request de 20 por seg durante 5 minutos
      constantUsersPerSec(1) during (60 seconds), //ejecuta 20 request por segundos durante 30 segundos
      nothingFor(40 seconds), // espero 40 segundos
      constantUsersPerSec(1) during (30 seconds) //ejecuto 20 request por seg durante 30 segundos
    ).protocols(httpConf)

  setUp(normalExpectedUtilisation)
}