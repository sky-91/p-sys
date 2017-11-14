package cn.qsky.policesys.common.yml;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * yml配置文件读取类
 *
 * @author qsky
 */
@Component
@ConfigurationProperties(prefix = "policesys")
public class YmlConfig {

  /* yml文件policesys节点下的map映射 */
  private ConcurrentMap<String, String> config = new ConcurrentHashMap<>();

  /**
   * 通过key获得yml配置value
   */
  public String getConfigValue(String configKey) {
    return config.get(configKey);
  }

  /**
   * 获取yml文件policesys节点下的map映射
   *
   * @return map映射
   */
  public Map<String, String> getConfig() {
    return config;
  }

  public void setConfig(ConcurrentMap<String, String> config) {
    this.config = config;
  }

  /**
   * 添加或者修改yml配置文件
   *
   * @param configKey 配置文件key
   * @param configValue 配置文件value
   * @return 是否添加修改成功
   */
  public boolean setConfigValue(String configKey, String configValue) {
    if (StringUtils.isNotBlank(configKey)) {
      if (StringUtils.isNotBlank(configValue)) {
        config.put(configKey.trim(), configValue.trim());
      } else {
        config.put(configKey.trim(), configValue);
      }
      return true;
    }
    return false;
  }

}
