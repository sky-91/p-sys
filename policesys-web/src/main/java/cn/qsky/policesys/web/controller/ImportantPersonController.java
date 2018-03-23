package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.common.util.ExportExcelUtil;
import cn.qsky.policesys.common.vo.PageVO;
import cn.qsky.policesys.common.vo.PageVOConverter;
import cn.qsky.policesys.facade.person.ImportantPersonFacade;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import cn.qsky.policesys.facade.person.data.ImportantRecordPageQueryData;
import cn.qsky.policesys.web.vo.ImportantPersonInfoVO;
import cn.qsky.policesys.web.vo.ImportantPersonRecordVO;
import cn.qsky.policesys.web.vo.query.ImportantPersonPageQueryVO;
import cn.qsky.policesys.web.vo.query.ImportantRecordPageQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(description = "重点人员接口")
@RestController
@RequestMapping("importantPerson")
public class ImportantPersonController {

  private static final Logger LOG = LoggerFactory.getLogger(ImportantPersonController.class);
  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  @Resource
  private ImportantPersonFacade importantPersonFacade;

  @ApiOperation(value = "根据身份证查询重点人员信息", notes = "根据身份证查询重点人员信息")
  @ApiImplicitParam(name = "idCard", value = "身份证", required = true, dataType = "String", paramType = "path")
  @GetMapping("getById/{idCard}")
  public ImportantPersonInfoVO getImportantPersonInfo(
      @NotBlank @PathVariable(name = "idCard") final String idCard) {
    return mapper.map(importantPersonFacade.getImportantPersonInfo(idCard),
        ImportantPersonInfoVO.class);
  }

  @ApiOperation(value = "保存重点人员信息", notes = "保存接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PostMapping("save")
  public Boolean saveImportantPerson(
      @Valid @RequestBody final ImportantPersonInfoVO importantPersonInfoVO) {
    LOG.debug(importantPersonInfoVO.toString());
    return importantPersonFacade
        .saveImportantPersonInfo(mapper.map(importantPersonInfoVO,
            ImportantPersonInfoData.class));
  }

  @ApiOperation(value = "修改重点人员信息", notes = "修改接口")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @PutMapping("update")
  public Boolean updateImportantPerson(
      @Valid @RequestBody final ImportantPersonInfoVO importantPersonInfoVO) {
    LOG.debug(importantPersonInfoVO.toString());
    return importantPersonFacade.updateImportantPersonInfo(mapper.map(importantPersonInfoVO,
        ImportantPersonInfoData.class));
  }

  @ApiOperation(value = "删除重点人员信息", notes = "删除接口")
  @ApiImplicitParam(name = "idCard", value = "身份证", required = true, dataType = "String", paramType = "path")
  @DeleteMapping("deleteById/{idCard}")
  public Boolean deleteImportantPerson(
      @NotBlank @PathVariable(name = "idCard") final String idCard) {
    LOG.debug("deleteImportantPerson : {}", idCard);
    return importantPersonFacade.deleteImportantPersonInfo(idCard);
  }

  @ApiOperation(value = "重点人员清单列表", notes = "分页显示重点人员清单")
  @ApiParam(name = "importantPersonPageQueryVO", value = "importantPersonPageQueryVO", required = true)
  @GetMapping(value = "listForPage")
  public PageVO<ImportantPersonInfoVO> listImportantPerson(
      @Valid final ImportantPersonPageQueryVO importantPersonPageQueryVO) {
    return PageVOConverter.converter(importantPersonFacade.listImportantPersonForPage(CglibBeanUtil
            .copyProperties(importantPersonPageQueryVO, ImportantPersonPageQueryData.class)),
        ImportantPersonInfoVO.class);
  }

  @ApiOperation(value = "文件导入重点人员信息", notes = "导入文件")
  @PostMapping(value = "/upload")
  public @ResponseBody
  Map<String, List<String>> importPerson(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return importantPersonFacade
            .uploadPersonInfo(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import important person, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return null;
  }

  @ApiOperation(value = "查询人员积分轨迹信息", notes = "根据pk查询")
  @ApiImplicitParam(name = "pk", value = "pk", required = true, dataType = "String", paramType = "path")
  @GetMapping("record/getByPk/{pk}")
  public ImportantPersonRecordVO getImportantRecord(
      @NotBlank @PathVariable(name = "pk") final String pk) {
    return CglibBeanUtil.copyProperties(importantPersonFacade.getImportantPersonRecord(pk),
        ImportantPersonRecordVO.class);
  }

  @ApiOperation(value = "保存人员积分轨迹信息", notes = "保存接口")
  @ApiParam(name = "importantPersonRecordVO", value = "importantPersonRecordVO", required = true)
  @PostMapping("record/save")
  public Boolean saveImportantRecord(
      @Valid @RequestBody final ImportantPersonRecordVO importantPersonRecordVO) {
    LOG.debug(importantPersonRecordVO.toString());
    return importantPersonFacade
        .saveImportantPersonRecord(CglibBeanUtil.copyProperties(importantPersonRecordVO,
            ImportantPersonRecordData.class));
  }

  @ApiOperation(value = "修改人员积分轨迹信息", notes = "修改接口")
  @ApiParam(name = "importantPersonRecordVO", value = "importantPersonRecordVO", required = true)
  @PutMapping("record/update")
  public Boolean updateImportantRecord(
      @Valid @RequestBody final ImportantPersonRecordVO importantPersonRecordVO) {
    LOG.debug(importantPersonRecordVO.toString());
    return importantPersonFacade
        .updateImportantPersonRecord(CglibBeanUtil.copyProperties(importantPersonRecordVO,
            ImportantPersonRecordData.class));
  }

  @ApiOperation(value = "删除人员积分轨迹信息", notes = "删除接口")
  @ApiImplicitParam(name = "pk", value = "PK", required = true, dataType = "String", paramType = "path")
  @DeleteMapping("record/deleteByPk/{pk}")
  public Boolean deleteImportantRecord(@NotBlank @PathVariable(name = "pk") final String pk) {
    LOG.debug("deleteImportantPerson : {}", pk);
    return importantPersonFacade.deleteImportantPersonRecord(pk);
  }

  @ApiOperation(value = "重点人员积分轨迹清单列表", notes = "分页显示重点人员积分轨迹清单")
  @ApiParam(name = "importantRecordPageQueryVO", value = "importantRecordPageQueryVO", required = true)
  @GetMapping(value = "record/listForPage")
  public PageVO<ImportantPersonRecordVO> listImportantRecord(
      @Valid final ImportantRecordPageQueryVO importantRecordPageQueryVO) {
    return PageVOConverter.converter(importantPersonFacade.listImportantRecordForPage(CglibBeanUtil
            .copyProperties(importantRecordPageQueryVO, ImportantRecordPageQueryData.class)),
        ImportantPersonRecordVO.class);
  }

  @ApiOperation(value = "文件导入重点人员活动轨迹", notes = "导入文件")
  @PostMapping(value = "record/upload")
  public @ResponseBody
  Map<String, List<String>> importRecord(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return importantPersonFacade
            .uploadPersonRecord(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import important person record, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return null;
  }

  @ApiOperation(value = "导出重点人员EXCEL", notes = "导出重点人员EXCEL")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @GetMapping(value = "export")
  public void exportImportantPerson(
      @Valid final ImportantPersonPageQueryVO importantPersonPageQueryVO,
      HttpServletResponse response) {
    importantPersonPageQueryVO.setPageNumber(0);
    importantPersonPageQueryVO.setPageSize(99999999);
    HSSFWorkbook book = importantPersonFacade.exportImportantPerson(CglibBeanUtil
        .copyProperties(importantPersonPageQueryVO, ImportantPersonPageQueryData.class));
    ExportExcelUtil.generateExcelResponse("重点人员底库表", book, response);
  }

  @ApiOperation(value = "导出重点人员积分轨迹EXCEL", notes = "导出重点人员积分轨迹EXCEL")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @GetMapping(value = "record/export")
  public void exportImportantRecord(
      @Valid final ImportantRecordPageQueryVO importantRecordPageQueryVO,
      HttpServletResponse response) {
    importantRecordPageQueryVO.setPageNumber(0);
    importantRecordPageQueryVO.setPageSize(99999999);
    HSSFWorkbook book = importantPersonFacade.exportImportantRecord(CglibBeanUtil
        .copyProperties(importantRecordPageQueryVO, ImportantRecordPageQueryData.class));
    ExportExcelUtil.generateExcelResponse("重点人员积分轨迹", book, response);
  }
}
