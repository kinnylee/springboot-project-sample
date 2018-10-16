package com.kinnylee.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by lijl-c on 2018/9/27.
 */
@Component
public class TestHealth implements HealthIndicator{

  @Override
  public Health health() {
    return Health.down(new IndexOutOfBoundsException("exception")).build();
  }
}
