package com.exorcist.msa.core.context;

import org.springframework.beans.factory.annotation.Value;

public class ApplicationConstant {
  @Value("${spring.application.name}")
  public String applicationName;
  @Value("${api.debug:false}")
  public String apiDebug;

  public ApplicationConstant() {
  }
}
