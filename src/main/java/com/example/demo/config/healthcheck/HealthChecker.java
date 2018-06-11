package com.example.demo.config.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthChecker implements HealthIndicator{

  @Override
  public Health health() {
    boolean isOk = check();
    if(!isOk) {
      int errorCode = 404;
      return Health.down().withDetail("ErrorCoode", errorCode).build();
//      return Health.down().withDetail("ErrorCode", 10000).build();
    }
    return Health.up().build();
  }

  public boolean check() {
    return true;
  }
}
