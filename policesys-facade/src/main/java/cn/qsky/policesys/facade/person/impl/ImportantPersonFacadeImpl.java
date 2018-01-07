package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.data.PageData;
import cn.qsky.policesys.common.data.PageDataConverter;
import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.core.dto.ImportantPersonPageQueryDTO;
import cn.qsky.policesys.core.person.ImportantPersonService;
import cn.qsky.policesys.facade.person.ImportantPersonFacade;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonPageQueryData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

/**
 * @author qsky on 17/12/6
 */
@Component
public class ImportantPersonFacadeImpl implements ImportantPersonFacade {

  @Resource
  private ImportantPersonService importantPersonService;

  @Override
  public ImportantPersonInfoData getImportantPersonInfo(String idCard) {
    return CglibBeanUtil.copyProperties(importantPersonService.getImportantPersonInfo(idCard),
        ImportantPersonInfoData.class);
  }

  @Override
  public Boolean saveImportantPersonInfo(ImportantPersonInfoData importantPersonInfoData) {
    List<ImportantPersonRecordData> recordDataList = importantPersonInfoData.getRecords();
    if (importantPersonService
        .saveImportantPersonInfo(CglibBeanUtil.copyProperties(importantPersonInfoData,
            ImportantPersonInfoModel.class)) == 1) {
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
  public Boolean updateImportantPersonInfo(ImportantPersonInfoData importantPersonInfoData) {
    List<ImportantPersonRecordData> recordDataList = importantPersonInfoData.getRecords();
    if (importantPersonService
        .updateImportantPersonInfo(CglibBeanUtil.copyProperties(importantPersonInfoData,
            ImportantPersonInfoModel.class)) == 1) {
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
}
