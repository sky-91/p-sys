package cn.qsky.policesys.core.group;

import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import com.github.pagehelper.Page;
import java.util.List;

/**
 * @author qsky on 18/1/7
 */
public interface GroupService {

  /**
   * 根据群体名称获取群体汇总信息
   *
   * @param groupName 群体名称
   * @return GroupSummaryModel
   */
  GroupSummaryModel getGroupSummary(final String groupName);

  /**
   * 根据群体名称校验群体汇总信息
   *
   * @param groupName 群体名称
   * @return int
   */
  int countGroupSummary(final String groupName);

  /**
   * 保存群体汇总信息
   *
   * @param groupSummaryModel model
   * @return int
   */
  int saveGroupSummary(final GroupSummaryModel groupSummaryModel);

  /**
   * 更新群体汇总信息
   *
   * @param groupSummaryModel model
   * @return int
   */
  int updateGroupSummary(final GroupSummaryModel groupSummaryModel);

  /**
   * 根据群体名称获取群体活动记录
   *
   * @param groupName 群体名称
   * @return GroupSummaryModel
   */
  GroupRecordModel getGroupRecord(final String groupName);

  /**
   * 保存群体活动记录
   *
   * @param groupRecordModel model
   * @return int
   */
  int saveGroupRecord(final GroupRecordModel groupRecordModel);

  /**
   * 更新群体活动记录
   *
   * @param groupRecordModel model
   * @return int
   */
  int updateGroupRecord(final GroupRecordModel groupRecordModel);

  /**
   * 获取所有的群体汇总信息
   *
   * @return list
   */
  List<GroupSummaryModel> listAllGroupSummary();

  /**
   * 分页数据查询
   *
   * @param groupRecordPageQueryDTO dto
   * @return Page
   */
  Page<GroupRecordModel> listGroupRecordForPage(
      final GroupRecordPageQueryDTO groupRecordPageQueryDTO);
}
