package cn.qsky.policesys.web.security.handler;

import cn.qsky.policesys.web.security.userdetails.SecurityUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

/**
 * 注销成功处理类
 *
 * @author qsky
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

  private static Logger LOG = LoggerFactory.getLogger(LogoutSuccessHandler.class);

  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // 获得授权后可得到用户信息
    SecurityUser userDetails = (SecurityUser) authentication.getPrincipal();
    LOG.info("管理员 {} 登出系统", userDetails.getUsername());
    return;
  }
}