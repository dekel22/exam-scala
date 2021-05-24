import com.fasterxml.jackson.core.`type`.TypeReference

import java.io.{File, FileInputStream}
import java.util.List
import scala.jdk.CollectionConverters._
import com.fasterxml.jackson.databind.ObjectMapper





object main {
  def main(args: Array[String]): Unit = {
    val request:Request=getRequest()
    val persons:Iterable[Person]= getPersons()
   //StreamSupport.stream(getClient.spliterator(),false).collect(Collectors.toList())
  // StreamSupport.stream(getClient.spliterator(),false).map(row=>row.cellIterator())

  }

  def getRequest():Request={
    val obj: ObjectMapper= new ObjectMapper
    obj.readValue(new File("data/request.json"), classOf[Request])
  }

  def filterIllegal(persons: Iterable[Person]):Iterable[Person]=
     persons.filter(p=>{p.email.contains(".com") && p.email.contains("@")})
    .filter(p=>{p.age>0 && p.phone.exists(_.isDigit)})


  def getPersons():Iterable[Person]= {
    val objectMapper: ObjectMapper = new ObjectMapper
    objectMapper.readValue(new File("data/persons.json"), new TypeReference[List[Person]]() {}).asScala
  }



}
