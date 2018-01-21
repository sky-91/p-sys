package cn.qsky.policesys.facade.group.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import cn.qsky.policesys.core.group.GroupService;
import cn.qsky.policesys.facade.group.GroupBuilder;
import cn.qsky.policesys.facade.group.GroupFacade;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qsky on 18/1/7
 */
@Component
public class GroupFacadeImpl implements GroupFacade {

  private static final Logger LOG = LoggerFactory.getLogger(GroupFacadeImpl.class);

  @Resource
  private GroupService groupService;

  @Resource
  private GroupBuilder groupBuilder;

  @Override
  public GroupSummaryData getGroupSummary(String groupName) {
    return CglibBeanUtil
        .copyProperties(groupService.getGroupSummary(groupName), GroupSummaryData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveGroupSummary(GroupSummaryData groupSummaryData) {
    if (groupService.saveGroupSummary(CglibBeanUtil.copyProperties(groupSummaryData,
        GroupSummaryModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
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
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.saveGroupRecord(CglibBeanUtil.copyProperties(groupRecordData,
        GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.updateGroupRecord(CglibBeanUtil.copyProperties(groupRecordData,
        GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public PageData<GroupSummaryData> listGroupSummaryForPage(Integer pageNum, Integer pageSize) {
    return PageDataConverter.converter(groupService.listGroupSummaryForPage(pageNum, pageSize),
        GroupSummaryData.class);
  }

  @Override
  public PageData<GroupRecordData> listGroupRecordForPage(
      GroupRecordPageQueryData groupRecordPageQueryData) {
    return PageDataConverter.converter(groupService.listGroupRecordForPage(
        CglibBeanUtil.copyProperties(groupRecordPageQueryData, GroupRecordPageQueryDTO.class)),
        GroupRecordData.class);
  }

  @Override
  public Boolean uploadGroupInfo(Workbook workbook) {
    List<GroupSummaryData> dataList = groupBuilder.buildSummaryList(workbook);
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (GroupSummaryData groupData : dataList) {
        Boolean result;
        if (groupService.countGroupSummary(groupData.getGroupName()) == 1) {
          result = updateGroupSummary(groupData);
        } else {
          result = saveGroupSummary(groupData);
        }
        if (!result) {
          LOG.error("Group : {} is error!", groupData.getGroupName());
        }
      }
    }
    return true;
  }

  @Override
  public Boolean uploadGroupRecord(Workbook workbook) {
    List<GroupRecordData> dataList = groupBuilder.buildRecordList(workbook);
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (GroupRecordData recordData : dataList) {
        Boolean result;
        if (groupService.countGroupSummary(recordData.getGroupName()) == 1) {
          result = saveGroupRecord(recordData);
        } else {
          result = false;
        }
        if (!result) {
          LOG.error("Group record: {} is error!", recordData.getGroupName());
        }
      }
    }
    return true;
  }
}
