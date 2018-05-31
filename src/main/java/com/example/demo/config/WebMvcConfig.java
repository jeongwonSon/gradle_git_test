package com.example.demo.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
  
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
}
