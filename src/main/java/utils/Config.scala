package utils

import scala.io.Source

object Config {
  var properties= Map[String, String]()
  Source.fromFile("config").getLines.foreach(line=>properties=properties +(line.split("=")(0)->
    line.split("=")(1)))

  def get(name:String):String={
    properties.get(name).get
  }

}
