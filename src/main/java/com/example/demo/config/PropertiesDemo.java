package com.example.demo.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 자바 프로퍼티 테스트
 * @author jeongwon
 * @description (참고) https://jdm.kr/blog/215
 *
 */
public class PropertiesDemo {

  private Properties properties;
  
  public PropertiesDemo() {
    properties = new Properties();
  }
  
  public Properties getProperties() {
    return properties;
  }
  
  /**
   * 이 메소드는 프로퍼티 파일을 스트림으로 읽어 들여 멤버 변수의 프로퍼티에 적재함
   * @param path
   * @throws IOException
   */
  public void loadProp(String path) throws IOException{
    InputStream inputStream = getClass().getResourceAsStream(path);
    properties.load(inputStream);
    inputStream.close();
  }
  
  /**
   * 이 메소드는 static으로 선언해서 프로퍼티 파일을 읽는 것을 보여준다.
   * @param path
   * @return
   * @throws IOException
   */
  public static Properties loadPropForStatic(String path) throws IOException{
    Properties properties = new Properties();
    InputStream inputStream = PropertiesDemo.class.getResourceAsStream(path);
    properties.load(inputStream);
    inputStream.close();
    return properties;
  }
  
  public static void main(String[] args) throws IOException{
    PropertiesDemo propertiesDemo = new PropertiesDemo();
    
    // 프로퍼티 파일을 읽어들이고 해당 값을 출력해본다
    propertiesDemo.loadProp("/application-dev.yml");
    Properties properties = propertiesDemo.getProperties();
    properties.list(System.out);
    
    // 아래 코드는 새로운 프로퍼티 파일에 같은 키를 준 경우 오버라이드 하는 것을 확인한다.
    // TODO :: 파일명 앞에 '/' 사용해야 오류 안나고 읽힘
    @SuppressWarnings("static-access")
    Properties staticProp = propertiesDemo.loadPropForStatic("/application-prod.yml");
    properties.putAll(staticProp);
    properties = propertiesDemo.getProperties();
    properties.list(System.out);
    
    // 아래 코드는 프로퍼티간의 결합을 확인한다.
    Properties dummy = new Properties();
    dummy.put("demo.type", "dummy");  // 기존 키를 오버라이드 함
    dummy.put("demo.temp", "temp");  // 새로운 키를 추가함
    properties.putAll(dummy);
    properties.list(System.out);
    
    // 아래 코드는 개별 키를 주어 값을 반환받는다.
    Object type = properties.get("demo.type");
    
    // 아래코드는 프로퍼티를 키들을 순회하는 구문입니다.
    // .stringPropertyNames 대신 .keySet을 사용할 수도 있다.
    for(String key : properties.stringPropertyNames()) {
      Object value = properties.getProperty(key);
    }
    
    // 해당 키가 있는지 여부를 판별한다.
    properties.containsKey("demo.type");
    
    // 해당 값이 있는지 여부를 판별한다.
    properties.containsValue("dummy");
    
    // 보너스 코드
    // 키값을 주고 해당 값이 있으면 해당 값을 반환하지만
    // 해당 값이 없으면 null을 반환한다.
    Object result = properties.computeIfAbsent("undefined", value -> returnNull(value));
    System.out.println("result value is " + result);
  }
  
  public static Object returnNull(Object key) {
    System.out.println(key + "value is null.");
    return null;
  }
}
