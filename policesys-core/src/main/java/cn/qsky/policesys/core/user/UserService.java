package cn.qsky.policesys.core.user;

import cn.qsky.policesys.core.dao.model.UserModel;

/**
 * @author qsky 用户信息接口
 */
public interface UserService {

  /**
   * 通过uid获取用户信息
   */
  UserModel getByUid(String uid);

  int updatePassword(final UserModel userModel);

  int insert(final UserModel record);
}
