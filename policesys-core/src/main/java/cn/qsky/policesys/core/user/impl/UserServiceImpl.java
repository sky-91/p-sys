package cn.qsky.policesys.core.user.impl;

import cn.qsky.policesys.core.dao.mapper.UserMapper;
import cn.qsky.policesys.core.dao.model.UserModel;
import cn.qsky.policesys.core.dao.model.UserModelExample;
import cn.qsky.policesys.core.user.UserService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author qsky 用户信息实现类
 */
@Service
public class UserServiceImpl implements UserService {

  @Resource
  private UserMapper userMapper;

  @Override
  public UserModel getByUid(final String uid) {
    UserModelExample example = new UserModelExample();
    example.or().andUserIdEqualTo(uid);
    List<UserModel> users = userMapper.selectByExample(example);
    return users.isEmpty() ? null : users.get(0);
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
