package cn.qsky.policesys.core.dao.mapper;

import cn.qsky.policesys.core.dao.MybatisBaseRepository;
import cn.qsky.policesys.core.dao.model.UserModel;
import cn.qsky.policesys.core.dao.model.UserModelExample;

public interface UserMapper extends MybatisBaseRepository<UserModel, Long, UserModelExample> {

  /**
   * 根据用户ID取用户model，包含角色信息
   *
   * @param userId 用户ID
   * @return UserModel
   */
  UserModel getUser(final String userId);
}