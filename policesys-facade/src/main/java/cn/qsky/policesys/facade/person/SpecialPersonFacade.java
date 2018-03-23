package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author qsky on 17/12/3
 */
public interface SpecialPersonFacade {

  /**
   * 根据身份证获取特殊人员信息
   *
   * @param idCard 身份证
   * @return SpecialPersonData
   */
  SpecialPersonData getSpecialPerson(final String idCard);

  /**
   * 保存特殊人员
   *
   * @param specialPersonData data
   * @return boolean
   */
  Boolean saveSpecialPerson(final SpecialPersonData specialPersonData);

  /**
   * 更新特殊人员
   *
   * @param specialPersonData data
   * @return boolean
   */
  Boolean updateSpecialPerson(final SpecialPersonData specialPersonData);

  /**
   * 删除特殊人员
   *
   * @param idCard idCard
   * @return boolean
   */
  Boolean deleteSpecialPerson(final String idCard);

  /**
   * 分页数据查询
   *
   * @param queryMap queryMap
   * @param pageNum pageNum
   * @param pageSize pageSize
   * @return Page
   */
  PageData<SpecialPersonData> listSpecialPersonForPage(final Map<String, Object> queryMap,
      final Integer pageNum, final Integer pageSize);

  /**
   * 文件导入疆藏人员信息
   *
   * @param workbook 文件
   * @return map
   */
  Map<String, List<String>> uploadSpecialPerson(Workbook workbook);

  /**
   * 导出重点人员EXCEL
   *
   * @param queryMap queryMap
   * @param pageNum pageNum
   * @param pageSize pageSize
   * @return HSSFWorkbook
   */
  HSSFWorkbook exportSpecialPerson(final Map<String, Object> queryMap, final Integer pageNum,
      final Integer pageSize);
}
