package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * 1. build.gradle의 dependencies에 swagger 관련 추가
	 * 2. swaggerConfig 파일을 만든다.
	 * 3. api()를 추가한다.
	 * 4. paths()를 설정한다. Controller의 @RequestMapping에서 /api/**로 시작하는 url들만 필터링한다고 설정함.
	 * 
	 * -- PathSelectors.ant("/api/**")의 경우 /api/ path를 가진 url들만 공개하겠다는 얘기, 만약 모든
	 * url을 화면에 노출시키고 싶을 경우 지우면 됨
	 */
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.apis(RequestHandlerSelectors.any())	// 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))	// 현재 RequestMapping으로 할당된 모든 URL 리스트를 추출
				.paths(PathSelectors.ant("/api/**"))	// 그 중 /api/**인 URL들만 필터링
				.build();
	}

}
