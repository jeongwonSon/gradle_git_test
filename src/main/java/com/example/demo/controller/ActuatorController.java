package com.example.demo.controller;

import com.example.demo.config.healthcheck.HealthChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {
  
  @Autowired
  private HealthChecker healthChecker;
  
  @RequestMapping("/healthcheck")
  public Health healthCheck() {
    return healthChecker.health();
  }
}
