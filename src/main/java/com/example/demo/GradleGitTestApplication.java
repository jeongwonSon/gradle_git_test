package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class GradleGitTestApplication {
	
	private static Logger logger = LoggerFactory.getLogger(GradleGitTestApplication.class);
	
	/**
	 * application.java는 package root에 있어야 함
	 * @SpringBootApplication : @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 
	 * 3개의 어노테이션을 포함한 어노테이션이다.
	 * :: 스프링부트의 환경설정 파일이면서, 자동설정 기능이 활성화 되어 있고, 기본적인 컴포넌트 스캔설정이 되어 있음.
	 */

	public static void main(String[] args) {
		SpringApplication.run(GradleGitTestApplication.class, args);
		logger.debug("---------Spring boot 2.0 시작----------");
	}
	
	@RequestMapping("/")
  public String index() {
    // 아무 경로도 없을 때(기본경로)
    return "redirect:/main";
  }
}
