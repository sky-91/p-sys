package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.List;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 18/1/13
 */
public interface SpecialPersonBuilder {

  /**
   * 从文件中读取数据并转换为疆藏人员对象
   *
   * @param workbook 文件
   * @return list
   */
  List<SpecialPersonData> buildPersonList(Workbook workbook);
}
