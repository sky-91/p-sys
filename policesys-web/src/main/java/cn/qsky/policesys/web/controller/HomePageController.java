package cn.qsky.policesys.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author qsky on 17/11/25
 */
@RequestMapping("/index")
@Controller
public class HomePageController {

  private Logger LOG = LoggerFactory.getLogger(HomePageController.class);

  @RequestMapping(value = "", method = RequestMethod.GET)
  public ModelAndView login() {
    return new ModelAndView("/index");
  }
}
