package cn.qsky.policesys.core.user;

import cn.qsky.policesys.core.dao.model.RoleModel;
import cn.qsky.policesys.core.dao.model.UserModel;

/**
 * @author qsky 用户信息接口
 */
public interface UserService {

  /**
   * 通过userId获取用户信息
   *
   * @param userId userId
   * @return UserModel
   */
  UserModel getByUid(String userId);

  /**
   * 通过roleId获取角色信息，包含权限信息
   *
   * @param roleId roleId
   * @return RoleModel
   */
  RoleModel getRole(String roleId);

  int updatePassword(final UserModel userModel);

  int insert(final UserModel record);
}
