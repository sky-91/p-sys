package cn.qsky.policesys.web.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author qsky
 */
public class UserNotFoundException extends AuthenticationException {

  private String msg;

  public UserNotFoundException(String msg) {
    super(msg);
    this.msg = msg;
  }

  @Override
  public String getMessage() {
    return msg;
  }
}
