package pl.klangner.tsl

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import org.slf4j.LoggerFactory

import scala.concurrent.Await
import scala.concurrent.duration.Duration


object Main {

  private val Log = LoggerFactory.getLogger(Main.getClass.getName)

  implicit val system: ActorSystem = ActorSystem("time-series-lab")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  case class Params(dataPath: String)

  /** Routing */
  def route(): Route = {

    path("api" / "ts" / Remaining) { timeSeriesId =>
      post {
        entity(as[String]){ data => DataHandler.raw(timeSeriesId) }
      }
    } ~ pathPrefix("app") {
      getFromDirectory("static")
    }

  }

  def main(args: Array[String]) {
    val params = parseArg(args)

    Log.info("Server started. Open http://localhost:8080/app/index.html")
    Await.result(Http().bindAndHandle(route(), "0.0.0.0", 8080), Duration.Inf)
  }

  def stringArg(args: Array[String], key: String, default: String): String = {
    val name = "--" + key + "="
    args.find(_.contains(name)).map(_.substring(name.length)).getOrElse(default).trim
  }

  def parseArg(args: Array[String]): Params = {
    val dataPath = stringArg(args, "data-path", "data")
    Params(dataPath)
  }
}