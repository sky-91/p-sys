package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.ExportExcelUtil;
import cn.qsky.policesys.common.vo.PageVO;
import cn.qsky.policesys.common.vo.PageVOConverter;
import cn.qsky.policesys.facade.person.SpecialPersonFacade;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import cn.qsky.policesys.web.vo.SpecialPersonVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
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
 * @author qsky on 17/12/3
 */
@Api(description = "疆藏人员模型接口")
@RestController
@RequestMapping("person")
public class SpecialPersonController {

  private static final Logger LOG = LoggerFactory.getLogger(SpecialPersonController.class);

  @Resource
  private SpecialPersonFacade specialPersonFacade;

  @ApiOperation(value = "根据身份证查询疆藏人员信息", notes = "根据身份证查询疆藏人员信息")
  @ApiImplicitParam(name = "idCard", value = "身份证", required = true, dataType = "String", paramType = "path")
  @GetMapping("getById/{idCard}")
  @Deprecated
  public SpecialPersonVO getSpecialPerson(
      @NotBlank @PathVariable(name = "idCard") final String idCard) {
    return CglibBeanUtil
        .copyProperties(specialPersonFacade.getSpecialPerson(idCard), SpecialPersonVO.class);
  }

  @ApiOperation(value = "疆藏人员清单列表", notes = "分页显示疆藏人员清单")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "startActivityTime", value = "起始活动时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "endActivityTime", value = "终止活动时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "startPushTime", value = "起始推送时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "endPushTime", value = "终止推送时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "jurisdiction", value = "管辖单位", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "personType", value = "是疆(0)、藏(1)", paramType = "query", dataType = "Boolean"),
      @ApiImplicitParam(name = "resourceName", value = "资源名", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "pageNumber", value = "当前页码", paramType = "query", dataType = "Integer", required = true),
      @ApiImplicitParam(name = "pageSize", value = "每页显示多少条", paramType = "query", dataType = "Integer", required = true)
  })
  @GetMapping(value = "listForPage")
  public PageVO<SpecialPersonVO> listSpecialPerson(
      @RequestParam(name = "startActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date startActivityTime,
      @RequestParam(name = "endActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date endActivityTime,
      @RequestParam(name = "startPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Date startPushTime,
      @RequestParam(name = "endPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Date endPushTime,
      @RequestParam(name = "jurisdiction", required = false) final String jurisdiction,
      @RequestParam(name = "personType", required = false) final Boolean personType,
      @RequestParam(name = "resourceName", required = false) final String resourceName,
      @RequestParam(name = "pageNumber") final Integer pageNumber,
      @RequestParam(name = "pageSize") final Integer pageSize) {
    Map<String, Object> queryMap = new HashMap<>(16);
    queryMap.put("startActivityTime", startActivityTime);
    queryMap.put("endActivityTime", endActivityTime);
    queryMap.put("startPushTime", startPushTime);
    queryMap.put("endPushTime", endPushTime);
    queryMap.put("jurisdiction", jurisdiction);
    queryMap.put("personType", personType);
    queryMap.put("resourceName", resourceName);
    return PageVOConverter
        .converter(specialPersonFacade.listSpecialPersonForPage(queryMap, pageNumber, pageSize),
            SpecialPersonVO.class);
  }

  @ApiOperation(value = "保存疆藏人员信息", notes = "保存接口")
  @ApiParam(name = "specialPersonVO", value = "specialPersonVO", required = true)
  @PostMapping("save")
  public Boolean saveSpecialPerson(
      @Valid @RequestBody final SpecialPersonVO specialPersonVO) {
    LOG.debug("saveSpecialPerson : {}", specialPersonVO.toString());
    return specialPersonFacade.saveSpecialPerson(CglibBeanUtil.copyProperties(specialPersonVO,
        SpecialPersonData.class));
  }

  @ApiOperation(value = "修改疆藏人员信息", notes = "修改接口")
  @ApiParam(name = "specialPersonVO", value = "specialPersonVO", required = true)
  @PutMapping("update")
  public Boolean updateSpecialPerson(
      @Valid @RequestBody final SpecialPersonVO specialPersonVO) {
    LOG.debug("updateSpecialPerson : {}", specialPersonVO.toString());
    return specialPersonFacade.updateSpecialPerson(CglibBeanUtil.copyProperties(specialPersonVO,
        SpecialPersonData.class));
  }

  @ApiOperation(value = "删除疆藏人员信息", notes = "删除接口")
  @ApiImplicitParam(name = "idCard", value = "身份证", required = true, dataType = "String", paramType = "path")
  @DeleteMapping("deleteById/{idCard}")
  public Boolean deleteSpecialPerson(@NotBlank @PathVariable(name = "idCard") final String idCard) {
    LOG.debug("deleteSpecialPerson : {}", idCard);
    return specialPersonFacade.deleteSpecialPerson(idCard);
  }

  @ApiOperation(value = "文件导入疆藏人员信息", notes = "导入文件")
  @PostMapping(value = "upload")
  @ResponseBody
  public Map<String, List<String>> importSpecialPerson(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return specialPersonFacade
            .uploadSpecialPerson(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("File {} is wrong!", file.getOriginalFilename());
      }
    }
    return null;
  }

  @ApiOperation(value = "导出疆藏人员EXCEL", notes = "导出疆藏人员EXCEL")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "startActivityTime", value = "起始活动时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "endActivityTime", value = "终止活动时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "startPushTime", value = "起始推送时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "endPushTime", value = "终止推送时间", paramType = "query", dataType = "Date"),
      @ApiImplicitParam(name = "jurisdiction", value = "管辖单位", paramType = "query", dataType = "String"),
      @ApiImplicitParam(name = "personType", value = "是疆(0)、藏(1)", paramType = "query", dataType = "Boolean"),
      @ApiImplicitParam(name = "resourceName", value = "资源名", paramType = "query", dataType = "String")
  })
  @GetMapping(value = "export")
  public void exportSpecialPerson(
      @RequestParam(name = "startActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date startActivityTime,
      @RequestParam(name = "endActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date endActivityTime,
      @RequestParam(name = "startPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Date startPushTime,
      @RequestParam(name = "endPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Date endPushTime,
      @RequestParam(name = "jurisdiction", required = false) final String jurisdiction,
      @RequestParam(name = "personType", required = false) final Boolean personType,
      @RequestParam(name = "resourceName", required = false) final String resourceName,
      HttpServletResponse response) {
    Map<String, Object> queryMap = new HashMap<>(16);
    queryMap.put("startActivityTime", startActivityTime);
    queryMap.put("endActivityTime", endActivityTime);
    queryMap.put("startPushTime", startPushTime);
    queryMap.put("endPushTime", endPushTime);
    queryMap.put("jurisdiction", jurisdiction);
    queryMap.put("personType", personType);
    queryMap.put("resourceName", resourceName);
    HSSFWorkbook book = specialPersonFacade.exportSpecialPerson(queryMap, 0, 99999999);
    ExportExcelUtil.generateExcelResponse("疆藏人员信息表", book, response);
  }
}
