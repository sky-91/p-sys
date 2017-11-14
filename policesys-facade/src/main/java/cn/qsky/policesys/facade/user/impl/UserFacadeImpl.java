package cn.qsky.policesys.facade.user.impl;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.common.util.DateUtil;
import cn.qsky.policesys.core.dao.model.UserModel;
import cn.qsky.policesys.core.user.UserService;
import cn.qsky.policesys.facade.user.UserFacade;
import cn.qsky.policesys.facade.user.data.UserData;
import javax.annotation.Resource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author qsky
 */
@Component
public class UserFacadeImpl implements UserFacade {

  private static Logger LOG = LoggerFactory.getLogger(UserFacadeImpl.class);

  @Resource
  private UserService userService;

  @Override
  public int saveDemoUser(UserData userData) {
    UserModel userModel = new UserModel();
    CglibBeanUtil.copyProperties(userData, userModel);
    userModel.setCreatedTime(DateUtil.getCurrentDate());
    userModel.setModifiedTime(DateUtil.getCurrentDate());
    return userService.insert(userModel);
  }

  @Override
  public UserData getUserInfoById(String uid) {
    return CglibBeanUtil.copyProperties(userService.getByUid(uid), UserData.class);
  }

  @Override
  @Transactional(rollbackFor = Exception.class)
  public Boolean importUser(Workbook workbook) {
    Sheet sheet = workbook.getSheetAt(0);
    for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
      UserData userData = new UserData();
      Row row = sheet.getRow(i);
      if (row.getCell(0) != null) {
        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
        userData.setUserId(row.getCell(0).getStringCellValue());
      } else {
        userData.setUserId("");
      }
      if (row.getCell(0) != null) {
        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
        userData.setUserId(row.getCell(0).getStringCellValue());
      } else {
        userData.setUserId("");
      }
      if (row.getCell(1) != null) {
        row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
        userData.setUserName(row.getCell(1).getStringCellValue());
      } else {
        userData.setUserName("");
      }
      if (row.getCell(2) != null) {
        row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
        userData.setPassword(row.getCell(2).getStringCellValue());
      } else {
        userData.setPassword("");
      }
      if (row.getCell(3) != null) {
        row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
        userData.setPhone(row.getCell(3).getStringCellValue());
      } else {
        userData.setPhone("");
      }
      if (row.getCell(4) != null) {
        row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
        userData.setIdCard(row.getCell(4).getStringCellValue());
      } else {
        userData.setIdCard("");
      }
      if (userService.insert(CglibBeanUtil.copyProperties(userData, UserModel.class)) == 0) {
        LOG.error("User {} save failed!", userData.getUserId());
      }
    }
    return true;
  }
}
