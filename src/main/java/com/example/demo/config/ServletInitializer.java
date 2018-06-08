package com.example.demo.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.demo.GradleGitTestApplication;

/**
 *  spring boot로 웹 어플리케이션을 만들고 WAR로 배포할때, springBootServletInitializer를 상속하도록 가이드 함.
 *  (기존에는 web.xml에 등록해서 사용함)
 *  : 상속한다는 것은 결국 tomcat 같은 servlet container 환경에서 spring boot application 동작 가능하도록
 *  웹 어플리케이션 컨텍스트 구성 한다는 의미!
 *  : SpringBootServletInitializer는 WebApplicationInitializer 인터페이스의 구현체
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  
		return application.sources(GradleGitTestApplication.class);
	}

}
