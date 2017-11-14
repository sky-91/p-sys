package cn.qsky.policesys.web.security.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author qsky
 *
 * 用于rest权限未通过处理
 */
public class RestAccessDeniedHandler implements AccessDeniedHandler {

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException exception) throws IOException, ServletException {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
    response.getWriter().println("权限未通过处理");
  }
}

