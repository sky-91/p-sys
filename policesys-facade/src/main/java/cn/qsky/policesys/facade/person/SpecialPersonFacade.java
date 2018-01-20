package cn.qsky.policesys.facade.person;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

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
   * @return boolean
   */
  Boolean uploadSpecialPerson(Workbook workbook);
}
