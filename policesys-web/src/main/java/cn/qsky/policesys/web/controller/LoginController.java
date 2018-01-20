package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.Md5Util;
import cn.qsky.policesys.facade.user.UserFacade;
import cn.qsky.policesys.facade.user.data.UserData;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author qsky on 17/11/22
 */
@RequestMapping("")
@Controller
public class LoginController {

  private Logger LOG = LoggerFactory.getLogger(LoginController.class);

  @Resource
  private UserFacade userFacade;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    return new ModelAndView("/login");
  }

  @RequestMapping(value = "/login/submit", method = RequestMethod.POST)
  public @ResponseBody
  Map<String, Object> submit(String username, String password) {
    LOG.debug("{}, {}", username, password);
    UsernamePasswordToken token = new UsernamePasswordToken(username,
        Md5Util.encoderByMd5(password));
    Subject subject = SecurityUtils.getSubject();
    Map<String, Object> result = new HashMap<>(2);
    try {
      subject.login(token);
      UserData user = userFacade.getUserInfoById(username);
      subject.getSession().setAttribute("user", user);
      result.put("success", true);
      result.put("message", "登陆成功!");
    } catch (IncorrectCredentialsException ice) {
      // 捕获密码错误异常
      result.put("success", false);
      result.put("message", "密码错误!");
    } catch (UnknownAccountException uae) {
      // 捕获未知用户名异常
      result.put("success", false);
      result.put("message", "用户名不存在!");
    } catch (ExcessiveAttemptsException eae) {
      // 捕获错误登录过多的异常
      result.put("success", false);
      result.put("message", "错误次数过多");
    } catch (LockedAccountException lae) {
      result.put("success", false);
      result.put("message", "用户被锁定");
    }
    return result;
  }
}
