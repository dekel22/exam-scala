package flow

import models.{Client, User, UsersTableManage}
import utils.{Config, ExcelHandler, JsonHandler}
import models.Adaptors._

import java.util
import scala.tools.asm.tree.analysis.Value

object UsersFlowManager {
  def getUsersAndFilter(): Unit = {
    val table: UsersTableManage = new UsersTableManage

   table.addUsers(JsonHandler.getPersons(Config.get("persons")))
   table.addUsers(ExcelHandler.readClients(Config.get("clients")))
   table.filterIllegal
   table.filterByReQuest(JsonHandler.getRequest(Config.get("request")))
   table.print()

  }





}
