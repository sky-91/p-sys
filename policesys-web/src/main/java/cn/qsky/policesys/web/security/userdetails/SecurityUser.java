package cn.qsky.policesys.web.security.userdetails;

import cn.qsky.policesys.core.dao.model.UserModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author qsky
 */
public class SecurityUser implements UserDetails, Serializable {

  private static Logger LOG = LoggerFactory.getLogger(SecurityUser.class);


  private String username;

  private String password;

  private String userdesc;

  public SecurityUser(UserModel user) {
    this.username = user.getUserId();
    this.password = user.getPassword();
    this.userdesc = user.getUserName();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    LOG.debug("用户" + this.getUsername());
    return grantedAuthorities;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  public String getUserdesc() {
    return this.userdesc;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
