package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.util.CglibBeanUtil;
import cn.qsky.policesys.facade.user.UserFacade;
import cn.qsky.policesys.facade.user.data.UserData;
import cn.qsky.policesys.web.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author qsky on 17/11/5
 */
@Api(description = "User接口API")
@RequestMapping("user")
@RestController
public class UserController {

  private Logger LOG = LoggerFactory.getLogger(UserController.class);

  @Resource
  private UserFacade userFacade;

  /**
   * 通过主键列获得demo数据传输对象
   *
   * @param uid uid
   * @return demo数据传输对象
   */
  @ApiOperation(value = "获取demoUser", notes = "返回demoUser信息", response = UserVO.class)
  @ApiImplicitParam(name = "uid", value = "uid", required = true, paramType = "path", dataType = "String")
  @GetMapping("get/{uid}")
  public UserVO getDemoUserData(@PathVariable(name = "uid") String uid) {
    UserData userData = userFacade.getUserInfoById(uid);
    LOG.info("UserData:{}", userData.toString());
    return CglibBeanUtil.copyProperties(userFacade.getUserInfoById(uid), UserVO.class);
  }

  @RequestMapping(value = "upload", method = RequestMethod.POST)
  public Boolean importUser(@RequestParam("file") MultipartFile file) {
    if (!file.isEmpty()) {
      try {
        return userFacade.importUser(WorkbookFactory.create(file.getInputStream()));
      } catch (Exception e) {
        e.printStackTrace();
        LOG.error("File {} is wrong!", file.getOriginalFilename());
      }
    }
    return true;
  }
}
