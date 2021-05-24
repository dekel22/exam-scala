import org.apache.commons.collections4.IteratorUtils
import org.apache.poi.hssf.usermodel.{HSSFSheet, HSSFWorkbook}
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.DataFormatter
import java.io.{File, FileInputStream}
import java.util.stream.{StreamSupport}
import collection.JavaConverters._
import scala.collection.mutable.ListBuffer
object Reader {
  def main(args: Array[String]): List[Client] = {
    var clientList = new ListBuffer[Client]()
    var path="data/client.xls"
    StreamSupport.stream(getSheet(path).spliterator(), false).skip(1).map(row => {
      var c = IteratorUtils.toList(row.cellIterator()).asScala.map(cell => getCellText(cell))
      Client(c(0),c(1), c(2), c(3).toInt, c(4), c(5), c(6),c(7), c(8).toInt, c(9), c(10).toInt)
    }).forEach(client => clientList += client)
    clientList.toList
  }


  def getCellText(cell:Cell): String={
    val formatter = new DataFormatter
    formatter.formatCellValue(cell)
  }


  def getSheet(path:String):HSSFSheet={
    val fis: FileInputStream = new FileInputStream(new File(path))
    val wb: HSSFWorkbook = new HSSFWorkbook(fis)
    wb.getSheetAt(0)
  }

}
