package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModelExample;
import java.util.List;
import java.util.Map;

public interface GroupSummaryMapper extends
    MybatisBaseRepository<GroupSummaryModel, Long, GroupSummaryModelExample> {

  /**
   * 查询信息
   *
   * @param queryMap queryMap
   * @return List
   */
  List<GroupSummaryModel> listGroupSummaryForPage(final Map<String, Object> queryMap);
}