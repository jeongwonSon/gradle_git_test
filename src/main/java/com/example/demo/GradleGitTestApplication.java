package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.example.demo.domain.Journal;
import com.example.demo.service.JournalRepository;

@Controller
/*
 * datasource를 사용하고 싶지 않으면 아래와 같이 어노테이션에 추가하면 된다.
 */
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class GradleGitTestApplication {
	
	private static Logger logger = LoggerFactory.getLogger(GradleGitTestApplication.class);
	
	/**
	 * application.java는 package root에 있어야 함
	 * @SpringBootApplication : @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 
	 * 3개의 어노테이션을 포함한 어노테이션이다.
	 * :: 스프링부트의 환경설정 파일이면서, 자동설정 기능이 활성화 되어 있고, 기본적인 컴포넌트 스캔설정이 되어 있음.
	 */

	@Bean
  InitializingBean saveData(JournalRepository repo) {
    return () -> {
      repo.save(new Journal("스프링 부트 입문", "스프링 공부 시작", "2019-02-01"));
      repo.save(new Journal("스프링 프로젝트 샘플", "스프링 샘플", "2019-02-02"));
      repo.save(new Journal("스프링 부트 구조", "스프링 구조를 알아보자", "2019-02-03"));
      repo.save(new Journal("스프링 부트 클라우드", "클라우드욤", "2019-02-04"));
    };
    // InitializingBean은 스프링 엔진이 인스턴스 생성 후 초기화 할 때 항상 호출하는 특수 클래스
    // saveData는 스프링 시동 준비전에 실행
  }
	
	public static void main(String[] args) {
		SpringApplication.run(GradleGitTestApplication.class, args);
		logger.debug("---------Spring boot 2.0 시작----------");
	}
	
//	@RequestMapping("/")
//  public String index() {
//    // 아무 경로도 없을 때(기본경로)
//    return "redirect:/main";
//  }
	

	
}
