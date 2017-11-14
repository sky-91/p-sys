package cn.qsky.policesys.web.security.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 * 登录成功处理类
 *
 * @author qsky
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  //private static Logger LOG = LoggerFactory.getLogger(LoginSuccessHandler.class);

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    // 获得租户信息
    String tenantId = request.getParameter("tenantId");
    request.getSession().setAttribute("tenantId", tenantId);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().println("登录成功");
    clearAuthenticationAttributes(request);
  }

  public String getIpAddress(HttpServletRequest request) {
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("HTTP_CLIENT_IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }
    return ip;
  }
}