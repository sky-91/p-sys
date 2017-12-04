package cn.qsky.policesys.core.person;

import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import com.github.pagehelper.Page;
import java.util.Map;

/**
 * @author qsky on 17/12/1
 */
public interface SpecialPersonService {

  /**
   * 根据身份证获取特殊人员信息
   *
   * @param idCard 身份证
   * @return SpecialPersonModel
   */
  SpecialPersonModel getSpecialPerson(final String idCard);

  /**
   * 根据身份证校验特殊人员
   *
   * @param idCard 身份证
   * @return int
   */
  int countSpecialPerson(final String idCard);

  /**
   * 保存特殊人员
   *
   * @param specialPersonModel model
   * @return int
   */
  int saveSpecialPerson(final SpecialPersonModel specialPersonModel);

  /**
   * 更新特殊人员
   *
   * @param specialPersonModel model
   * @return int
   */
  int updateSpecialPerson(final SpecialPersonModel specialPersonModel);

  /**
   * 分页数据查询
   *
   * @param queryMap queryMap
   * @param pageNum pageNum
   * @param pageSize pageSize
   * @return Page
   */
  Page<SpecialPersonModel> listSpecialPersonForPage(final Map<String, Object> queryMap,
      final Integer pageNum, final Integer pageSize);
}
