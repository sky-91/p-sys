package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.core.person.SpecialPersonService;
import cn.qsky.policesys.facade.person.SpecialPersonFacade;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author qsky on 17/12/3
 */
@Component
public class SpecialPersonFacadeImpl implements SpecialPersonFacade {

  @Resource
  private SpecialPersonService specialPersonService;

  @Override
  public SpecialPersonData getSpecialPerson(String idCard) {
    return CglibBeanUtil
        .copyProperties(specialPersonService.getSpecialPerson(idCard), SpecialPersonData.class);
  }

  @Override
  public Boolean saveSpecialPerson(SpecialPersonData specialPersonData) {
    if (specialPersonService.saveSpecialPerson(CglibBeanUtil.copyProperties(specialPersonData,
        SpecialPersonModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
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
}
