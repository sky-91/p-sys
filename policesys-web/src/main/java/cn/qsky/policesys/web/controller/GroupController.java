package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.common.util.ExportExcelUtil;
import cn.qsky.policesys.common.vo.PageVO;
import cn.qsky.policesys.common.vo.PageVOConverter;
import cn.qsky.policesys.facade.group.GroupFacade;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupRecordPageQueryData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import cn.qsky.policesys.web.vo.GroupRecordVO;
import cn.qsky.policesys.web.vo.GroupSummaryVO;
import cn.qsky.policesys.web.vo.query.GroupRecordPageQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.dozer.DozerBeanMapper;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qsky on 18/1/7
 */
@Api(description = "活动群体接口")
@RestController
@RequestMapping("group")
public class GroupController {

  private static final Logger LOG = LoggerFactory.getLogger(GroupController.class);
  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  @Resource
  private GroupFacade groupFacade;

  @ApiOperation(value = "根据群体名称获取群体汇总信息", notes = "根据群体名称获取群体汇总信息")
  @ApiImplicitParam(name = "groupName", value = "群体名称", required = true, dataType = "String", paramType = "path")
  @GetMapping("groupSummary/getByName/{groupName}")
  public GroupSummaryVO getGroupSummary(
      @NotBlank @PathVariable(name = "groupName") final String groupName) {
    return mapper.map(groupFacade.getGroupSummary(groupName), GroupSummaryVO.class);
  }

  @ApiOperation(value = "保存群体汇总信息", notes = "保存接口")
  @ApiParam(name = "groupSummaryVO", value = "groupSummaryVO", required = true)
  @PostMapping("groupSummary/save")
  public Boolean saveGroupSummary(
      @Valid @RequestBody final GroupSummaryVO groupSummaryVO) {
    LOG.debug("saveGroupSummary : {}", groupSummaryVO.toString());
    return groupFacade.saveGroupSummary(CglibBeanUtil.copyProperties(groupSummaryVO,
        GroupSummaryData.class));
  }

  @ApiOperation(value = "修改群体汇总信息", notes = "修改接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PutMapping("groupSummary/update")
  public Boolean updateGroupSummary(
      @Valid @RequestBody final GroupSummaryVO groupSummaryVO) {
    LOG.debug("updateGroupSummary : {}", groupSummaryVO.toString());
    return groupFacade.updateGroupSummary(CglibBeanUtil.copyProperties(groupSummaryVO,
        GroupSummaryData.class));
  }

  @ApiOperation(value = "删除群体汇总信息", notes = "删除接口")
  @ApiImplicitParam(name = "name", value = "群体名称", required = true, dataType = "String", paramType = "path")
  @DeleteMapping("groupSummary/deleteByName/{name}")
  public Boolean deleteGroupSummary(@NotBlank @PathVariable(name = "name") final String name) {
    LOG.debug("deleteGroupSummary : {}", name);
    return groupFacade.deleteGroupSummary(name);
  }

  @ApiOperation(value = "群体汇总信息列表", notes = "群体汇总信息列表")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupName", value = "群体名称", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "groupType", value = "群体类别", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "pageNumber", value = "当前页码", paramType = "query", dataType = "Integer", required = true),
      @ApiImplicitParam(name = "pageSize", value = "每页显示多少条", paramType = "query", dataType = "Integer", required = true)
  })
  @GetMapping(value = "groupSummary/listForPage")
  public PageVO<GroupSummaryVO> listGroupSummary(
      @RequestParam(name = "groupName", required = false) final String groupName,
      @RequestParam(name = "groupType", required = false) final String groupType,
      @RequestParam(name = "pageNumber") final Integer pageNumber,
      @RequestParam(name = "pageSize") final Integer pageSize) {
    Map<String, Object> queryMap = new HashMap<>(16);
    queryMap.put("groupName", groupName);
    queryMap.put("groupType", groupType);
    return PageVOConverter
        .converter(groupFacade.listGroupSummaryForPage(queryMap, pageNumber, pageSize),
            GroupSummaryVO.class);
  }

  @ApiOperation(value = "获取群体活动记录", notes = "根据pk获取群体活动记录")
  @ApiImplicitParam(name = "pk", value = "pk", required = true, dataType = "String", paramType = "path")
  @GetMapping("groupRecord/getByPk/{pk}")
  public GroupRecordVO getGroupRecord(
      @NotBlank @PathVariable(name = "pk") final String pk) {
    return CglibBeanUtil
        .copyProperties(groupFacade.getGroupRecord(pk), GroupRecordVO.class);
  }

  @ApiOperation(value = "保存群体活动记录", notes = "保存接口")
  @ApiParam(name = "groupRecordVO", value = "groupRecordVO", required = true)
  @PostMapping("groupRecord/save")
  public Boolean saveGroupRecord(
      @Valid @RequestBody final GroupRecordVO groupRecordVO) {
    LOG.debug("saveGroupRecord : {}", groupRecordVO.toString());
    return groupFacade.saveGroupRecord(CglibBeanUtil.copyProperties(groupRecordVO,
        GroupRecordData.class));
  }

  @ApiOperation(value = "修改群体活动记录", notes = "修改接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PutMapping("groupRecord/update")
  public Boolean updateGroupRecord(
      @Valid @RequestBody final GroupRecordVO groupRecordVO) {
    LOG.debug("updateGroupRecord : {}", groupRecordVO.toString());
    return groupFacade.updateGroupRecord(CglibBeanUtil.copyProperties(groupRecordVO,
        GroupRecordData.class));
  }

  @ApiOperation(value = "删除群体活动记录", notes = "删除接口")
  @ApiImplicitParam(name = "pk", value = "PK", required = true, dataType = "String", paramType = "path")
  @DeleteMapping("groupRecord/deleteByPk/{pk}")
  public Boolean deleteGroupRecord(@NotBlank @PathVariable(name = "pk") final String pk) {
    LOG.debug("deleteGroupRecord : {}", pk);
    return groupFacade.deleteGroupRecord(pk);
  }

  @ApiOperation(value = "群体活动记录清单列表", notes = "分页显示群体活动记录清单")
  @ApiParam(name = "groupRecordPageQueryDTO", value = "groupRecordPageQueryDTO", required = true)
  @GetMapping(value = "groupRecord/listForPage")
  public PageVO<GroupRecordVO> listGroupRecord(
      @Valid final GroupRecordPageQueryVO groupRecordPageQueryVO) {
    return PageVOConverter.converter(groupFacade.listGroupRecordForPage(CglibBeanUtil
            .copyProperties(groupRecordPageQueryVO, GroupRecordPageQueryData.class)),
        GroupRecordVO.class);
  }

  @ApiOperation(value = "文件导入群体汇总信息", notes = "导入文件")
  @PostMapping(value = "groupSummary/upload")
  public @ResponseBody
  Map<String, List<String>> importGroup(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return groupFacade.uploadGroupInfo(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import group, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return null;
  }

  @ApiOperation(value = "文件导入群体活动记录", notes = "导入文件")
  @PostMapping(value = "groupRecord/upload")
  public @ResponseBody
  Map<String, List<String>> importRecord(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return groupFacade.uploadGroupRecord(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import group record, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return null;
  }

  @ApiOperation(value = "导出群体汇总信息EXCEL", notes = "导出群体汇总信息EXCEL")
  @GetMapping(value = "groupSummary/export")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "groupName", value = "群体名称", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "groupType", value = "群体类别", paramType = "query", dataType = "String")
  })
  public void exportGroupSummary(
      @RequestParam(name = "groupName", required = false) final String groupName,
      @RequestParam(name = "groupType", required = false) final String groupType,
      HttpServletResponse response) {
    Map<String, Object> queryMap = new HashMap<>(16);
    queryMap.put("groupName", groupName);
    queryMap.put("groupType", groupType);
    HSSFWorkbook book = groupFacade.exportGroupSummary(queryMap, 0, 99999999);
    ExportExcelUtil.generateExcelResponse("群体汇总信息表", book, response);
  }

  @ApiOperation(value = "导出群体活动记录EXCEL", notes = "导出群体活动记录EXCEL")
  @GetMapping(value = "groupRecord/export")
  @ApiParam(name = "groupRecordPageQueryDTO", value = "groupRecordPageQueryDTO", required = true)
  public void exportGroupRecord(@Valid final GroupRecordPageQueryVO groupRecordPageQueryVO,
      HttpServletResponse response) {
    groupRecordPageQueryVO.setPageNumber(0);
    groupRecordPageQueryVO.setPageSize(99999999);
    HSSFWorkbook book = groupFacade.exportGroupRecord(
        CglibBeanUtil.copyProperties(groupRecordPageQueryVO, GroupRecordPageQueryData.class));
    ExportExcelUtil.generateExcelResponse("群体活动记录表", book, response);
  }
}
