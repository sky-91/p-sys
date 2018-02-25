package cn.qsky.policesys.common.util;

import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @author qsky on 2018/2/22
 */
public class ExportExcelUtil {

  public static void generateExcelResponse(String fileName, HSSFWorkbook book,
      HttpServletResponse response) {
    try {
      OutputStream output = response.getOutputStream();
      response.reset();
      //设置响应的编码
      response.setContentType("application/x-download");
      response.setCharacterEncoding("utf-8");
      //设置浏览器响应头对应的Content-disposition
      response.setHeader("Content-disposition",
          "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xls");
      //wb输出
      book.write(output);
      output.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
