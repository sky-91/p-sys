package cn.qsky.policesys.facade.group.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.core.dao.model.GroupRecordModel;
import cn.qsky.policesys.core.dao.model.GroupSummaryModel;
import cn.qsky.policesys.facade.group.GroupBuilder;
import cn.qsky.policesys.facade.group.data.GroupRecordData;
import cn.qsky.policesys.facade.group.data.GroupSummaryData;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
        if (row.getCell(0) != null) {
          row.getCell(0).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
            group.setIndex(row.getCell(0).getStringCellValue());
          }
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
        if (row.getCell(3) != null) {
          row.getCell(3).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(3).getStringCellValue())) {
            record.setRecordDate(DateUtil.parse(row.getCell(3).getStringCellValue()));
          }
        }
        if (row.getCell(4) != null) {
          row.getCell(4).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(4).getStringCellValue())) {
            record.setPetitionLocation(row.getCell(4).getStringCellValue());
          }
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            record.setPetitionRegion(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(6) != null) {
          row.getCell(6).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(6).getStringCellValue())) {
            record.setInciteMethod(row.getCell(6).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            record.setInfoSources(row.getCell(7).getStringCellValue());
          }
        }
        if (row.getCell(8) != null) {
          row.getCell(8).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(8).getStringCellValue())) {
            record.setActionGroup(row.getCell(8).getStringCellValue());
          }
        }
        if (row.getCell(9) != null) {
          row.getCell(9).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(9).getStringCellValue())) {
            record.setGroupSize(Short.valueOf(row.getCell(9).getStringCellValue()));
          }
        }
        if (row.getCell(10) != null) {
          row.getCell(10).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(10).getStringCellValue())) {
            record.setPetitionDynamic(row.getCell(10).getStringCellValue());
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            record.setConfirm(row.getCell(11).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            record.setPetitionSituation(row.getCell(12).getStringCellValue());
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            record.setConsequence(row.getCell(13).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            record.setConseScore(Byte.valueOf(row.getCell(14).getStringCellValue()));
          }
        }
      } else {
        continue;
      }
      resultList.add(record);
    }
    return resultList;
  }

  /**
   * 指定年月日创建日期
   */
  private void createDate(GroupRecordData record, Row row) {
    row.getCell(3).setCellType(CellType.NUMERIC);
    row.getCell(4).setCellType(CellType.NUMERIC);
    row.getCell(5).setCellType(CellType.NUMERIC);
    record.setRecordDate(DateUtil
        .setPointDate((new Double(row.getCell(3).getNumericCellValue())).intValue(),
            (new Double(row.getCell(4).getNumericCellValue())).intValue(),
            (new Double(row.getCell(5).getNumericCellValue())).intValue()));
  }

  @Override
  public HSSFWorkbook fillSummaryBook(List<GroupSummaryModel> modelList) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("群体汇总");
    HSSFRow row = sheet.createRow(0);

    row.createCell(0).setCellValue("序号");
    row.createCell(1).setCellValue("群体名称");
    row.createCell(2).setCellValue("个体总分");
    row.createCell(3).setCellValue("群体总分");
    row.createCell(4).setCellValue("活跃度");
    row.createCell(5).setCellValue("群体类别");
    row.createCell(6).setCellValue("群体简介");
    if (CollectionUtils.isNotEmpty(modelList)) {
      for (int i = 0; i < modelList.size(); i++) {
        row = sheet.createRow(i + 1);
        GroupSummaryModel model = modelList.get(i);
        row.createCell(0).setCellValue(model.getExt1());
        row.createCell(1).setCellValue(model.getGroupName());
        row.createCell(2).setCellValue("");
        row.createCell(3).setCellValue("");
        row.createCell(4).setCellValue("");
        row.createCell(5).setCellValue(model.getGroupType());
        row.createCell(6).setCellValue(model.getGroupIntroduce());
      }
    }
    return wb;
  }

  @Override
  public HSSFWorkbook fillRecordBook(List<GroupRecordModel> modelList) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("群体轨迹");
    HSSFRow row = sheet.createRow(0);

    row.createCell(0).setCellValue("序号");
    row.createCell(1).setCellValue("总分");
    row.createCell(2).setCellValue("群体名称");
    row.createCell(3).setCellValue("日期");
    row.createCell(4).setCellValue("上访地点");
    row.createCell(5).setCellValue("所属区域");
    row.createCell(6).setCellValue("轨迹类型");
    row.createCell(7).setCellValue("信息来源");
    row.createCell(8).setCellValue("维权方式（QQ群、微信群）");
    row.createCell(9).setCellValue("规模等级（人数）");
    row.createCell(10).setCellValue("上访情况");
    row.createCell(11).setCellValue("是否落实");
    row.createCell(12).setCellValue("概述");
    row.createCell(13).setCellValue("是否造成后果");
    row.createCell(14).setCellValue("是否造成后果（分值）");
    if (CollectionUtils.isNotEmpty(modelList)) {
      for (int i = 0; i < modelList.size(); i++) {
        row = sheet.createRow(i + 1);
        GroupRecordModel model = modelList.get(i);
        row.createCell(0).setCellValue(model.getExt1());
        row.createCell(1).setCellValue(model.getScore());
        row.createCell(2).setCellValue(model.getGroupName());
        row.createCell(3).setCellValue(DateUtil.format(model.getRecordDate()));
        row.createCell(4).setCellValue(model.getPetitionLocation());
        row.createCell(5).setCellValue(model.getPetitionRegion());
        row.createCell(6).setCellValue(model.getInciteMethod());
        row.createCell(7).setCellValue(model.getInfoSources());
        row.createCell(8).setCellValue(model.getActionGroup());
        row.createCell(9).setCellValue(model.getGroupSize());
        row.createCell(10).setCellValue(model.getPetitionDynamic());
        row.createCell(11).setCellValue(model.getConfirm() ? "是" : "否");
        row.createCell(12).setCellValue(model.getPetitionSituation());
        row.createCell(13).setCellValue(model.getConsequence() ? "是" : "否");
        row.createCell(14).setCellValue(model.getConseScore());
      }
    }
    return wb;
  }
}
