package cn.qsky.policesys.core.person.impl;

import cn.qsky.policesys.common.SourceNotFoundException;
import cn.qsky.policesys.core.dao.mapper.SpecialPersonMapper;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.core.dao.model.SpecialPersonModelExample;
import cn.qsky.policesys.core.person.SpecialPersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;

/**
 * @author qsky on 17/12/1
 */
@Service
public class SpecialPersonServiceImpl implements SpecialPersonService {

  @Resource
  private SpecialPersonMapper specialPersonMapper;

  @Override
  public SpecialPersonModel getSpecialPerson(@NotBlank String idCard) {
    SpecialPersonModelExample example = new SpecialPersonModelExample();
    example.or().andIdCardEqualTo(idCard).andDeleteFlagEqualTo(false);
    List<SpecialPersonModel> resultList = specialPersonMapper.selectByExample(example);
    if (CollectionUtils.isEmpty(resultList) || resultList.size() > 1) {
      throw new SourceNotFoundException();
    }
    return resultList.get(0);
  }

  @Override
  public int countSpecialPerson(String idCard) {
    SpecialPersonModelExample example = new SpecialPersonModelExample();
    example.or().andIdCardEqualTo(idCard);
    List<SpecialPersonModel> resultList = specialPersonMapper.selectByExample(example);
    if (CollectionUtils.isEmpty(resultList)) {
      return 0;
    }
    return resultList.size();
  }

  @Override
  public int saveSpecialPerson(SpecialPersonModel specialPersonModel) {
    return specialPersonMapper.insertSelective(specialPersonModel);
  }

  @Override
  public int updateSpecialPerson(SpecialPersonModel specialPersonModel) {
    return specialPersonMapper.updateByPrimaryKeySelective(specialPersonModel);
  }

  @Override
  public Page<SpecialPersonModel> listSpecialPersonForPage(Map<String, Object> queryMap,
      Integer pageNum, Integer pageSize) {
    Page<SpecialPersonModel> page = PageHelper.startPage(pageNum, pageSize)
        .doSelectPage(() -> specialPersonMapper.listSpecialPersonForPage(queryMap));
    return page;
  }
}
