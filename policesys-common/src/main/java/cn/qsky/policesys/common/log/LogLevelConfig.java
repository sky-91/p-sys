package cn.qsky.policesys.common.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author qsky on 17/11/5
 */
@Component
@Configuration(value = "logLevelConfig")
public class LogLevelConfig {

  /**
   * 全局日志级别映射对象
   */
  private ConcurrentMap<String, Logger> logger_map = new ConcurrentHashMap<>();

  /**
   * 加载全局日志级别信息到映射对象
   */
  private void loadLoggerList() {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    /* 添加其它logger */
    for (Logger logger : loggerContext.getLoggerList()) {
      if (isLoadLogger(logger.getName())) {
        logger_map.put(logger.getName(), logger);
      }
    }
    /* 添加根logger */
    Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    logger_map.put(rootLogger.getName(), rootLogger);
  }

  /**
   * 是否对该名称(类全限定名)的类进行加载
   *
   * @param className 类全限定名
   * @return 是否加载
   */
  private boolean isLoadLogger(String className) {
    /* 加载以cn.qsky.policesys开头的类 */
    if (className.startsWith("cn.qsky.policesys")) {
			/* 判断是类，才进行加载(类的名称首字母都是大写) */
      int position = className.lastIndexOf(".");
      String lastName = className.substring(position + 1);
      if (Character.isUpperCase(lastName.charAt(0))) {
        return true;
      }
    }
    return false;
  }

  /**
   * 修改指定全限定名类的日志级别
   *
   * @param changeLevelMap 全限定名类和日志级别map信息
   *
   * 例如{"loggerLevel":"INFO","loggerName":"cn.qsky.policesys.web.controller.DemoController"}
   */
  public boolean modifyLogLevel(Map<String, String> changeLevelMap) {
    String loggerName = changeLevelMap.get("loggerName");
    if (StringUtils.isNotBlank(loggerName)) {
      Logger logger = logger_map.get(loggerName);
      if (logger != null) {
        String loggerLevel = changeLevelMap.get("loggerLevel");
        if (StringUtils.isNotBlank(loggerLevel)) {
					/* 设置信息日志级别 */
          logger.setLevel(Level.toLevel(loggerLevel));
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 获得全部的全限定名类及日志级别列表
   *
   * @return 全限定名类及日志级别列表
   */
  public List<Map<String, String>> listLogger() {
    if (logger_map.isEmpty()) {
      loadLoggerList();
    }

    List<Map<String, String>> loggerList = new ArrayList<>();
    HashMap<String, String> levelMap;
    for (Entry<String, Logger> loggerMap : logger_map.entrySet()) {
			/* 获得该日志中有效的级别信息 */
      Level level = loggerMap.getValue().getEffectiveLevel();
      levelMap = new HashMap<>();
      levelMap.put("loggerName", loggerMap.getKey());
      levelMap.put("loggerLevel", level.levelStr);
      loggerList.add(levelMap);
    }
    return loggerList;
  }
}
