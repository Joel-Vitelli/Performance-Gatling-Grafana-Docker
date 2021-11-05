package requests

import config.Configuration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestAPIRequest {

  private val headers = Map(
    "Accept" -> "application/json",
    "Content-Type" -> "application/json"
  )

  val testPostAPI = exec(http("request post")
    .post(urlPostAPI)
    .headers(headers)
    .body( StringBody(
      """{"header":{"image":{"visible":true},"completeName":{"value":"Nombre y apellido","visible":true},"profession":{"value":"Profesión o especialidad","visible":true}},"profile":{"visible":true,"title":"PERFIL","description":"Escribe un párrafo para hablar de ti mismo."},"personalInfo":{"title":"INFORMACIÓN PERSONAL","dateOfBirth":{"title":"Fecha de nacimiento","value":"","visible":true},"nationality":{"title":"Nacionalidad","value":"","visible":true},"location":{"title":"Ubicación","value":"","visible":true},"maritalStatus":{"title":"Estado civil","value":"","visible":true}},"contact":{"title":"CONTACTO","email":{"value":"Email","visible":true},"phone":{"value":"+54 11 4444 8888","visible":true},"web":{"value":"Sitio web","visible":true},"facebook":{"value":"Facebook","visible":true},"twitter":{"value":"Twitter","visible":true},"instagram":{"value":"Instagram","visible":true},"linkedin":{"value":"LinkedIn","visible":true},"behance":{"value":"Behance","visible":true},"github":{"value":"Github","visible":true}},"experience":{"visible":true,"title":"EXPERIENCIA LABORAL","cards":[{"index":0,"title":"Posición","subtitle":"EMPRESA","time":"10/10/2017 - 03/09/2018","description":"Describe las tareas realizadas."},{"index":1,"title":"Posición","subtitle":"EMPRESA","time":"10/10/2017 - 03/09/2018","description":"Describe las tareas realizadas."}]},"education":{"title":"EDUCACION","visible":true,"cards":[{"title":"Título","subtitle":"INSTITUCIÓN EDUCATIVA","time":"10/10/2017 - 03/09/2018","index":0}]},"aditionalInfo":{"listOne":{"title":"TÍTULO PERSONALIZADO","description":"Texto personalizado","visible":false},"listTwo":{"title":"TÍTULO PERSONALIZADO","description":"Texto personalizado","visible":false}},"skills":{"listCards":{"visible":true,"title":"TÍTULO PERSONALIZADO","cards":[{"value":"Aptitud","index":0},{"value":"Aptitud","index":1},{"value":"Aptitud","index":2},{"value":"Aptitud","index":3}]},"listCards2":{"title":"TÍTULO PERSONALIZADO","visible":true,"cards":[{"title":"Aptitud","value":75,"index":0},{"title":"Aptitud","value":75,"index":1},{"title":"Aptitud","value":75,"index":2},{"title":"Aptitud","value":75,"index":3}]},"bars":{"title":"TÍTULO PERSONALIZADO","visible":false,"cards":[{"title":"Aptitud","value":3,"index":0},{"title":"Aptitud","value":3,"index":1},{"title":"Aptitud","value":3,"index":2},{"title":"Aptitud","value":1,"index":3}]},"checkList":{"title":"TÍTULO PERSONALIZADO","visible":true,"cards":[{"value":"Texto personalizado","index":0}]}}}"""
    )).asJson
    .check(status.is(201))
  )

}
