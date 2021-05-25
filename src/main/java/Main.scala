import flow.UsersFlowManager
import utils.Config

object Main {
  def main(args: Array[String]): Unit = {
    UsersFlowManager.getUsersAndFilter()
  }

}
