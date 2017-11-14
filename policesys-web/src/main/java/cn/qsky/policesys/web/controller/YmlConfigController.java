package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.yml.YmlConfig;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * yml配置文件操作类
 *
 * @author qsky
 */
@RestController
@RequestMapping("system/config")
public class YmlConfigController {

  @Resource
  private YmlConfig ymlConfig;

  /**
   * 获得所有的自定义的yml配置文件
   *
   * @return yml文件map映射
   */
  @GetMapping("listYml")
  public Map<String, String> listYml() {
    return ymlConfig.getConfig();
  }

  /**
   * 添加或者修改yml配置文件
   *
   * @param configKey 配置文件key
   * @param configValue 配置文件value
   * @return 是否添加修改成功
   */
  @PostMapping
  public boolean setConfigValue(String configKey, String configValue) {
    return ymlConfig.setConfigValue(configKey, configValue);
  }

}
