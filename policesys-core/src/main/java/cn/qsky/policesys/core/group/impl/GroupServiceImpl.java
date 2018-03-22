package cn.qsky.policesys.core.group.impl;

import cn.qsky.policesys.common.exception.SourceNotFoundException;
import cn.qsky.policesys.core.dao.mapper.GroupRecordMapper;
import cn.qsky.policesys.core.dao.mapper.GroupSummaryMapper;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupRecordModelExample;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModelExample;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import cn.qsky.policesys.core.group.GroupService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * @author qsky on 18/1/7
 */
@Service
public class GroupServiceImpl implements GroupService {

  @Resource
  private GroupSummaryMapper groupSummaryMapper;

  @Resource
  private GroupRecordMapper groupRecordMapper;

  @Override
  public GroupSummaryModel getGroupSummary(String groupName) {
    GroupSummaryModelExample example = new GroupSummaryModelExample();
    example.or().andGroupNameEqualTo(groupName);
    List<GroupSummaryModel> list = groupSummaryMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(list)) {
      return list.get(0);
    } else {
      throw new SourceNotFoundException();
    }
  }

  @Override
  public int countGroupSummary(String groupName) {
    GroupSummaryModelExample example = new GroupSummaryModelExample();
    example.or().andGroupNameEqualTo(groupName);
    List<GroupSummaryModel> resultList = groupSummaryMapper.selectByExample(example);
    if (CollectionUtils.isEmpty(resultList)) {
      return 0;
    }
    return resultList.size();
  }

  @Override
  public int saveGroupSummary(GroupSummaryModel groupSummaryModel) {
    return groupSummaryMapper.insertSelective(groupSummaryModel);
  }

  @Override
  public int updateGroupSummary(GroupSummaryModel groupSummaryModel) {
    GroupSummaryModelExample example = new GroupSummaryModelExample();
    example.or().andGroupNameEqualTo(groupSummaryModel.getGroupName()).andDeleteFlagEqualTo(false);
    return groupSummaryMapper.updateByExampleSelective(groupSummaryModel, example);
  }

  @Override
  public int deleteGroupSummary(String groupName) {
    GroupRecordModelExample recordExample = new GroupRecordModelExample();
    recordExample.or().andGroupNameEqualTo(groupName);
    groupRecordMapper.deleteByExample(recordExample);
    GroupSummaryModelExample example = new GroupSummaryModelExample();
    example.or().andGroupNameEqualTo(groupName);
    return groupSummaryMapper.deleteByExample(example);
  }

  @Override
  public List<GroupRecordModel> getGroupRecordByName(String groupName) {
    GroupRecordModelExample example = new GroupRecordModelExample();
    example.createCriteria().andGroupNameEqualTo(groupName);
    example.setOrderByClause("record_date desc");
    return groupRecordMapper.selectByExample(example);
  }

  @Override
  public GroupRecordModel getGroupRecordByPk(String pk) {
    GroupRecordModel model = groupRecordMapper.selectByPrimaryKey(Long.valueOf(pk));
    if (model == null) {
      throw new SourceNotFoundException();
    }
    return model;
  }

  @Override
  public int saveGroupRecord(GroupRecordModel groupRecordModel) {
    return groupRecordMapper.insertSelective(groupRecordModel);
  }

  @Override
  public int updateGroupRecord(GroupRecordModel groupRecordModel) {
    return groupRecordMapper.updateByPrimaryKeySelective(groupRecordModel);
  }

  @Override
  public int deleteGroupRecord(String pk) {
    return groupRecordMapper.deleteByPrimaryKey(Long.valueOf(pk));
  }

  @Override
  public Page<GroupSummaryModel> listGroupSummaryForPage(Map<String, Object> queryMap,
      Integer pageNum, Integer pageSize) {
    Page<GroupSummaryModel> page = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> groupSummaryMapper.listGroupSummaryForPage(queryMap));
    return page;
  }

  @Override
  public Page<GroupRecordModel> listGroupRecordForPage(
      GroupRecordPageQueryDTO groupRecordPageQueryDTO) {
    Page<GroupRecordModel> page = PageHelper
        .startPage(groupRecordPageQueryDTO.getPageNumber(),
            groupRecordPageQueryDTO.getPageSize()).doSelectPage(
            () -> groupRecordMapper.listGroupRecordForPage(groupRecordPageQueryDTO));
    return page;
  }
}
