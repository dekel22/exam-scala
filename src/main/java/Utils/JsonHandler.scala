package Utils

import UserClasses.Person
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

import java.io.File
import java.util.List
import scala.jdk.CollectionConverters.CollectionHasAsScala

object JsonHandler {
  def getRequest(path:String):Request={
    val obj: ObjectMapper= new ObjectMapper
    obj.readValue(new File(path), classOf[Request])
  }



  def getPersons(path:String):scala.List[Person]= {
    val objectMapper: ObjectMapper = new ObjectMapper
    objectMapper.readValue(new File(path), new TypeReference[List[Person]]() {}).asScala.toList
  }

}
