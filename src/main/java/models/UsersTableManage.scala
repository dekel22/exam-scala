package models


import models.Extensions.StringHelper
import utils.Request

import scala.collection.convert.ImplicitConversions.`collection AsScalaIterable`
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters._

class UsersTableManage {

  var userList:List[User]= List()

  def addUsers(newUsers: List[User]):Unit={
    userList=userList ++ newUsers
  }


  def print():Unit={
    userList.foreach(user=>println(user))
  }

  def filterIllegal(): Unit = {
    val filtered = new ListBuffer[User]()
    userList.filter(p => {
      p.email.isValidEmail
    })
      .filter(p => {
        p.age > 0 && p.phone.isValidPhoneNumber
      }).foreach(user=>filtered+=user)
    userList= filtered.asJava.toList
  }

  def filterByReQuest(request:Request):Unit= {
    val filtered = new ListBuffer[User]()
    request match {
      case Request(_, _, _, _, status, _) if status == "single" | status == "married" => {
         userList.filter(user => user.getClass.getSimpleName == "Client").
        filter(user=>user.asInstanceOf[Client].maritalStatus.toLowerCase()==status).foreach(client => filtered += client)
        println(filtered.size)
      }
      case Request(min, max, _, _, _, _) if min.isValidInt & max.isValidInt =>
        userList.filter(user => user.age > min & user.age < max).foreach(user => filtered += user)

      case Request(_, _, givenGender, _, _, _) if givenGender == "male" | givenGender == "woman" =>
        userList.filter(user => user.gender == givenGender).foreach(user => filtered += user)

      case Request(_, _, _, pre, _, _) if pre.nonEmpty =>
        userList.filter(user => user.firstName.startsWith(pre)).foreach(user => filtered += user)


      case Request(_, _, _, _, _, childrenGiven) if childrenGiven.isValidInt =>
        userList.filter(user=>user.getClass.getSimpleName=="Client").
          filter(user=>user.asInstanceOf[Client].numberOfChildren>=childrenGiven).foreach(client => filtered += client)
    }
    userList = filtered.asJava.toList
  }
}
