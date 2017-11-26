package cn.qsky.policesys.core.user.impl;

import cn.qsky.policesys.core.dao.mapper.RoleMapper;
import cn.qsky.policesys.core.dao.mapper.UserMapper;
import cn.qsky.policesys.core.dao.model.RoleModel;
import cn.qsky.policesys.core.dao.model.UserModel;
import cn.qsky.policesys.core.dao.model.UserModelExample;
import cn.qsky.policesys.core.user.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author qsky 用户信息实现类
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserMapper userMapper;

  @Resource
  private RoleMapper roleMapper;

  @Override
  public UserModel getByUid(final String userId) {
    return userMapper.getUser(userId);
  }

  @Override
  public RoleModel getRole(String roleId) {
    return roleMapper.getRole(roleId);
  }

  @Override
  public int insert(final UserModel record) {
    return userMapper.insert(record);
  }

  @Override
  public int updatePassword(final UserModel record) {
    UserModelExample example = new UserModelExample();
    example.or().andUserIdEqualTo(record.getUserId());
    return userMapper.updateByExample(record, example);
  }
}
