package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GradleGitTestApplication {
	
	/**
	 * application.java는 package root에 있어야 함
	 * @SpringBootApplication : @SpringBootConfiguration, @EnableAutoConfiguration, @ComponentScan 
	 * 3개의 어노테이션을 포함한 어노테이션이다.
	 * :: 스프링부트의 환경설정 파일이면서, 자동설정 기능이 활성화 되어 있고, 기본적인 컴포넌트 스캔설정이 되어 있음.
	 */

	public static void main(String[] args) {
		SpringApplication.run(GradleGitTestApplication.class, args);
	}
}
