package cn.qsky.policesys.facade.group.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.facade.group.GroupBuilder;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.ArrayList;
import java.util.List;
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
public class GroupBuilderImpl implements GroupBuilder {

  @Override
  public List<GroupSummaryData> buildSummaryList(Workbook workbook) {
    List<GroupSummaryData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      GroupSummaryData group = new GroupSummaryData();
      Row row = sheet.getRow(i);
      if (row.getCell(1) != null) {
        row.getCell(1).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(1).getStringCellValue())) {
          continue;
        } else {
          group.setGroupName(row.getCell(1).getStringCellValue());
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            group.setGroupType(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(6) != null) {
          row.getCell(6).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(6).getStringCellValue())) {
            group.setGroupIntroduce(row.getCell(6).getStringCellValue());
          }
        }
      } else {
        continue;
      }
      resultList.add(group);
    }
    return resultList;
  }

  @Override
  public List<GroupRecordData> buildRecordList(Workbook workbook) {
    List<GroupRecordData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      GroupRecordData record = new GroupRecordData();
      Row row = sheet.getRow(i);
      if (row.getCell(2) != null) {
        row.getCell(2).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(2).getStringCellValue())) {
          continue;
        } else {
          record.setGroupName(row.getCell(2).getStringCellValue());
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
            record.setPetitionLocation(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(6) != null) {
          row.getCell(6).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(6).getStringCellValue())) {
            record.setPetitionRegion(row.getCell(6).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            record.setInciteMethod(row.getCell(7).getStringCellValue());
          }
        }
        if (row.getCell(9) != null) {
          row.getCell(9).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(9).getStringCellValue())) {
            record.setInfoSources(row.getCell(9).getStringCellValue());
          }
        }
        if (row.getCell(10) != null) {
          row.getCell(10).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(10).getStringCellValue())) {
            record.setActionGroup(row.getCell(10).getStringCellValue());
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            record.setGroupSize(Short.valueOf(row.getCell(11).getStringCellValue()));
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            record.setPetitionDynamic(row.getCell(12).getStringCellValue());
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            record.setConfirm(row.getCell(13).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            record.setPetitionSituation(row.getCell(14).getStringCellValue());
          }
        }
        if (row.getCell(15) != null) {
          row.getCell(15).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(15).getStringCellValue())) {
            record.setConsequence(row.getCell(15).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(16) != null) {
          row.getCell(16).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(16).getStringCellValue())) {
            record.setConseScore(Byte.valueOf(row.getCell(16).getStringCellValue()));
          }
        }
      } else {
        continue;
      }
      resultList.add(record);
    }
    return resultList;
  }

  private void createDate(GroupRecordData record, Row row) {
    row.getCell(2).setCellType(CellType.NUMERIC);
    row.getCell(3).setCellType(CellType.NUMERIC);
    row.getCell(4).setCellType(CellType.NUMERIC);
    record.setRecordDate(DateUtil
        .setPointDate((new Double(row.getCell(2).getNumericCellValue())).intValue(),
            (new Double(row.getCell(3).getNumericCellValue())).intValue(),
            (new Double(row.getCell(4).getNumericCellValue())).intValue()));
  }
}
