package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.common.util.DozerBeanMapperFactory;
import cn.qsky.policesys.common.util.StringUtil;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.dto.ImportantRecordPageQueryDTO;
import cn.qsky.policesys.core.person.ImportantPersonService;
import cn.qsky.policesys.facade.person.ImportantPersonBuilder;
import cn.qsky.policesys.facade.person.ImportantPersonFacade;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import cn.qsky.policesys.facade.person.data.ImportantRecordPageQueryData;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
    ImportantPersonInfoModel infoModel = importantPersonService.getImportantPersonInfo(idCard);
    List<ImportantPersonRecordModel> recordModelList = infoModel.getRecords();
    recordModelList
        .sort(Comparator.comparing(ImportantPersonRecordModel::getRecordDate).reversed());
    ImportantPersonInfoData infoData = CglibBeanUtil
        .copyProperties(infoModel, ImportantPersonInfoData.class);
    infoData
        .setRecords(CglibBeanUtil.converterList(recordModelList, ImportantPersonRecordData.class));
    return infoData;
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
  @Transactional(rollbackFor = Exception.class)
  public Boolean deleteImportantPersonInfo(String idCard) {
    if (importantPersonService.deleteImportantPersonInfo(idCard) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public PageData<ImportantPersonInfoData> listImportantPersonForPage(
      ImportantPersonPageQueryData data) {
    return PageDataConverter.converter(importantPersonService.listImportantPersonForPage(
        CglibBeanUtil.copyProperties(data, ImportantPersonPageQueryDTO.class)),
        ImportantPersonInfoData.class);
  }

  @Override
  public ImportantPersonRecordData getImportantPersonRecord(String pk) {
    return CglibBeanUtil.copyProperties(importantPersonService.getImportantPersonRecord(pk),
        ImportantPersonRecordData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean saveImportantPersonRecord(
      ImportantPersonRecordData importantPersonRecordData) {
    if (importantPersonService
        .saveImportantPersonRecord(CglibBeanUtil.copyProperties(importantPersonRecordData,
            ImportantPersonRecordModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean updateImportantPersonRecord(
      ImportantPersonRecordData importantPersonRecordData) {
    if (importantPersonService
        .updateImportantPersonRecord(CglibBeanUtil.copyProperties(importantPersonRecordData,
            ImportantPersonRecordModel.class)) == 1) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean deleteImportantPersonRecord(String pk) {
    if (importantPersonService.deleteImportantPersonRecord(pk) == 1) {
      return true;
    }
    return false;
  }

  @Override
  public PageData<ImportantPersonRecordData> listImportantRecordForPage(
      ImportantRecordPageQueryData importantRecordPageQueryData) {
    return PageDataConverter.converter(importantPersonService.listImportantRecordForPage(
        CglibBeanUtil
            .copyProperties(importantRecordPageQueryData, ImportantRecordPageQueryDTO.class)),
        ImportantPersonRecordData.class);
  }

  @Override
  public Map<String, List<String>> uploadPersonInfo(Workbook workbook) {
    List<ImportantPersonInfoData> dataList = importantPersonBuilder.buildPersonInfoList(workbook);
    List<String> saveList = new ArrayList<>();
    List<String> updateList = new ArrayList<>();
    List<String> failedList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (ImportantPersonInfoData personData : dataList) {
        int count = importantPersonService.countImportantPerson(personData.getIdCard());
        try {
          if (count == 1 && updateImportantPersonInfo(personData)) {
            updateList.add(personData.getIdCard());
          } else if (count == 0 && saveImportantPersonInfo(personData)) {
            saveList.add(personData.getIdCard());
          } else {
            LOG.error("Person: {} is error!", personData.getIdCard());
            failedList.add(personData.getIdCard());
          }
        } catch (Exception e) {
          LOG.error("Person: {} is error!", personData.getIdCard());
          e.printStackTrace();
          failedList.add(personData.getIdCard());
        }
      }
    }
    return StringUtil.generateMap(saveList, updateList, failedList);
  }

  @Override
  public Map<String, List<String>> uploadPersonRecord(Workbook workbook) {
    List<ImportantPersonRecordData> dataList = importantPersonBuilder
        .buildPersonRecordList(workbook);
    List<String> saveList = new ArrayList<>();
    List<String> updateList = new ArrayList<>();
    List<String> failedList = new ArrayList<>();
    if (CollectionUtils.isNotEmpty(dataList)) {
      for (ImportantPersonRecordData recordData : dataList) {
        try {
          int count = importantPersonService.countImportantPerson(recordData.getIdCard());
          if (count == 1 && importantPersonService.saveImportantPersonRecord(
              CglibBeanUtil.copyProperties(recordData, ImportantPersonRecordModel.class)) == 1) {
            saveList.add(recordData.getRecordDate() == null ? ""
                : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getIdCard());
          } else {
            LOG.error("Record: {} is error!", recordData.getIdCard());
            failedList.add(recordData.getRecordDate() == null ? ""
                : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getIdCard());
          }
        } catch (Exception e) {
          LOG.error("Record: {} is error!", recordData.getIdCard());
          e.printStackTrace();
          failedList.add(recordData.getRecordDate() == null ? ""
              : DateUtil.format(recordData.getRecordDate()) + "|" + recordData.getIdCard());
        }
      }
    }
    return StringUtil.generateMap(saveList, updateList, failedList);
  }

  @Override
  public HSSFWorkbook exportImportantPerson(
      ImportantPersonPageQueryData importantPersonPageQueryData) {
    return importantPersonBuilder.fillPersonInfoBook(importantPersonService
        .listImportantPersonForPage(CglibBeanUtil
            .copyProperties(importantPersonPageQueryData, ImportantPersonPageQueryDTO.class)));
  }

  @Override
  public HSSFWorkbook exportImportantRecord(
      ImportantRecordPageQueryData importantRecordPageQueryData) {
    return importantPersonBuilder.fillPersonRecordBook(importantPersonService
        .listImportantRecordForPage(CglibBeanUtil
            .copyProperties(importantRecordPageQueryData, ImportantRecordPageQueryDTO.class))
        .getResult());
  }
}
