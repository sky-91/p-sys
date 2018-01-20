package cn.qsky.policesys.facade.person.impl;

import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.facade.person.SpecialPersonBuilder;
import cn.qsky.policesys.facade.person.data.SpecialPersonData;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
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
}
