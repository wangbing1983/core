package com.exorcist.msa.core.context;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EventPublisher {
  @Resource
  private ApplicationContext applicationContext;

  public EventPublisher() {
  }

  public void publish(ApplicationEvent event) {
    this.applicationContext.publishEvent(event);
  }
}
