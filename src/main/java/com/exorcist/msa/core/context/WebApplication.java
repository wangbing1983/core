package com.exorcist.msa.core.context;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@EnableSwagger2
public class WebApplication {
  public WebApplication() {
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public ErrorController errorController(ErrorAttributes errorAttributes, ServerProperties serverProperties) {
    return new AppErrorController(errorAttributes, serverProperties.getError());
  }

  @Bean
  public AppExceptionHandlerController appExceptionHandlerController() {
    return new AppExceptionHandlerController();
  }

  @Bean
  public Docket api() {
    return (new Docket(DocumentationType.SWAGGER_2)).directModelSubstitute(LocalDate.class, Date.class).directModelSubstitute(LocalDateTime.class, java.util.Date.class).select().apis((requestHandler) -> {
      assert requestHandler != null;

      String packageName = requestHandler.getHandlerMethod().getMethod().getDeclaringClass().getPackage().getName();
      return packageName.contains("controller");
    }).paths(PathSelectors.any()).build();
  }
}
