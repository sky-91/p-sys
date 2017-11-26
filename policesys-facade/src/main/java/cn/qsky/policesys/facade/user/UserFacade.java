package cn.qsky.policesys.facade.user;

import cn.qsky.policesys.facade.user.data.RoleData;
import cn.qsky.policesys.facade.user.data.UserData;
import org.apache.poi.ss.usermodel.Workbook;


/**
 * @author qsky
 */
public interface UserFacade {

  /**
   * 保存user对象
   *
   * @param userData userData
   * @return DemoUser主键列
   */
  int saveDemoUser(UserData userData);

  /**
   * 获取用户
   *
   * @param userId uid
   * @return UserData
   */
  UserData getUserInfoById(final String userId);

  /**
   * 获取角色
   *
   * @param roleId roleId
   * @return RoleData
   */
  RoleData getRoleById(final String roleId);

  /**
   * excel导入用户
   *
   * @param workbook excel表格
   * @return Boolean
   */
  Boolean importUser(final Workbook workbook);
}
