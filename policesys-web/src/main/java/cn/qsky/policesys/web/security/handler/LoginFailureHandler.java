package cn.qsky.policesys.web.security.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * 登录失败处理类
 *
 * @author qsky
 */
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.getWriter().println("登录失败");
  }

}
