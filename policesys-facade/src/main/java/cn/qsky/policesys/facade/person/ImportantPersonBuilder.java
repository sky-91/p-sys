package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 2018/1/20
 */
public interface ImportantPersonBuilder {

  /**
   * 从文件中读取数据并转换为重点人员底库表对象
   *
   * @param workbook 文件
   * @return list
   */
  List<ImportantPersonInfoData> buildPersonInfoList(Workbook workbook);

  /**
   * 从文件中读取数据并转换为重点人员轨迹积分对象
   *
   * @param workbook 文件
   * @return list
   */
  List<ImportantPersonRecordData> buildPersonRecordList(Workbook workbook);
}
