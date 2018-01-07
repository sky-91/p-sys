package cn.qsky.policesys.core.person.impl;

import cn.qsky.policesys.common.SourceNotFoundException;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonInfoMapper;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonRecordMapper;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModelExample;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.person.ImportantPersonService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
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
    return importantPersonInfoMapper.countByExample(example);
  }

  @Override
  public int saveImportantPersonInfo(ImportantPersonInfoModel importantPersonInfoModel) {
    return importantPersonInfoMapper.insertSelective(importantPersonInfoModel);
  }

  @Override
  public int updateImportantPersonInfo(ImportantPersonInfoModel importantPersonInfoModel) {
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
