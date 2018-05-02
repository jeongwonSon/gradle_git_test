package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 *  (참고)
 *  http://donzbox.tistory.com/593 
 *  
 *  WebConfig.java 파일 필요 없음, 기본적으로 thymeleaf 설정하면 
 *  src/main/resources/templates 경로임
 *  => 내가 하고싶은 것은 src/main/webapp/WEB-INF/views 하단으로 경로 변경
 */
@Configuration
public class ThymeleafConfig {

	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/WEB-INF/views/");	// 경로 맞게 잘 적어줄 것
		resolver.setSuffix(".html");
		resolver.setTemplateMode("LEGACYHTML5");	// neko html을 활성화하려면 다음과 같이 mode를 해야함
		resolver.setCacheable(false);
		return resolver;
	}
	
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.addDialect(new LayoutDialect());	// 해당 설정을 해줘야 thymeleafLayoutdialect 사용 가능!
        return templateEngine;
    }
 
    @Bean
    public ViewResolver viewResolver(){
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver() ;
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setOrder(1);
        viewResolver.setCharacterEncoding("UTF-8");	// viewResolver에 UTF-8 처리를 하지 않으면 한글이 깨져서 나옴!
        return viewResolver;
    }
	
}
