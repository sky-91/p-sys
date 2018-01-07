package cn.qsky.policesys.facade.group;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.List;

/**
 * @author qsky on 18/1/7
 */
public interface GroupFacade {

  /**
   * 根据群体名称获取群体汇总信息
   *
   * @param groupName 群体名称
   * @return GroupSummaryData
   */
  GroupSummaryData getGroupSummary(final String groupName);

  /**
   * 保存群体汇总信息
   *
   * @param groupSummaryData data
   * @return boolean
   */
  Boolean saveGroupSummary(final GroupSummaryData groupSummaryData);

  /**
   * 更新群体汇总信息
   *
   * @param groupSummaryData data
   * @return boolean
   */
  Boolean updateGroupSummary(final GroupSummaryData groupSummaryData);

  /**
   * 根据群体名称获取群体活动记录
   *
   * @param groupName 群体名称
   * @return GroupRecordData
   */
  GroupRecordData getGroupRecord(final String groupName);

  /**
   * 保存群体活动记录
   *
   * @param groupRecordData data
   * @return boolean
   */
  Boolean saveGroupRecord(final GroupRecordData groupRecordData);

  /**
   * 更新群体活动记录
   *
   * @param groupRecordData data
   * @return boolean
   */
  Boolean updateGroupRecord(final GroupRecordData groupRecordData);

  /**
   * 获取所有的群体汇总信息
   *
   * @return list
   */
  List<GroupSummaryData> listAllGroupSummary();

  /**
   * 分页数据查询
   *
   * @param groupRecordPageQueryData data
   * @return PageData
   */
  PageData<GroupRecordData> listGroupRecordForPage(
      final GroupRecordPageQueryData groupRecordPageQueryData);
}
