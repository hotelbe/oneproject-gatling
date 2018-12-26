package default

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.disableAutoReferer
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:63.0) Gecko/20100101 Firefox/63.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Referer" -> "http://computer-database.gatling.io/computers",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_4 = Map(
		"Referer" -> "http://computer-database.gatling.io/computers?f=mac",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Referer" -> "http://computer-database.gatling.io/computers/216",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_10 = Map(
		"Referer" -> "http://computer-database.gatling.io/computers?p=1",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/favicon.ico")
			.check(status.is(404))))
		.pause(6)
		.exec(http("request_2")
			.get("/computers?f=mac")
			.headers(headers_2)
			.resources(http("request_3")
			.get("/favicon.ico")
			.check(status.is(404))))
		.pause(4)
		.exec(http("request_4")
			.get("/computers/216")
			.headers(headers_4)
			.resources(http("request_5")
			.get("/favicon.ico")
			.check(status.is(404))))
		.pause(19)
		.exec(http("request_6")
			.post("/computers/216")
			.headers(headers_6)
			.formParam("name", "EMac")
			.formParam("introduced", "2018-12-05")
			.formParam("discontinued", "2019-12-09")
			.formParam("company", "2")
			.resources(http("request_7")
			.get("/favicon.ico")
			.check(status.is(404))))
		.pause(3)
		.exec(http("request_8")
			.get("/computers?p=1")
			.headers(headers_2)
			.resources(http("request_9")
			.get("/favicon.ico")
			.check(status.is(404))))
		.pause(2)
		.exec(http("request_10")
			.get("/computers?p=2")
			.headers(headers_10)
			.resources(http("request_11")
			.get("/favicon.ico")
			.check(status.is(404))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}