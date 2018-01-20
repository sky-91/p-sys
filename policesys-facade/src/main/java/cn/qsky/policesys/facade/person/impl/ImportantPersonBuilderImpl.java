package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.facade.person.ImportantPersonBuilder;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
import cn.qsky.policesys.facade.person.data.PersonContactInfoData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

/**
 * @author qsky on 2018/1/20
 */
@Component
public class ImportantPersonBuilderImpl implements ImportantPersonBuilder {

  @Override
  public List<ImportantPersonInfoData> buildPersonInfoList(Workbook workbook) {
    List<ImportantPersonInfoData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      ImportantPersonInfoData person = new ImportantPersonInfoData();
      Row row = sheet.getRow(i);
      if (row.getCell(6) != null) {
        row.getCell(6).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(6).getStringCellValue())) {
          continue;
        } else {
          person.setIdCard(row.getCell(6).getStringCellValue());
        }
        if (row.getCell(0) != null) {
          row.getCell(0).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
            person.setIndex(row.getCell(0).getStringCellValue());
          }
        }
        if (row.getCell(4) != null) {
          row.getCell(4).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(4).getStringCellValue())) {
            person.setControllKeyword(row.getCell(4).getStringCellValue());
          }
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            person.setGroupType(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            person.setName(row.getCell(7).getStringCellValue());
          }
        }
        if (row.getCell(8) != null) {
          row.getCell(8).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(8).getStringCellValue())) {
            person.setMaritalStatus(row.getCell(8).getStringCellValue());
          }
        }
        if (row.getCell(9) != null) {
          row.getCell(9).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(9).getStringCellValue())) {
            person.setDomicile(row.getCell(9).getStringCellValue());
          }
        }
        if (row.getCell(10) != null) {
          row.getCell(10).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(10).getStringCellValue())) {
            person.setResidence(row.getCell(10).getStringCellValue());
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          List<PersonContactInfoData> contactList = splitContact(
              row.getCell(11).getStringCellValue(), true);
          if (CollectionUtils.isNotEmpty(contactList)) {
            person.setContacts(contactList);
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          List<PersonContactInfoData> contactList = splitContact(
              row.getCell(12).getStringCellValue(), false);
          if (CollectionUtils.isNotEmpty(contactList)) {
            if (CollectionUtils.isNotEmpty(person.getContacts())) {
              person.getContacts().addAll(contactList);
            } else {
              person.setContacts(contactList);
            }
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            person.setJurisdiction(row.getCell(13).getStringCellValue());
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            person.setJuriPolice(row.getCell(14).getStringCellValue());
          }
        }
        if (row.getCell(15) != null) {
          row.getCell(15).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(15).getStringCellValue())) {
            person.setSex(row.getCell(15).getStringCellValue().equals("男"));
          }
        }
        if (row.getCell(16) != null) {
          row.getCell(16).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(16).getStringCellValue())) {
            person.setNation(row.getCell(16).getStringCellValue());
          }
        }
        if (row.getCell(17) != null) {
          row.getCell(17).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(17).getStringCellValue())) {
            person.setAge(Byte.valueOf(row.getCell(17).getStringCellValue()));
          }
        }
        if (row.getCell(18) != null) {
          row.getCell(18).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(18).getStringCellValue())) {
            person.setEducation(row.getCell(18).getStringCellValue());
          }
        }
        if (row.getCell(19) != null) {
          row.getCell(19).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(19).getStringCellValue())) {
            person.setVeteranStatus(row.getCell(19).getStringCellValue());
          }
        }
        if (row.getCell(20) != null) {
          row.getCell(20).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(20).getStringCellValue())) {
            person.setJob(row.getCell(20).getStringCellValue());
          }
        }
        if (row.getCell(21) != null) {
          row.getCell(21).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(21).getStringCellValue())) {
            person.setWorkPlace(row.getCell(21).getStringCellValue());
          }
        }
        if (row.getCell(22) != null) {
          row.getCell(22).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(22).getStringCellValue())) {
            person.setWorkStatus(row.getCell(22).getStringCellValue());
          }
        }
        if (row.getCell(23) != null) {
          row.getCell(23).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(23).getStringCellValue())) {
            person.setControllReason(row.getCell(23).getStringCellValue());
          }
        }
        if (row.getCell(24) != null) {
          row.getCell(24).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(24).getStringCellValue())) {
            person.setRemark(row.getCell(24).getStringCellValue());
          }
        }
      } else {
        continue;
      }
      resultList.add(person);
    }
    return resultList;
  }

  private List<PersonContactInfoData> splitContact(String context, Boolean isPhone) {
    List<PersonContactInfoData> contactDataList = new ArrayList<>();
    if (StringUtils.isNotBlank(context)) {
      String[] contactArray = context.split("\\|");
      List<String> contactList = Arrays.asList(contactArray);
      for (String contact : contactList) {
        PersonContactInfoData contactData = new PersonContactInfoData();
        if (isPhone) {
          contactData.setPhone(contact);
        } else {
          contactData.setWechatName(contact);
        }
        contactDataList.add(contactData);
      }
    }
    return contactDataList;
  }

  @Override
  public List<ImportantPersonRecordData> buildPersonRecordList(Workbook workbook) {
    List<ImportantPersonRecordData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      ImportantPersonRecordData record = new ImportantPersonRecordData();
      Row row = sheet.getRow(i);
      if (row.getCell(8) != null) {
        row.getCell(8).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(8).getStringCellValue())) {
          continue;
        } else {
          record.setIdCard(row.getCell(8).getStringCellValue());
        }
        if (row.getCell(0) != null) {
          row.getCell(0).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
            record.setIndex(row.getCell(0).getStringCellValue());
          }
        }
        if (row.getCell(1) != null) {
          row.getCell(1).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(1).getStringCellValue())) {
            record.setScore(Byte.valueOf(row.getCell(1).getStringCellValue()));
          }
        }
        if (row.getCell(2) != null && row.getCell(3) != null && row.getCell(4) != null) {
          createDate(record, row);
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            record.setWeek(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(6) != null) {
          row.getCell(6).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(6).getStringCellValue())) {
            record.setGroupType(row.getCell(6).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            record.setName(row.getCell(7).getStringCellValue());
          }
        }
        if (row.getCell(9) != null) {
          row.getCell(9).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(9).getStringCellValue())) {
            record.setPetitionLocation(row.getCell(9).getStringCellValue());
          }
        }
        if (row.getCell(10) != null) {
          row.getCell(10).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(10).getStringCellValue())) {
            record.setPetitionRegion(row.getCell(10).getStringCellValue());
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            record.setPetitionDynamic(row.getCell(11).getStringCellValue());
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            record.setConfirm(row.getCell(12).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            record.setInciteMethod(row.getCell(13).getStringCellValue());
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            record.setInfoSources(row.getCell(14).getStringCellValue());
          }
        }
        if (row.getCell(15) != null) {
          row.getCell(15).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(15).getStringCellValue())) {
            record.setQqGroup(row.getCell(15).getStringCellValue());
          }
        }
        if (row.getCell(16) != null) {
          row.getCell(16).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(16).getStringCellValue())) {
            record.setWechatGroup(row.getCell(16).getStringCellValue());
          }
        }
        if (row.getCell(17) != null) {
          row.getCell(17).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(17).getStringCellValue())) {
            record.setGroupSize(Short.valueOf(row.getCell(17).getStringCellValue()));
          }
        }
        if (row.getCell(18) != null) {
          row.getCell(18).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(18).getStringCellValue())) {
            record.setConsequence(row.getCell(18).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(19) != null) {
          row.getCell(19).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(19).getStringCellValue())) {
            record.setConseScore(Byte.valueOf(row.getCell(19).getStringCellValue()));
          }
        }
        if (row.getCell(20) != null) {
          row.getCell(20).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(20).getStringCellValue())) {
            record.setPetitionSituation(row.getCell(20).getStringCellValue());
          }
        }
      } else {
        continue;
      }
      resultList.add(record);
    }
    return resultList;
  }

  private void createDate(ImportantPersonRecordData record, Row row) {
    row.getCell(2).setCellType(CellType.NUMERIC);
    row.getCell(3).setCellType(CellType.NUMERIC);
    row.getCell(4).setCellType(CellType.NUMERIC);
    record.setRecordDate(DateUtil
        .setPointDate((new Double(row.getCell(2).getNumericCellValue())).intValue(),
            (new Double(row.getCell(3).getNumericCellValue())).intValue(),
            (new Double(row.getCell(4).getNumericCellValue())).intValue()));
  }
}
