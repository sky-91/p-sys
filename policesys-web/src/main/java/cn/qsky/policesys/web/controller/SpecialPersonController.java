package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
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
import java.util.Map;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qsky on 17/12/3
 */
@Api(description = "疆藏人员模型接口")
@Controller
@RequestMapping("person")
public class SpecialPersonController {

  private static final Logger LOG = LoggerFactory.getLogger(SpecialPersonController.class);

  @Resource
  private SpecialPersonFacade specialPersonFacade;

  @ApiOperation(value = "根据身份证查询疆藏人员信息", notes = "根据身份证查询疆藏人员信息")
  @ApiImplicitParam(name = "idCard", value = "身份证", required = true, dataType = "String", paramType = "path")
  @GetMapping("getById/{idCard}")
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
      @ApiImplicitParam(name = "deleteFlag", value = "是否删除", paramType = "query", dataType = "Boolean"),
      @ApiImplicitParam(name = "pageNum", value = "当前页码", paramType = "query", dataType = "Integer", required = true),
      @ApiImplicitParam(name = "pageSize", value = "每页显示多少条", paramType = "query", dataType = "Integer", required = true)
  })
  @GetMapping(value = "listForPage")
  public PageVO<SpecialPersonVO> listSpecialPerson(
      @RequestParam(name = "startActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date startActivityTime,
      @RequestParam(name = "endActivityTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date endActivityTime,
      @RequestParam(name = "startPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date startPushTime,
      @RequestParam(name = "endPushTime", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") final Date endPushTime,
      @RequestParam(name = "jurisdiction", required = false) final String jurisdiction,
      @RequestParam(name = "personType", required = false) final Boolean personType,
      @RequestParam(name = "pageNum") final Integer pageNum,
      @RequestParam(name = "pageSize") final Integer pageSize) {
    Map<String, Object> queryMap = new HashMap<>(16);
    queryMap.put("startActivityTime", startActivityTime);
    queryMap.put("endActivityTime", endActivityTime);
    queryMap.put("startPushTime", startPushTime);
    queryMap.put("endPushTime", endPushTime);
    queryMap.put("jurisdiction", jurisdiction);
    queryMap.put("personType", personType);
    return PageVOConverter
        .converter(specialPersonFacade.listSpecialPersonForPage(queryMap, pageNum, pageSize),
            SpecialPersonVO.class);
  }

  @ApiOperation(value = "保存疆藏人员信息", notes = "保存接口")
  @ApiParam(name = "specialPersonVO", value = "specialPersonVO", required = true)
  @PostMapping("save")
  public Boolean saveSpecialPerson(
      @Valid @RequestBody final SpecialPersonVO specialPersonVO) {
    LOG.debug(specialPersonVO.toString());
    return specialPersonFacade.saveSpecialPerson(CglibBeanUtil.copyProperties(specialPersonVO,
        SpecialPersonData.class));
  }

  @ApiOperation(value = "修改疆藏人员信息", notes = "修改接口")
  @ApiParam(name = "specialPersonVO", value = "specialPersonVO", required = true)
  @PutMapping("update")
  public Boolean updateSpecialPerson(
      @Valid @RequestBody final SpecialPersonVO specialPersonVO) {
    LOG.debug(specialPersonVO.toString());
    return specialPersonFacade.updateSpecialPerson(CglibBeanUtil.copyProperties(specialPersonVO,
        SpecialPersonData.class));
  }
}