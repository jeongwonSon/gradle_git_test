package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
  
  /**
   * Gson http message converter
   */
  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(createGsonHttpMessageConverter());
  }

  private GsonHttpMessageConverter createGsonHttpMessageConverter() {
    Gson gson = new GsonBuilder()
                  .excludeFieldsWithoutExposeAnnotation()
                  .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                  .create();
    
    GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
    gsonConverter.setGson(gson);
    
    return gsonConverter;
  }
  
  /**
   * JacksonTest.java 에서 Jackson 관련 테스트 해보려고 추가했는데, error가 계속 남(아직 해결 못함)
   */
  
  /**
   * Jackson http message converter
   * (해당 프로젝트에는 gson 사용해볼 예정)
   */
//  @Override
//  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//      Jackson2ObjectMapperBuilder builder = jacksonBuilder();
//      converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
//  }

  public Jackson2ObjectMapperBuilder jacksonBuilder() {
      Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
      builder.propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

      return builder;
  }
}
