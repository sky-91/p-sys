package cn.qsky.policesys.web.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.web.servlet.AdviceFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qsky on 2018/3/18
 */
@Component
public class MyAdviceFilter extends AdviceFilter {

  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletRequest httpRequest = WebUtils.toHttp(request);
    HttpServletResponse httpResponse = WebUtils.toHttp(response);
    if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
      httpResponse.setHeader("Access-control-Allow-Origin", httpRequest.getHeader("Origin"));
      httpResponse.setHeader("Access-Control-Allow-Methods", httpRequest.getMethod());
      httpResponse.setHeader("Access-Control-Allow-Headers",
          httpRequest.getHeader("Access-Control-Request-Headers"));
      httpResponse.setStatus(HttpStatus.OK.value());
      return false;
    }
    return super.preHandle(request, response);
  }
}
