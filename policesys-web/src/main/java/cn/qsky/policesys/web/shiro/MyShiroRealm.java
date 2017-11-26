package cn.qsky.policesys.web.shiro;

import cn.qsky.policesys.facade.user.UserFacade;
import cn.qsky.policesys.facade.user.data.RoleData;
import cn.qsky.policesys.facade.user.data.UserData;
import javax.annotation.Resource;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author qsky on 17/11/21
 */
public class MyShiroRealm extends AuthorizingRealm {

  private Logger LOG = LoggerFactory.getLogger(MyShiroRealm.class);

  @Resource
  private UserFacade userFacade;

  /**
   * 授权
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    UserData userData = (UserData) principalCollection.getPrimaryPrincipal();
    for (RoleData roleData : userData.getRoleList()) {
      authorizationInfo.addRole(roleData.getRoleId());
      userFacade.getRoleById(roleData.getRoleId()).getPermissionList().forEach(
          permissionData -> authorizationInfo.addStringPermission(permissionData.getPermission()));
    }
    return authorizationInfo;
  }

  /**
   * 登录验证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
      throws AuthenticationException {
    UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    //获取用户的输入的账号.
    String userId = token.getUsername();
    LOG.debug("Login userId : {}", userId);
    //通过username从数据库中查找 User对象.
    //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
    UserData userData = userFacade.getUserInfoById(userId);
    if (userData == null) {
      LOG.error("User : {} not exist!", userId);
      throw new UnknownAccountException("User not exist!");
    } else if (userData.getDeleteFlag()) {
      throw new LockedAccountException("Account is locked");
    }
    return new SimpleAuthenticationInfo(userData, userData.getPassword(), getName());
  }
}
