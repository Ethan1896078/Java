import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * desc:
 * Created by huangzhe on 2017/7/7.
 */
public class Poi {
    public static void main(String[] args) throws IOException {
        Workbook wb =  new XSSFWorkbook();
        Sheet sheet = (Sheet) wb.createSheet("sheet1");

        for (int i = 0 ; i < 100 ; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0 ; j < 10 ; j++) {
                row.createCell(j).setCellValue(i + " - " + j);
            }
        }

        //创建文件流
        OutputStream stream = new FileOutputStream("/Users/huangzhe/Downloads/6月打擂作品上榜信息.xlsx");
        //写入数据
        wb.write(stream);
        //关闭文件流
        stream.close();
    }
}
