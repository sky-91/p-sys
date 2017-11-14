package cn.qsky.policesys.web.security.service;

import cn.qsky.policesys.core.dao.model.UserModel;
import cn.qsky.policesys.core.user.UserService;
import cn.qsky.policesys.web.security.userdetails.SecurityUser;
import javax.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @author qsky
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Resource
  private UserService userService;

  @Override
  public UserDetails loadUserByUsername(final String uid) {
    UserModel user = userService.getByUid(uid);
    if (user != null) {
      return new SecurityUser(user);
    } else {
      return null;
    }
  }
}
