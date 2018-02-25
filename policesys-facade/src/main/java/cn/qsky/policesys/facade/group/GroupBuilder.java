package cn.qsky.policesys.facade.group;

import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 2018/1/20
 */
public interface GroupBuilder {

  /**
   * 从文件中读取数据并转换为群体汇总信息对象
   *
   * @param workbook 文件
   * @return list
   */
  List<GroupSummaryData> buildSummaryList(Workbook workbook);

  /**
   * 从文件中读取数据并转换为群体活动记录对象
   *
   * @param workbook 文件
   * @return list
   */
  List<GroupRecordData> buildRecordList(Workbook workbook);

  /**
   * 填充重点人员excel
   *
   * @param modelList modelList
   * @return HSSFWorkbook HSSFWorkbook
   */
  HSSFWorkbook fillSummaryBook(List<GroupSummaryModel> modelList);

  /**
   * 填充重点人员excel
   *
   * @param modelList modelList
   * @return HSSFWorkbook HSSFWorkbook
   */
  HSSFWorkbook fillRecordBook(List<GroupRecordModel> modelList);
}
