package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.core.dao.model.ImportantPersonInfoModel;
import cn.qsky.policesys.core.dao.model.ImportantPersonRecordModel;
import cn.qsky.policesys.facade.person.ImportantPersonBuilder;
import cn.qsky.policesys.facade.person.data.ImportantPersonInfoData;
import cn.qsky.policesys.facade.person.data.ImportantPersonRecordData;
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
            person.setExt1(row.getCell(0).getStringCellValue());
          }
        }
        if (row.getCell(4) != null) {
          row.getCell(4).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(4).getStringCellValue())) {
            person.setControlKeyword(row.getCell(4).getStringCellValue());
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
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            person.setPhoneText(row.getCell(11).getStringCellValue());
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            person.setWechatNameText(row.getCell(12).getStringCellValue());
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
            person.setControlReason(row.getCell(23).getStringCellValue());
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

  @Override
  public List<ImportantPersonRecordData> buildPersonRecordList(Workbook workbook) {
    List<ImportantPersonRecordData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      ImportantPersonRecordData record = new ImportantPersonRecordData();
      Row row = sheet.getRow(i);
      if (row.getCell(6) != null) {
        row.getCell(6).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(6).getStringCellValue())) {
          continue;
        } else {
          record.setIdCard(row.getCell(6).getStringCellValue());
        }
        if (row.getCell(0) != null) {
          row.getCell(0).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
            record.setExt1(row.getCell(0).getStringCellValue());
          }
        }
        if (row.getCell(1) != null) {
          row.getCell(1).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(1).getStringCellValue())) {
            record.setScore(Byte.valueOf(row.getCell(1).getStringCellValue()));
          }
        }
        if (row.getCell(2) != null) {
          row.getCell(2).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(2).getStringCellValue())) {
            record.setRecordDate(DateUtil.parse(row.getCell(2).getStringCellValue()));
          }
        }
        if (row.getCell(3) != null) {
          row.getCell(3).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(3).getStringCellValue())) {
            record.setWeek(row.getCell(3).getStringCellValue());
          }
        }
        if (row.getCell(4) != null) {
          row.getCell(4).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(4).getStringCellValue())) {
            record.setGroupType(row.getCell(4).getStringCellValue());
          }
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            record.setName(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            record.setPetitionLocation(row.getCell(7).getStringCellValue());
          }
        }
        if (row.getCell(8) != null) {
          row.getCell(8).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(8).getStringCellValue())) {
            record.setPetitionRegion(row.getCell(8).getStringCellValue());
          }
        }
        if (row.getCell(9) != null) {
          row.getCell(9).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(9).getStringCellValue())) {
            record.setPetitionDynamic(row.getCell(9).getStringCellValue());
          }
        }
        if (row.getCell(10) != null) {
          row.getCell(10).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(10).getStringCellValue())) {
            record.setConfirm(row.getCell(10).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            record.setInciteMethod(row.getCell(11).getStringCellValue());
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            record.setInfoSources(row.getCell(12).getStringCellValue());
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            record.setQqGroup(row.getCell(13).getStringCellValue());
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            record.setWechatGroup(row.getCell(14).getStringCellValue());
          }
        }
        if (row.getCell(15) != null) {
          row.getCell(15).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(15).getStringCellValue())) {
            record.setGroupSize(Short.valueOf(row.getCell(15).getStringCellValue()));
          }
        }
        if (row.getCell(16) != null) {
          row.getCell(16).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(16).getStringCellValue())) {
            record.setConsequence(row.getCell(16).getStringCellValue().equals("是"));
          }
        }
        if (row.getCell(17) != null) {
          row.getCell(17).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(17).getStringCellValue())) {
            record.setConseScore(Byte.valueOf(row.getCell(17).getStringCellValue()));
          }
        }
        if (row.getCell(18) != null) {
          row.getCell(18).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(18).getStringCellValue())) {
            record.setPetitionSituation(row.getCell(18).getStringCellValue());
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

  @Override
  public HSSFWorkbook fillPersonInfoBook(List<ImportantPersonInfoModel> personList) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("重点人员");
    HSSFRow row = sheet.createRow(0);

    row.createCell(0).setCellValue("序号");
    row.createCell(1).setCellValue("个人总分");
    row.createCell(2).setCellValue("总分");
    row.createCell(3).setCellValue("活跃度");
    row.createCell(4).setCellValue("列控关键字");
    row.createCell(5).setCellValue("群体类别");
    row.createCell(6).setCellValue("身份证号码");
    row.createCell(7).setCellValue("姓名");
    row.createCell(8).setCellValue("婚姻状况");
    row.createCell(9).setCellValue("户籍地");
    row.createCell(10).setCellValue("现住地");
    row.createCell(11).setCellValue("联系方式");
    row.createCell(12).setCellValue("手机绑定微信名称");
    row.createCell(13).setCellValue("管辖单位");
    row.createCell(14).setCellValue("管辖派出所");
    row.createCell(15).setCellValue("性别");
    row.createCell(16).setCellValue("民族");
    row.createCell(17).setCellValue("年龄");
    row.createCell(18).setCellValue("学历");
    row.createCell(19).setCellValue("兵役状况");
    row.createCell(20).setCellValue("职业");
    row.createCell(21).setCellValue("服务处所");
    row.createCell(22).setCellValue("工作状态");
    row.createCell(23).setCellValue("列控事由");
    row.createCell(24).setCellValue("备注");
    if (CollectionUtils.isNotEmpty(personList)) {
      for (int i = 0; i < personList.size(); i++) {
        row = sheet.createRow(i + 1);
        ImportantPersonInfoModel model = personList.get(i);
        row.createCell(0).setCellValue(model.getExt1() == null ? "" : model.getExt1());
        row.createCell(1).setCellValue("");
        row.createCell(2).setCellValue("");
        row.createCell(3).setCellValue("");
        row.createCell(4)
            .setCellValue(model.getControlKeyword() == null ? "" : model.getControlKeyword());
        row.createCell(5).setCellValue(model.getGroupType() == null ? "" : model.getGroupType());
        row.createCell(6).setCellValue(model.getIdCard() == null ? "" : model.getIdCard());
        row.createCell(7).setCellValue(model.getName() == null ? "" : model.getName());
        row.createCell(8)
            .setCellValue(model.getMaritalStatus() == null ? "" : model.getMaritalStatus());
        row.createCell(9).setCellValue(model.getDomicile() == null ? "" : model.getDomicile());
        row.createCell(10).setCellValue(model.getResidence() == null ? "" : model.getResidence());
        row.createCell(11).setCellValue(model.getPhoneText() == null ? "" : model.getPhoneText());
        row.createCell(12)
            .setCellValue(model.getWechatNameText() == null ? "" : model.getWechatNameText());
        row.createCell(13)
            .setCellValue(model.getJurisdiction() == null ? "" : model.getJurisdiction());
        row.createCell(14).setCellValue(model.getJuriPolice() == null ? "" : model.getJuriPolice());
        row.createCell(15).setCellValue(model.getSex() == null ? "" : model.getSex() ? "男" : "女");
        row.createCell(16).setCellValue(model.getNation() == null ? "" : model.getNation());
        row.createCell(17).setCellValue(model.getAge() == null ? 0 : model.getAge());
        row.createCell(18).setCellValue(model.getEducation() == null ? "" : model.getEducation());
        row.createCell(19)
            .setCellValue(model.getVeteranStatus() == null ? "" : model.getVeteranStatus());
        row.createCell(20).setCellValue(model.getJob() == null ? "" : model.getJob());
        row.createCell(21).setCellValue(model.getWorkPlace() == null ? "" : model.getWorkPlace());
        row.createCell(22).setCellValue(model.getWorkStatus() == null ? "" : model.getWorkStatus());
        row.createCell(23)
            .setCellValue(model.getControlReason() == null ? "" : model.getControlReason());
        row.createCell(24).setCellValue(model.getRemark() == null ? "" : model.getRemark());
      }
    }
    return wb;
  }

  @Override
  public HSSFWorkbook fillPersonRecordBook(List<ImportantPersonRecordModel> modelList) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("轨迹积分");
    HSSFRow row = sheet.createRow(0);

    row.createCell(0).setCellValue("序号");
    row.createCell(1).setCellValue("总分");
    row.createCell(2).setCellValue("日期");
    row.createCell(3).setCellValue("星期");
    row.createCell(4).setCellValue("群体类别");
    row.createCell(5).setCellValue("姓名");
    row.createCell(6).setCellValue("身份证号");
    row.createCell(7).setCellValue("上访地点");
    row.createCell(8).setCellValue("上访区域");
    row.createCell(9).setCellValue("上访动态");
    row.createCell(10).setCellValue("是否落实");
    row.createCell(11).setCellValue("轨迹类型");
    row.createCell(12).setCellValue("信息来源");
    row.createCell(13).setCellValue("QQ群号");
    row.createCell(14).setCellValue("微信群名");
    row.createCell(15).setCellValue("规模等级（人数）");
    row.createCell(16).setCellValue("是否造成后果");
    row.createCell(17).setCellValue("是否造成后果（分值）");
    row.createCell(18).setCellValue("上访情况简介");
    if (CollectionUtils.isNotEmpty(modelList)) {
      for (int i = 0; i < modelList.size(); i++) {
        row = sheet.createRow(i + 1);
        ImportantPersonRecordModel model = modelList.get(i);
        row.createCell(0).setCellValue(model.getExt1() == null ? "" : model.getExt1());
        row.createCell(1).setCellValue(model.getScore() == null ? 0 : model.getScore());
        row.createCell(2).setCellValue(
            model.getRecordDate() == null ? "" : DateUtil.format(model.getRecordDate()));
        row.createCell(3).setCellValue(model.getWeek() == null ? "" : model.getWeek());
        row.createCell(4).setCellValue(model.getGroupType() == null ? "" : model.getGroupType());
        row.createCell(5).setCellValue(model.getName() == null ? "" : model.getName());
        row.createCell(6).setCellValue(model.getIdCard() == null ? "" : model.getIdCard());
        row.createCell(7)
            .setCellValue(model.getPetitionLocation() == null ? "" : model.getPetitionLocation());
        row.createCell(8)
            .setCellValue(model.getPetitionRegion() == null ? "" : model.getPetitionRegion());
        row.createCell(9)
            .setCellValue(model.getPetitionDynamic() == null ? "" : model.getPetitionDynamic());
        row.createCell(10)
            .setCellValue(model.getConfirm() == null ? "" : model.getConfirm() ? "是" : "否");
        row.createCell(11)
            .setCellValue(model.getInciteMethod() == null ? "" : model.getInciteMethod());
        row.createCell(12)
            .setCellValue(model.getInfoSources() == null ? "" : model.getInfoSources());
        row.createCell(13).setCellValue(model.getQqGroup() == null ? "" : model.getQqGroup());
        row.createCell(14)
            .setCellValue(model.getWechatGroup() == null ? "" : model.getWechatGroup());
        row.createCell(15).setCellValue(model.getGroupSize() == null ? 0 : model.getGroupSize());
        row.createCell(16)
            .setCellValue(model.getConsequence() == null ? "" : model.getConsequence() ? "是" : "否");
        row.createCell(17).setCellValue(model.getConseScore() == null ? 0 : model.getConseScore());
        row.createCell(18)
            .setCellValue(model.getPetitionSituation() == null ? "" : model.getPetitionSituation());
      }
    }
    return wb;
  }
}
