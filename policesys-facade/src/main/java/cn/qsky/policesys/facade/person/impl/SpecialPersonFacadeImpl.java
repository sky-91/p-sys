package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.core.person.SpecialPersonService;
import cn.qsky.policesys.facade.person.SpecialPersonBuilder;
import cn.qsky.policesys.facade.person.SpecialPersonFacade;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qsky on 17/12/3
 */
@Component
public class SpecialPersonFacadeImpl implements SpecialPersonFacade {

  private static final Logger LOG = LoggerFactory.getLogger(SpecialPersonFacadeImpl.class);
  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  @Resource
  private SpecialPersonService specialPersonService;

  @Resource
  private SpecialPersonBuilder specialPersonBuilder;

  @Override
  public SpecialPersonData getSpecialPerson(String idCard) {
    return CglibBeanUtil
        .copyProperties(specialPersonService.getSpecialPerson(idCard), SpecialPersonData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveSpecialPerson(SpecialPersonData specialPersonData) {
    handlePersonType(specialPersonData);
    if (specialPersonService
        .saveSpecialPerson(mapper.map(specialPersonData, SpecialPersonModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateSpecialPerson(SpecialPersonData specialPersonData) {
    handlePersonType(specialPersonData);
    if (specialPersonService
        .updateSpecialPerson(mapper.map(specialPersonData, SpecialPersonModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  private void handlePersonType(SpecialPersonData specialPersonData) {
    if (StringUtils.isNotBlank(specialPersonData.getIdCard())) {
      String idStart = specialPersonData.getIdCard().substring(0, 2);
      switch (idStart) {
        case "54":
          // 西藏
          specialPersonData.setPersonType(true);
          break;
        case "65":
          // 新疆
          specialPersonData.setPersonType(false);
          break;
        default:
          specialPersonData.setPersonType(false);
          break;
      }
    }
  }

  @Override
  public PageData<SpecialPersonData> listSpecialPersonForPage(Map<String, Object> queryMap,
      Integer pageNum, Integer pageSize) {
    return PageDataConverter
        .converter(specialPersonService.listSpecialPersonForPage(queryMap, pageNum, pageSize),
            SpecialPersonData.class);
  }

  @Override
  public Boolean uploadSpecialPerson(Workbook workbook) {
    List<SpecialPersonData> dataList = specialPersonBuilder.buildPersonList(workbook);
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (SpecialPersonData personData : dataList) {
        Boolean result;
        if (specialPersonService.countSpecialPerson(personData.getIdCard()) == 1) {
          result = updateSpecialPerson(personData);
        } else {
          result = saveSpecialPerson(personData);
        }
        if (!result) {
          LOG.error("Person: {} is error!", personData.getIdCard());
        }
      }
    }
    return true;
  }

  @Override
  public HSSFWorkbook exportSpecialPerson(Map<String, Object> queryMap, Integer pageNum,
      Integer pageSize) {
    return specialPersonBuilder.fillSpecialPersonBook(
        specialPersonService.listSpecialPersonForPage(queryMap, pageNum, pageSize).getResult());
  }
}
