package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.core.person.SpecialPersonService;
import cn.qsky.policesys.facade.person.SpecialPersonBuilder;
import cn.qsky.policesys.facade.person.SpecialPersonFacade;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
    if (specialPersonService.saveSpecialPerson(CglibBeanUtil.copyProperties(specialPersonData,
        SpecialPersonModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateSpecialPerson(SpecialPersonData specialPersonData) {
    if (specialPersonService.updateSpecialPerson(CglibBeanUtil.copyProperties(specialPersonData,
        SpecialPersonModel.class)) == 1) {
      return true;
    } else {
      return false;
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
}
