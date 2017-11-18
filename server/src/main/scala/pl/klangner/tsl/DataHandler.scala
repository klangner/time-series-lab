package pl.klangner.tsl

import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute

/**
  * Handler for data access
  */
object DataHandler {

  /** Load Raw Time Series */
  def raw(seriesId: String): StandardRoute = {
    complete("")
  }

  /** Load Calculated Time Series */
  def calculated(str: String): StandardRoute = {
    complete("")
  }
}
