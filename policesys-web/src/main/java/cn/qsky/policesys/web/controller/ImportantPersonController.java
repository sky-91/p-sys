package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.common.vo.PageVO;
import cn.qsky.policesys.common.vo.PageVOConverter;
import cn.qsky.policesys.facade.person.ImportantPersonFacade;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.web.vo.ImportantPersonInfoVO;
import cn.qsky.policesys.web.vo.query.ImportantPersonPageQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.dozer.DozerBeanMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qsky on 18/1/7
 */
@Api(description = "重点人员接口")
@Controller
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
    return CglibBeanUtil
        .copyProperties(importantPersonFacade.getImportantPersonInfo(idCard),
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

  @ApiOperation(value = "重点人员清单列表", notes = "分页显示重点人员清单")
  @ApiParam(name = "importantPersonInfoVO", value = "importantPersonInfoVO", required = true)
  @GetMapping(value = "listForPage")
  public PageVO<ImportantPersonInfoVO> listImportantPerson(
      @Valid @RequestBody final ImportantPersonPageQueryVO importantPersonPageQueryVO) {
    return PageVOConverter.converter(importantPersonFacade.listImportantPersonForPage(CglibBeanUtil
            .copyProperties(importantPersonPageQueryVO, ImportantPersonPageQueryData.class)),
        ImportantPersonInfoVO.class);
  }

  @ApiOperation(value = "文件导入重点人员信息", notes = "导入文件")
  @PostMapping(value = "/upload")
  public @ResponseBody
  Boolean importPerson(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return importantPersonFacade
            .uploadPersonInfo(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import important person, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return true;
  }

  @ApiOperation(value = "文件导入重点人员活动轨迹", notes = "导入文件")
  @PostMapping(value = "record/upload")
  public @ResponseBody
  Boolean importRecord(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return importantPersonFacade
            .uploadPersonRecord(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("Import important person record, File {} is wrong!", file.getOriginalFilename());
      }
    }
    return true;
  }
}
