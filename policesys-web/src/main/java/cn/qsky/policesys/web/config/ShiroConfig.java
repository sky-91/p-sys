package cn.qsky.policesys.web.config;

import cn.qsky.policesys.web.shiro.MyShiroRealm;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qsky on 17/11/21
 */
@Configuration
public class ShiroConfig {

  private Logger LOG = LoggerFactory.getLogger(ShiroConfig.class);

  @Bean
  public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
    LOG.debug("ShiroConfiguration.shirFilter()");
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    //拦截器.
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>(16);
    //配置不会被拦截的链接 顺序判断
    filterChainDefinitionMap.put("/static/**", "anon");
    filterChainDefinitionMap.put("/login/**", "anon");
    filterChainDefinitionMap.put("/swagger-ui.html", "anon");

    //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");

    //过滤链定义，从上向下顺序执行，一般将/**放在最为下边
    //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
    filterChainDefinitionMap.put("/**", "authc");

    //如果不设置默认会自动寻找Web工程根目录下的"/login"页面
    shiroFilterFactoryBean.setLoginUrl("/login");

    // 登录成功后要跳转的链接
    shiroFilterFactoryBean.setSuccessUrl("/index");

    //未授权界面
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

  @Bean
  public MyShiroRealm myShiroRealm() {
    MyShiroRealm myShiroRealm = new MyShiroRealm();
    return myShiroRealm;
  }

  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    securityManager.setRealm(myShiroRealm());
    return securityManager;
  }
}
