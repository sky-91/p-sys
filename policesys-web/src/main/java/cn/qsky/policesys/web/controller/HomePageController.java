package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.facade.user.data.UserData;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qsky on 17/11/25
 */
@RequestMapping("/index")
@Controller
public class HomePageController {

  private Logger LOG = LoggerFactory.getLogger(HomePageController.class);

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String login(Model model) {
    UserData user = (UserData) SecurityUtils.getSubject().getPrincipal();
    model.addAttribute("name", user.getUserName());
    return "/index";
  }
}
