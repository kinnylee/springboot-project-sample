package com.kinnylee.config;

import com.kinnylee.endpoint.CustomEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 将自定义的endpoint注册到容器中
 *
 * @author lijl-c
 * @date 2018/9/28
 */
@Configuration
public class CustomEndpointConfig {

  @Bean
  @ConditionalOnEnabledEndpoint
  public CustomEndpoint customEndpoint(){
    return new CustomEndpoint();
  }
}
