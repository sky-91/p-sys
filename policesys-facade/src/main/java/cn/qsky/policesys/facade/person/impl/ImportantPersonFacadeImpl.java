package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.person.ImportantPersonService;
import cn.qsky.policesys.facade.person.ImportantPersonBuilder;
import cn.qsky.policesys.facade.person.ImportantPersonFacade;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qsky on 17/12/6
 */
@Component
public class ImportantPersonFacadeImpl implements ImportantPersonFacade {

  private static final Logger LOG = LoggerFactory.getLogger(ImportantPersonFacadeImpl.class);
  private static DozerBeanMapper mapper = DozerBeanMapperFactory.getMapper();

  @Resource
  private ImportantPersonService importantPersonService;

  @Resource
  private ImportantPersonBuilder importantPersonBuilder;

  @Override
  public ImportantPersonInfoData getImportantPersonInfo(String idCard) {
    return CglibBeanUtil.copyProperties(importantPersonService.getImportantPersonInfo(idCard),
        ImportantPersonInfoData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveImportantPersonInfo(ImportantPersonInfoData importantPersonInfoData) {
    List<ImportantPersonRecordData> recordDataList = importantPersonInfoData.getRecords();
    if (importantPersonService.saveImportantPersonInfo(
        mapper.map(importantPersonInfoData, ImportantPersonInfoModel.class)) == 1) {
      if (CollectionUtils.isEmpty(recordDataList)) {
        return true;
      } else {
        for (ImportantPersonRecordData recordData : recordDataList) {
          if (importantPersonService
              .saveImportantPersonRecord(CglibBeanUtil.copyProperties(recordData,
                  ImportantPersonRecordModel.class)) == 1) {
            continue;
          } else {
            return false;
          }
        }
        return true;
      }
    } else {
      return false;
    }
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateImportantPersonInfo(ImportantPersonInfoData importantPersonInfoData) {
    List<ImportantPersonRecordData> recordDataList = importantPersonInfoData.getRecords();
    ImportantPersonInfoModel infoModel = importantPersonService
        .getSimplePersonInfo(importantPersonInfoData.getIdCard());
    mapper.map(importantPersonInfoData, infoModel);
    if (importantPersonService.updateImportantPersonInfo(infoModel) == 1) {
      if (CollectionUtils.isEmpty(recordDataList)) {
        return true;
      } else {
        for (ImportantPersonRecordData recordData : recordDataList) {
          if (importantPersonService
              .updateImportantPersonRecord(CglibBeanUtil.copyProperties(recordData,
                  ImportantPersonRecordModel.class)) == 1) {
            continue;
          } else {
            return false;
          }
        }
        return true;
      }
    } else {
      return false;
    }
  }

  @Override
  public PageData<ImportantPersonInfoData> listImportantPersonForPage(
      ImportantPersonPageQueryData importantPersonPageQueryData) {
    return PageDataConverter.converter(importantPersonService.listImportantPersonForPage(
        CglibBeanUtil
            .copyProperties(importantPersonPageQueryData, ImportantPersonPageQueryDTO.class)),
        ImportantPersonInfoData.class);
  }

  @Override
  public Boolean uploadPersonInfo(Workbook workbook) {
    List<ImportantPersonInfoData> dataList = importantPersonBuilder.buildPersonInfoList(workbook);
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (ImportantPersonInfoData personData : dataList) {
        Boolean result;
        if (importantPersonService.countImportantPerson(personData.getIdCard()) == 1) {
          result = updateImportantPersonInfo(personData);
        } else {
          result = saveImportantPersonInfo(personData);
        }
        if (!result) {
          LOG.error("Person: {} is error!", personData.getIdCard());
        }
      }
    }
    return true;
  }

  @Override
  public Boolean uploadPersonRecord(Workbook workbook) {
    List<ImportantPersonRecordData> dataList = importantPersonBuilder
        .buildPersonRecordList(workbook);
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (ImportantPersonRecordData recordData : dataList) {
        Boolean result;
        if (importantPersonService.countImportantPerson(recordData.getIdCard()) == 1) {
          result = importantPersonService.saveImportantPersonRecord(
              CglibBeanUtil.copyProperties(recordData, ImportantPersonRecordModel.class)) == 1;
        } else {
          result = false;
        }
        if (!result) {
          LOG.error("Person: {} is error!", recordData.getIdCard());
        }
      }
    }
    return true;
  }
}
