package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.core.dao.model.SpecialPersonModelExample;
import java.util.List;
import java.util.Map;

public interface SpecialPersonMapper extends
    MybatisBaseRepository<SpecialPersonModel, Long, SpecialPersonModelExample> {

  /**
   * 查询信息
   *
   * @param queryMap queryMap
   * @return List
   */
  List<SpecialPersonModel> listSpecialPersonForPage(final Map<String, Object> queryMap);
}