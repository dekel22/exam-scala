import UserClasses.{Client, Person}
import Utils.{ExcelHandler, JsonHandler, Request}

object main {

  def main(args: Array[String]): Unit = {
    val table:UsersTable=new UsersTable
    table.addUsers(JsonHandler.getPersons("data/persons.json"))
    table.addUsers(ExcelHandler.readClients("data/client.xls"))
    table.filterIllegal
    table.filterByReQuest(JsonHandler.getRequest("data/request.json"))
    table.print()


  }




}
