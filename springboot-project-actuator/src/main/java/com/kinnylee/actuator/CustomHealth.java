package com.kinnylee.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 直接实现接口的方式自定义健康检查
 * Created by lijl-c on 2018/9/20.
 */
@Component
public class CustomHealth implements HealthIndicator {

  @Override
  public Health health() {
    try {
      RestTemplate restTemplate = new RestTemplate();
      restTemplate.getForObject("http://www.baidu.com", String.class);
      return Health.up().withDetail("description", "server ok").build();
    }catch (Exception e){
      return Health.down().build();
    }
  }
}
