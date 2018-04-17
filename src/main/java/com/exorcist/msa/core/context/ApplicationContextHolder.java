package com.exorcist.msa.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextHolder implements ApplicationContextAware {
  public static ApplicationContext context;
  public static ApplicationConstant constant;
  public static final ApplicationContextHolder INSTANCE = new ApplicationContextHolder();

  private ApplicationContextHolder() {
  }

  public static ApplicationContextHolder getInstance() {
    return INSTANCE;
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    context = applicationContext;
    constant = (ApplicationConstant)applicationContext.getBean(ApplicationConstant.class);
  }
}

