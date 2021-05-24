import org.apache.commons.collections4.IteratorUtils
import org.apache.poi.hssf.usermodel.HSSFWorkbook

import java.io.{File, FileInputStream}
import java.util.stream.{Collectors, StreamSupport}

object Reader {
  def main(args: Array[String]): Unit = {
    val fis: FileInputStream = new FileInputStream(new File("data/client.xls"))
    val wb: HSSFWorkbook = new HSSFWorkbook(fis)
    val a=wb.getSheetAt(0)
      StreamSupport.stream(a.spliterator(),false).map(row=>IteratorUtils.toList(row.cellIterator())).forEach(r=>println(r))


  }

}
