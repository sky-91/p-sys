package cn.qsky.policesys.core.person.impl;

import cn.qsky.policesys.common.SourceNotFoundException;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonInfoMapper;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonRecordMapper;
import cn.qsky.policesys.core.dao.mapper.PersonContactInfoMapper;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModelExample;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dao.model.PersonContactInfoModel;
import cn.qsky.policesys.core.dao.model.PersonContactInfoModelExample;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.person.ImportantPersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

/**
 * @author qsky on 17/12/6
 */
@Service
public class ImportantPersonServiceImpl implements ImportantPersonService {

  @Resource
  private ImportantPersonInfoMapper importantPersonInfoMapper;

  @Resource
  private ImportantPersonRecordMapper importantPersonRecordMapper;

  @Resource
  private PersonContactInfoMapper personContactInfoMapper;

  @Override
  public ImportantPersonInfoModel getSimplePersonInfo(String idCard) {
    ImportantPersonInfoModelExample example = new ImportantPersonInfoModelExample();
    example.or().andIdCardEqualTo(idCard);
    List<ImportantPersonInfoModel> resultList = importantPersonInfoMapper.selectByExample(example);
    if (CollectionUtils.isNotEmpty(resultList) && resultList.size() == 1) {
      return resultList.get(0);
    }
    throw new SourceNotFoundException();
  }

  @Override
  public ImportantPersonInfoModel getImportantPersonInfo(String idCard) {
    ImportantPersonInfoModel model = importantPersonInfoMapper.getImportantPersonInfo(idCard);
    if (model == null) {
      throw new SourceNotFoundException();
    }
    return model;
  }

  @Override
  public int countImportantPerson(String idCard) {
    ImportantPersonInfoModelExample example = new ImportantPersonInfoModelExample();
    example.or().andIdCardEqualTo(idCard);
    List<ImportantPersonInfoModel> resultList = importantPersonInfoMapper.selectByExample(example);
    if (CollectionUtils.isEmpty(resultList)) {
      return 0;
    }
    return resultList.size();
  }

  @Override
  public int saveImportantPersonInfo(ImportantPersonInfoModel importantPersonInfoModel) {
    List<PersonContactInfoModel> contactModels = importantPersonInfoModel.getContacts();
    int result = importantPersonInfoMapper.insertSelective(importantPersonInfoModel);
    if (result == 1 && CollectionUtils.isNotEmpty(contactModels)) {
      for (PersonContactInfoModel contact : contactModels) {
        contact.setPersonPk(importantPersonInfoModel.getPk());
        personContactInfoMapper.insertSelective(contact);
      }
    }
    return result;
  }

  @Override
  public int updateImportantPersonInfo(ImportantPersonInfoModel importantPersonInfoModel) {
    Long pk = importantPersonInfoModel.getPk();
    List<PersonContactInfoModel> contactModels = importantPersonInfoModel.getContacts();
    PersonContactInfoModelExample example = new PersonContactInfoModelExample();
    example.or().andPersonPkEqualTo(pk);
    personContactInfoMapper.deleteByExample(example);
    if (CollectionUtils.isNotEmpty(contactModels)) {
      for (PersonContactInfoModel contact : contactModels) {
        contact.setPersonPk(importantPersonInfoModel.getPk());
        personContactInfoMapper.insertSelective(contact);
      }
    }
    return importantPersonInfoMapper.updateByPrimaryKeySelective(importantPersonInfoModel);
  }

  @Override
  public int saveImportantPersonRecord(
      ImportantPersonRecordModel importantPersonRecordModel) {
    return importantPersonRecordMapper.insertSelective(importantPersonRecordModel);
  }

  @Override
  public int updateImportantPersonRecord(
      ImportantPersonRecordModel importantPersonRecordModel) {
    return importantPersonRecordMapper.updateByPrimaryKeySelective(importantPersonRecordModel);
  }

  @Override
  public Page<ImportantPersonInfoModel> listImportantPersonForPage(
      ImportantPersonPageQueryDTO importantPersonPageQueryDTO) {
    Page<ImportantPersonInfoModel> page = PageHelper
        .startPage(importantPersonPageQueryDTO.getPageNum(),
            importantPersonPageQueryDTO.getPageSize()).doSelectPage(() -> importantPersonInfoMapper
            .listImportantPersonInfoForPage(importantPersonPageQueryDTO));
    return page;
  }
}
