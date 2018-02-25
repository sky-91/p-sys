package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.core.dao.model.SpecialPersonModel;
import cn.qsky.policesys.facade.person.SpecialPersonBuilder;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
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
 * @author qsky on 18/1/3
 */
@Component
public class SpecialPersonBuilderImpl implements SpecialPersonBuilder {

  @Override
  public List<SpecialPersonData> buildPersonList(Workbook workbook) {
    List<SpecialPersonData> resultList = new ArrayList<>(16);
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      SpecialPersonData person = new SpecialPersonData();
      Row row = sheet.getRow(i);
      if (row.getCell(4) != null) {
        row.getCell(4).setCellType(CellType.STRING);
        if (StringUtils.isBlank(row.getCell(4).getStringCellValue())) {
          continue;
        } else {
          person.setIdCard(row.getCell(4).getStringCellValue());
        }
        if (row.getCell(0) != null) {
          row.getCell(0).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(0).getStringCellValue())) {
            person.setIndex(row.getCell(0).getStringCellValue());
          }
        }
        if (row.getCell(1) != null) {
          row.getCell(1).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(1).getStringCellValue())) {
            person.setJurisdiction(row.getCell(1).getStringCellValue());
          }
        }
        if (row.getCell(2) != null) {
          row.getCell(2).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(2).getStringCellValue())) {
            person.setResourceName(row.getCell(2).getStringCellValue());
          }
        }
        if (row.getCell(3) != null) {
          row.getCell(3).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(3).getStringCellValue())) {
            person.setName(row.getCell(3).getStringCellValue());
          }
        }
        if (row.getCell(5) != null) {
          row.getCell(5).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(5).getStringCellValue())) {
            person.setActivityPlace(row.getCell(5).getStringCellValue());
          }
        }
        if (row.getCell(6) != null) {
          row.getCell(6).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(6).getStringCellValue())) {
            person.setActivityPlaceDetail(row.getCell(6).getStringCellValue());
          }
        }
        if (row.getCell(7) != null) {
          row.getCell(7).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(7).getStringCellValue())) {
            person.setActivityTime(DateUtil
                .parse(row.getCell(7).getStringCellValue(), DateUtil.DATETIME_FORMAT_PATTERN));
          }
        }
        if (row.getCell(8) != null) {
          row.getCell(8).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(8).getStringCellValue())) {
            person.setPushTime(DateUtil.parse(row.getCell(8).getStringCellValue()));
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
            person.setNation(row.getCell(10).getStringCellValue());
          }
        }
        if (row.getCell(11) != null) {
          row.getCell(11).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(11).getStringCellValue())) {
            person.setStayInternetSite(row.getCell(11).getStringCellValue());
          }
        }
        if (row.getCell(12) != null) {
          row.getCell(12).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(12).getStringCellValue())) {
            person.setTjTimeReason(row.getCell(12).getStringCellValue());
          }
        }
        if (row.getCell(13) != null) {
          row.getCell(13).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(13).getStringCellValue())) {
            person.setVehicle(row.getCell(13).getStringCellValue());
          }
        }
        if (row.getCell(14) != null) {
          row.getCell(14).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(14).getStringCellValue())) {
            person.setTjStaySite(row.getCell(14).getStringCellValue());
          }
        }
        if (row.getCell(15) != null) {
          row.getCell(15).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(15).getStringCellValue())) {
            person.setTjContact(row.getCell(15).getStringCellValue());
          }
        }
        if (row.getCell(16) != null) {
          row.getCell(16).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(16).getStringCellValue())) {
            person.setBelongings(row.getCell(16).getStringCellValue());
          }
        }
        if (row.getCell(17) != null) {
          row.getCell(17).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(17).getStringCellValue())) {
            person.setPhone(row.getCell(17).getStringCellValue());
          }
        }
        if (row.getCell(18) != null) {
          row.getCell(18).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(18).getStringCellValue())) {
            person.setVirtualIdentity(row.getCell(18).getStringCellValue());
          }
        }
        if (row.getCell(19) != null) {
          row.getCell(19).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(19).getStringCellValue())) {
            person.setPeerStaff(row.getCell(19).getStringCellValue());
          }
        }
        if (row.getCell(20) != null) {
          row.getCell(20).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(20).getStringCellValue())) {
            person.setStayStaff(row.getCell(20).getStringCellValue());
          }
        }
        if (row.getCell(21) != null) {
          row.getCell(21).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(21).getStringCellValue())) {
            person.setCarNum(row.getCell(21).getStringCellValue());
          }
        }
        if (row.getCell(22) != null) {
          row.getCell(22).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(22).getStringCellValue())) {
            person.setTerroristChar(row.getCell(22).getStringCellValue());
          }
        }
        if (row.getCell(23) != null) {
          row.getCell(23).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(23).getStringCellValue())) {
            person.setControlType(row.getCell(23).getStringCellValue());
          }
        }
        if (row.getCell(24) != null) {
          row.getCell(24).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(24).getStringCellValue())) {
            person.setCheckSite(row.getCell(24).getStringCellValue());
          }
        }
        if (row.getCell(25) != null) {
          row.getCell(25).setCellType(CellType.STRING);
          if (StringUtils.isNotBlank(row.getCell(25).getStringCellValue())) {
            person.setCheckPolice(row.getCell(25).getStringCellValue());
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
  public HSSFWorkbook fillSpecialPersonBook(List<SpecialPersonModel> personList) {
    HSSFWorkbook wb = new HSSFWorkbook();
    HSSFSheet sheet = wb.createSheet("疆藏人员");
    HSSFRow row = sheet.createRow(0);

    row.createCell(0).setCellValue("序号");
    row.createCell(1).setCellValue("管辖单位");
    row.createCell(2).setCellValue("资源名");
    row.createCell(3).setCellValue("姓名");
    row.createCell(4).setCellValue("身份证号");
    row.createCell(5).setCellValue("活动场所");
    row.createCell(6).setCellValue("活动场所详址");
    row.createCell(7).setCellValue("活动时间");
    row.createCell(8).setCellValue("推送时间");
    row.createCell(9).setCellValue("户籍地");
    row.createCell(10).setCellValue("民族");
    row.createCell(11).setCellValue("住宿（上网）地点");
    row.createCell(12).setCellValue("来津时间及事由");
    row.createCell(13).setCellValue("来津方式");
    row.createCell(14).setCellValue("在津住地");
    row.createCell(15).setCellValue("来津联系人");
    row.createCell(16).setCellValue("随身物品");
    row.createCell(17).setCellValue("手机号码");
    row.createCell(18).setCellValue("虚拟身份");
    row.createCell(19).setCellValue("同行人员");
    row.createCell(20).setCellValue("同住（同上网）人员");
    row.createCell(21).setCellValue("驾乘车辆号牌");
    row.createCell(22).setCellValue("有无涉恐表象特征");
    row.createCell(23).setCellValue("重点人列控类型");
    row.createCell(24).setCellValue("核查地点");
    row.createCell(25).setCellValue("见面核查民警");
    if (CollectionUtils.isNotEmpty(personList)) {
      for (int i = 0; i < personList.size(); i++) {
        row = sheet.createRow(i + 1);
        SpecialPersonModel model = personList.get(i);
        row.createCell(0).setCellValue(model.getExt1());
        row.createCell(1).setCellValue(model.getJurisdiction());
        row.createCell(2).setCellValue(model.getResourceName());
        row.createCell(3).setCellValue(model.getName());
        row.createCell(4).setCellValue(model.getIdCard());
        row.createCell(5).setCellValue(model.getActivityPlace());
        row.createCell(6).setCellValue(model.getActivityPlaceDetail());
        row.createCell(7).setCellValue(
            DateUtil.format(model.getActivityTime(), DateUtil.DATETIME_FORMAT_PATTERN));
        row.createCell(8).setCellValue(DateUtil.format(model.getPushTime()));
        row.createCell(9).setCellValue(model.getDomicile());
        row.createCell(10).setCellValue(model.getNation());
        row.createCell(11).setCellValue(model.getStayInternetSite());
        row.createCell(12).setCellValue(model.getTjTimeReason());
        row.createCell(13).setCellValue(model.getVehicle());
        row.createCell(14).setCellValue(model.getTjStaySite());
        row.createCell(15).setCellValue(model.getTjContact());
        row.createCell(16).setCellValue(model.getBelongings());
        row.createCell(17).setCellValue(model.getPhone());
        row.createCell(18).setCellValue(model.getVirtualIdentity());
        row.createCell(19).setCellValue(model.getPeerStaff());
        row.createCell(20).setCellValue(model.getStayStaff());
        row.createCell(21).setCellValue(model.getCarNum());
        row.createCell(22).setCellValue(model.getTerroristChar());
        row.createCell(23).setCellValue(model.getControlType());
        row.createCell(24).setCellValue(model.getCheckSite());
        row.createCell(25).setCellValue(model.getCheckPolice());
      }
    }
    return wb;
  }
}
