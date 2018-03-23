package cn.qsky.policesys.facade.group.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.common.util.StringUtil;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import cn.qsky.policesys.core.group.GroupService;
import cn.qsky.policesys.facade.group.GroupBuilder;
import cn.qsky.policesys.facade.group.GroupFacade;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.dozer.DozerBeanMapper;
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
  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  @Resource
  private GroupService groupService;

  @Resource
  private GroupBuilder groupBuilder;

  @Override
  public GroupSummaryData getGroupSummary(String groupName) {
    GroupSummaryData groupSummaryData = CglibBeanUtil
        .copyProperties(groupService.getGroupSummary(groupName), GroupSummaryData.class);
    groupSummaryData.setRecords(
        CglibBeanUtil
            .converterList(groupService.getGroupRecordByName(groupName), GroupRecordData.class));
    return groupSummaryData;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveGroupSummary(GroupSummaryData groupSummaryData) {
    if (groupService.saveGroupSummary(mapper.map(groupSummaryData, GroupSummaryModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateGroupSummary(GroupSummaryData groupSummaryData) {
    if (groupService.updateGroupSummary(mapper.map(groupSummaryData, GroupSummaryModel.class))
        == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean deleteGroupSummary(String groupName) {
    if (groupService.deleteGroupSummary(groupName) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public GroupRecordData getGroupRecord(String pk) {
    return CglibBeanUtil
        .copyProperties(groupService.getGroupRecordByPk(pk), GroupRecordData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.saveGroupRecord(mapper.map(groupRecordData, GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateGroupRecord(GroupRecordData groupRecordData) {
    if (groupService.updateGroupRecord(mapper.map(groupRecordData, GroupRecordModel.class)) == 1) {
      return true;
    }
    return false;
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean deleteGroupRecord(String pk) {
    if (groupService.deleteGroupRecord(pk) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public PageData<GroupSummaryData> listGroupSummaryForPage(Map<String, Object> queryMap,
      Integer pageNum, Integer pageSize) {
    return PageDataConverter
        .converter(groupService.listGroupSummaryForPage(queryMap, pageNum, pageSize),
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
  public Map<String, List<String>> uploadGroupInfo(Workbook workbook) {
    List<GroupSummaryData> dataList = groupBuilder.buildSummaryList(workbook);
    List<String> saveList = new ArrayList<>();
    List<String> updateList = new ArrayList<>();
    List<String> failedList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (GroupSummaryData groupData : dataList) {
        try {
          int count = groupService.countGroupSummary(groupData.getGroupName());
          if (count == 1 && updateGroupSummary(groupData)) {
            updateList.add(groupData.getGroupName());
          } else if (count == 0 && saveGroupSummary(groupData)) {
            saveList.add(groupData.getGroupName());
          } else {
            failedList.add(groupData.getGroupName());
          }
        } catch (Exception e) {
          LOG.error("Group: {} is error!", groupData.getGroupName());
          e.printStackTrace();
          failedList.add(groupData.getGroupName());
        }
      }
    }
    return StringUtil.generateMap(saveList, updateList, failedList);
  }

  @Override
  public Map<String, List<String>> uploadGroupRecord(Workbook workbook) {
    List<GroupRecordData> dataList = groupBuilder.buildRecordList(workbook);
    List<String> saveList = new ArrayList<>();
    List<String> updateList = new ArrayList<>();
    List<String> failedList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (GroupRecordData recordData : dataList) {
        try {
          int count = groupService.countGroupSummary(recordData.getGroupName());
          if (count == 1 && saveGroupRecord(recordData)) {
            saveList.add(recordData.getRecordDate() == null ? ""
                : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getGroupName());
          } else {
            failedList.add(recordData.getRecordDate() == null ? ""
                : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getGroupName());
          }
        } catch (Exception e) {
          LOG.error("Group record: {} is error!", recordData.getGroupName());
          e.printStackTrace();
          failedList.add(recordData.getRecordDate() == null ? ""
              : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getGroupName());
        }
      }
    }
    return StringUtil.generateMap(saveList, updateList, failedList);
  }

  @Override
  public HSSFWorkbook exportGroupSummary(Map<String, Object> queryMap, Integer pageNum,
      Integer pageSize) {
    return groupBuilder
        .fillSummaryBook(
            groupService.listGroupSummaryForPage(queryMap, pageNum, pageSize).getResult());
  }

  @Override
  public HSSFWorkbook exportGroupRecord(GroupRecordPageQueryData groupRecordPageQueryData) {
    return groupBuilder.fillRecordBook(groupService.listGroupRecordForPage(
        CglibBeanUtil.copyProperties(groupRecordPageQueryData, GroupRecordPageQueryDTO.class))
        .getResult());
  }
}
