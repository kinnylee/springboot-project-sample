package com.kinnylee.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;

/**
 * Created by lijl-c on 2018/9/28.
 */
public class MyHealthIndicator extends AbstractHealthIndicator {

  @Override
  protected void doHealthCheck(Builder builder) throws Exception {
    builder.up().withDetail("description", "extends abstract health indicator ok").build();
  }
}
