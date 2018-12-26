package default

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulationBySafari extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.disableAutoReferer
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("zh-cn")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.1 Safari/605.1.15")

	val headers_0 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers")

	val headers_1 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_5 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers?f=mac",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_7 = Map(
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers?p=1&f=mac",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_8 = Map(
		"Origin" -> "http://computer-database.gatling.io",
		"Proxy-Connection" -> "keep-alive",
		"Referer" -> "http://computer-database.gatling.io/computers/89",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("RecordedSimulationBySafari")
		.exec(http("request_0")
			.get("/assets/stylesheets/bootstrap.min.css")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/")
			.headers(headers_1),
            http("request_2")
			.get("/assets/stylesheets/main.css")
			.headers(headers_0),
            http("request_3")
			.get("/assets/stylesheets/bootstrap.min.css")
			.headers(headers_0),
            http("request_4")
			.get("/assets/stylesheets/main.css")
			.headers(headers_0)))
		.pause(6)
		.exec(http("request_5")
			.get("/computers?f=mac")
			.headers(headers_5))
		.pause(3)
		.exec(http("request_6")
			.get("/computers?p=1&f=mac")
			.headers(headers_6))
		.pause(4)
		.exec(http("request_7")
			.get("/computers/89")
			.headers(headers_7))
		.pause(9)
		.exec(http("request_8")
			.post("/computers/89")
			.headers(headers_8)
			.formParam("name", "MacBook")
			.formParam("introduced", "2006-05-16")
			.formParam("discontinued", "2019-12-12")
			.formParam("company", "1"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}