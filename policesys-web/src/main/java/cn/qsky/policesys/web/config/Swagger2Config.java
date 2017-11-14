package cn.qsky.policesys.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author qsky
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .genericModelSubstitutes(DeferredResult.class)
        .forCodeGeneration(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage("cn.qsky.policesys.web.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Police sys RESTful APIs")
        .description("供开发参考")
        //.termsOfServiceUrl("http://xxx.xxx.xxx/")
        .contact(new Contact("JAVA GROUP", "http://xxx.xxx.xxx/", "xxx@xxx.com"))
        .version("1.0")
        .termsOfServiceUrl("http://127.0.0.1:8080/swagger-ui.html")
        .build();
  }
}
