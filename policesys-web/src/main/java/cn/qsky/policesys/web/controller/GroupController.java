package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.vo.PageVO;
import cn.qsky.policesys.common.vo.PageVOConverter;
import cn.qsky.policesys.core.dto.GroupRecordPageQueryDTO;
import cn.qsky.policesys.facade.group.GroupFacade;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import cn.qsky.policesys.web.vo.GroupRecordVO;
import cn.qsky.policesys.web.vo.GroupSummaryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qsky on 18/1/7
 */
@Api(description = "活动群体接口")
@Controller
@RequestMapping("group")
public class GroupController {

  private static final Logger LOG = LoggerFactory.getLogger(GroupController.class);

  @Resource
  private GroupFacade groupFacade;

  @ApiOperation(value = "根据群体名称获取群体汇总信息", notes = "根据群体名称获取群体汇总信息")
  @ApiImplicitParam(name = "groupName", value = "群体名称", required = true, dataType = "String", paramType = "path")
  @GetMapping("groupSummary/getByName/{groupName}")
  public GroupSummaryVO getGroupSummary(
      @NotBlank @PathVariable(name = "groupName") final String groupName) {
    return CglibBeanUtil
        .copyProperties(groupFacade.getGroupSummary(groupName), GroupSummaryVO.class);
  }

  @ApiOperation(value = "保存群体汇总信息", notes = "保存接口")
  @ApiParam(name = "groupSummaryVO", value = "groupSummaryVO", required = true)
  @PostMapping("groupSummary/save")
  public Boolean saveGroupSummary(
      @Valid @RequestBody final GroupSummaryVO groupSummaryVO) {
    LOG.debug(groupSummaryVO.toString());
    return groupFacade.saveGroupSummary(CglibBeanUtil.copyProperties(groupSummaryVO,
        GroupSummaryData.class));
  }

  @ApiOperation(value = "修改群体汇总信息", notes = "修改接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PutMapping("groupSummary/update")
  public Boolean updateGroupSummary(
      @Valid @RequestBody final GroupSummaryVO groupSummaryVO) {
    LOG.debug(groupSummaryVO.toString());
    return groupFacade.updateGroupSummary(CglibBeanUtil.copyProperties(groupSummaryVO,
        GroupSummaryData.class));
  }

  @ApiOperation(value = "群体汇总信息列表", notes = "群体汇总信息列表")
  @GetMapping(value = "GroupSummary/listAll")
  public List<GroupSummaryVO> listGroupSummary() {
    return CglibBeanUtil.converterList(groupFacade.listAllGroupSummary(), GroupSummaryVO.class);
  }

  @ApiOperation(value = "根据群体名称获取群体活动记录", notes = "根据群体名称获取群体活动记录")
  @ApiImplicitParam(name = "groupName", value = "群体名称", required = true, dataType = "String", paramType = "path")
  @GetMapping("groupRecord/getByName/{groupName}")
  public GroupRecordVO getGroupRecord(
      @NotBlank @PathVariable(name = "groupName") final String groupName) {
    return CglibBeanUtil
        .copyProperties(groupFacade.getGroupRecord(groupName), GroupRecordVO.class);
  }

  @ApiOperation(value = "保存群体活动记录", notes = "保存接口")
  @ApiParam(name = "groupRecordVO", value = "groupRecordVO", required = true)
  @PostMapping("groupRecord/save")
  public Boolean saveGroupRecord(
      @Valid @RequestBody final GroupRecordVO groupRecordVO) {
    LOG.debug(groupRecordVO.toString());
    return groupFacade.saveGroupRecord(CglibBeanUtil.copyProperties(groupRecordVO,
        GroupRecordData.class));
  }

  @ApiOperation(value = "修改群体活动记录", notes = "修改接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PutMapping("groupRecord/update")
  public Boolean updateGroupRecord(
      @Valid @RequestBody final GroupRecordVO groupRecordVO) {
    LOG.debug(groupRecordVO.toString());
    return groupFacade.updateGroupRecord(CglibBeanUtil.copyProperties(groupRecordVO,
        GroupRecordData.class));
  }

  @ApiOperation(value = "群体活动记录清单列表", notes = "分页显示群体活动记录清单")
  @ApiParam(name = "groupRecordPageQueryDTO", value = "groupRecordPageQueryDTO", required = true)
  @GetMapping(value = "groupRecord/listForPage")
  public PageVO<GroupRecordVO> listGroupRecord(
      @Valid @RequestBody final GroupRecordPageQueryDTO groupRecordPageQueryDTO) {
    return PageVOConverter.converter(groupFacade.listGroupRecordForPage(CglibBeanUtil
            .copyProperties(groupRecordPageQueryDTO, GroupRecordPageQueryData.class)),
        GroupRecordVO.class);
  }
}
