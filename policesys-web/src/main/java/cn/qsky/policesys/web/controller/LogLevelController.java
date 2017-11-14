package cn.qsky.policesys.web.controller;

import cn.qsky.policesys.common.log.LogLevelConfig;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志级别动态修改controller类
 *
 * @author qsky
 */
@RestController
@RequestMapping("system/log")
public class LogLevelController {

  @Resource
  private LogLevelConfig logLevelConfig;

  /**
   * 修改日志级别
   *
   * @param changeLevelMap 全限定名类和日志级别map信息
   *
   * 例如{"loggerLevel":"INFO","loggerName":"cn.qsky.policesys.web.controller.DemoController"}
   */
  @PutMapping
  public boolean modificationLogLevel(@RequestBody Map<String, String> changeLevelMap) {
    return logLevelConfig.modifyLogLevel(changeLevelMap);
  }

  /**
   * 获得全部的全限定名类及日志级别列表
   *
   * @return 全限定名类及日志级别列表
   */
  @GetMapping("listLogger")
  public List<Map<String, String>> listLogger() {
    return logLevelConfig.listLogger();
  }

}
