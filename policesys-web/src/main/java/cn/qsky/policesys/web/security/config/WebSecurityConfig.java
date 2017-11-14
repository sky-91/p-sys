package cn.qsky.policesys.web.security.config;

import cn.qsky.policesys.web.security.handler.LoginFailureHandler;
import cn.qsky.policesys.web.security.handler.LoginSuccessHandler;
import cn.qsky.policesys.web.security.handler.LogoutSuccessHandler;
import cn.qsky.policesys.web.security.handler.RestAccessDeniedHandler;
import cn.qsky.policesys.web.security.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * @author qsky
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //@Autowired
  //private CorsFilter corsFilter;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 自定义 user Details Service验证, 并指定密码加密所使用的加密器为BCryptPasswordEncoder
    // 需要将密码加密后写入数据库
    auth.userDetailsService(defaultUserDetailsService()).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        //.addFilter(corsFilter)
        .authorizeRequests()
        .antMatchers("/demo/**").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .anyRequest().permitAll() // 其他任何请求,需登录后可以访问
        .and()
        .formLogin().loginPage("/login").permitAll()
        .successForwardUrl("/demo/index")
        //.successForwardUrl("/demo/user/1/5")
        //.successHandler(loginSuccessHandler()) // 登录成功后处理类
        //.failureHandler(loginFailureHandler()) // 登录失败处理类
        .and()
        .logout().logoutUrl("/logout").permitAll()
        .logoutSuccessHandler(logoutSuccessHandler()) // 注销成功后处理类
        .invalidateHttpSession(true)
        .and()
        .exceptionHandling()
        .accessDeniedHandler(accessDeniedHandler())
        .and()
        .csrf().disable();

  }

  @Bean
  UserDetailsService defaultUserDetailsService() {
    return new UserDetailsServiceImpl();
  }

  @Bean
  BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(4);
  }

  /**
   * 登录成功处理类
   */
  @Bean
  LoginSuccessHandler loginSuccessHandler() {
    return new LoginSuccessHandler();
  }

  /**
   * 登录失败处理类
   */
  @Bean
  LoginFailureHandler loginFailureHandler() {
    return new LoginFailureHandler();
  }

  /**
   * 注销成功处理类
   */
  @Bean
  LogoutSuccessHandler logoutSuccessHandler() {
    return new LogoutSuccessHandler();
  }

  /**
   * 权限不通过的处理类
   */
  @Bean
  AccessDeniedHandler accessDeniedHandler() {
    return new RestAccessDeniedHandler();
  }

}

