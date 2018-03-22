package cn.qsky.policesys.core.person.impl;

import cn.qsky.policesys.common.exception.SourceNotFoundException;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonInfoMapper;
import cn.qsky.policesys.core.dao.mapper.ImportantPersonRecordMapper;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModelExample;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModelExample;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.dto.ImportantRecordPageQueryDTO;
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
    return importantPersonInfoMapper.insertSelective(importantPersonInfoModel);
  }

  @Override
  public int updateImportantPersonInfo(ImportantPersonInfoModel importantPersonInfoModel) {
    ImportantPersonInfoModelExample infoExample = new ImportantPersonInfoModelExample();
    infoExample.or().andIdCardEqualTo(importantPersonInfoModel.getIdCard());
    return importantPersonInfoMapper
        .updateByExampleSelective(importantPersonInfoModel, infoExample);
  }

  @Override
  public int deleteImportantPersonInfo(String idCard) {
    ImportantPersonRecordModelExample recordExample = new ImportantPersonRecordModelExample();
    recordExample.or().andIdCardEqualTo(idCard);
    importantPersonRecordMapper.deleteByExample(recordExample);

    ImportantPersonInfoModelExample example = new ImportantPersonInfoModelExample();
    example.or().andIdCardEqualTo(idCard);
    return importantPersonInfoMapper.deleteByExample(example);
  }

  @Override
  public ImportantPersonRecordModel getImportantPersonRecord(String pk) {
    ImportantPersonRecordModel model = importantPersonRecordMapper
        .selectByPrimaryKey(Long.valueOf(pk));
    if (model == null) {
      throw new SourceNotFoundException();
    }
    return model;
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
  public int deleteImportantPersonRecord(String pk) {
    return importantPersonRecordMapper.deleteByPrimaryKey(Long.valueOf(pk));
  }

  @Override
  public Page<ImportantPersonInfoModel> listImportantPersonForPage(
      ImportantPersonPageQueryDTO dto) {
    return PageHelper.startPage(dto.getPageNumber(), dto.getPageSize())
        .doSelectPage(() -> importantPersonInfoMapper.listImportantPersonInfoForPage(dto));
  }

  @Override
  public Page<ImportantPersonRecordModel> listImportantRecordForPage(
      ImportantRecordPageQueryDTO dto) {
    return PageHelper.startPage(dto.getPageNumber(), dto.getPageSize())
        .doSelectPage(() -> importantPersonRecordMapper.listImportantPersonRecordForPage(dto));
  }
}
