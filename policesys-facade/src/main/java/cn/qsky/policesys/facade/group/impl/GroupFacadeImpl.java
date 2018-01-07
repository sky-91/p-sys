package cn.qsky.policesys.facade.group.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import cn.qsky.policesys.core.group.GroupService;
import cn.qsky.policesys.facade.group.GroupFacade;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author qsky on 18/1/7
 */
@Component
public class GroupFacadeImpl implements GroupFacade {

  @Resource
  private GroupService groupService;

  @Override
  public GroupSummaryData getGroupSummary(String groupName) {
    return CglibBeanUtil
        .copyProperties(groupService.getGroupSummary(groupName), GroupSummaryData.class);
  }

  @Override
  public Boolean saveGroupSummary(GroupSummaryData groupSummaryData) {
    if (groupService.saveGroupSummary(CglibBeanUtil.copyProperties(groupSummaryData,
        GroupSummaryModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public Boolean updateGroupSummary(GroupSummaryData groupSummaryData) {
    if (groupService.updateGroupSummary(CglibBeanUtil.copyProperties(groupSummaryData,
        GroupSummaryModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public GroupRecordData getGroupRecord(String groupName) {
    return CglibBeanUtil
        .copyProperties(groupService.getGroupRecord(groupName), GroupRecordData.class);
  }

  @Override
  public Boolean saveGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.saveGroupRecord(CglibBeanUtil.copyProperties(groupRecordData,
        GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public Boolean updateGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.updateGroupRecord(CglibBeanUtil.copyProperties(groupRecordData,
        GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public List<GroupSummaryData> listAllGroupSummary() {
    return CglibBeanUtil.converterList(groupService.listAllGroupSummary(), GroupSummaryData.class);
  }

  @Override
  public PageData<GroupRecordData> listGroupRecordForPage(
      GroupRecordPageQueryData groupRecordPageQueryData) {
    return PageDataConverter.converter(groupService.listGroupRecordForPage(
        CglibBeanUtil.copyProperties(groupRecordPageQueryData, GroupRecordPageQueryDTO.class)),
        GroupRecordData.class);
  }
}
