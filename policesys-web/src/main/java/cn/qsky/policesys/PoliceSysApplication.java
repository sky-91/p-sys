package cn.qsky.policesys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qsky
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan("cn.qsky.policesys.core.dao.mapper")
public class PoliceSysApplication {

  public static void main(String[] args) {
    SpringApplication.run(PoliceSysApplication.class, args);
  }
}