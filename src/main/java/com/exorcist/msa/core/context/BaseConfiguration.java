package com.exorcist.msa.core.context;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@EnableDiscoveryClient
@EnableHystrix
@EnableFeignClients({"com.hearglobal.**.service"})
@ComponentScan(
  basePackages = {"com.exorcist.**.web", "com.exorcist.**.service", "com.exorcist.**.config", "com.exorcist.**.mapper", "com.exorcist.**.action", "com.exorcist.**.manager", "com.exorcist.**.remote", "com.**"},
  excludeFilters = {@ComponentScan.Filter(
    type = FilterType.ASSIGNABLE_TYPE,
    value = {AppErrorController.class}
  )}
)
public class BaseConfiguration {
  public BaseConfiguration() {
  }

  @Bean
  public ApplicationConstant applicationConstant() {
    return new ApplicationConstant();
  }

  @Bean
  public ApplicationContextHolder applicationContextHolder() {
    return ApplicationContextHolder.getInstance();
  }

  @Bean
  public MethodValidationPostProcessor methodValidationPostProcessor() {
    return new MethodValidationPostProcessor();
  }
}
