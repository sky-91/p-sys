package cn.qsky.policesys.facade.group;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

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
   * 删除群体汇总信息
   *
   * @param groupName groupName
   * @return boolean
   */
  Boolean deleteGroupSummary(final String groupName);

  /**
   * 根据pk获取群体活动记录
   *
   * @param pk pk
   * @return GroupRecordData
   */
  GroupRecordData getGroupRecord(final String pk);

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
   * 删除群体活动记录
   *
   * @param pk pk
   * @return boolean
   */
  Boolean deleteGroupRecord(final String pk);

  /**
   * 获取所有的群体汇总信息
   *
   * @param queryMap queryMap
   * @param pageNum pageNum
   * @param pageSize pageSize
   * @return PageData
   */
  PageData<GroupSummaryData> listGroupSummaryForPage(final Map<String, Object> queryMap,
      final Integer pageNum, final Integer pageSize);

  /**
   * 分页数据查询
   *
   * @param groupRecordPageQueryData data
   * @return PageData
   */
  PageData<GroupRecordData> listGroupRecordForPage(
      final GroupRecordPageQueryData groupRecordPageQueryData);

  /**
   * 文件导入群体汇总信息
   *
   * @param workbook 文件
   * @return boolean
   */
  Map<String, List<String>> uploadGroupInfo(Workbook workbook);

  /**
   * 文件导入群体活动记录
   *
   * @param workbook 文件
   * @return boolean
   */
  Map<String, List<String>> uploadGroupRecord(Workbook workbook);

  /**
   * 导出群体汇总信息EXCEL
   *
   * @param queryMap queryMap
   * @param pageNum pageNum
   * @param pageSize pageSize
   * @return HSSFWorkbook
   */
  HSSFWorkbook exportGroupSummary(final Map<String, Object> queryMap, final Integer pageNum,
      final Integer pageSize);

  /**
   * 导出群体活动记录EXCEL
   *
   * @param groupRecordPageQueryData data
   * @return HSSFWorkbook
   */
  HSSFWorkbook exportGroupRecord(final GroupRecordPageQueryData groupRecordPageQueryData);
}
