package com.exorcist.msa.core.config;


import com.hengyu.rabbitmq.common.enums.ExchangeEnum;
import com.hengyu.rabbitmq.common.enums.QueueEnum;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterQueueConfiguration {
  /**
   * 配置路由交换对象实例
   * @return
   */
  public DirectExchange userRegisterDirectExchange()
  {
    return new DirectExchange(ExchangeEnum.USER_REGISTER.getValue());
  }

  /**
   * 配置用户注册队列对象实例
   * 并设置持久化队列
   * @return
   */
  public Queue userRegisterQueue()
  {
    return new Queue(QueueEnum.USER_REGISTER.getName(),true);
  }

  /**
   * 将用户注册队列绑定到路由交换配置上并设置指定路由键进行转发
   * @return
   */
  public Binding userRegisterBinding()
  {
    return BindingBuilder.bind(userRegisterQueue()).to(userRegisterDirectExchange()).with(QueueEnum.USER_REGISTER.getRoutingKey());
  }
}
