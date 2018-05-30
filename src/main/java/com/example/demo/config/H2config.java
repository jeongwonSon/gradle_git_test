package com.example.demo.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jpa, h2DB 설정
 * :: application.yml에도 존재함
 *h2:
 *  console:
 *    enabled: true
 *    path: /h2-console
 * ==> 같은 내용이다. h2의 웹 콘솔 사용 설정은 default가 false
 * 
 * 
 */
@Configuration
public class H2config {

  static final String h2WebConsoleUrl = "/console/*";
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
  @Bean
  public ServletRegistrationBean h2servletRegistration(){
    ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
    registration.addUrlMappings(h2WebConsoleUrl);
    return registration;
  }
}
