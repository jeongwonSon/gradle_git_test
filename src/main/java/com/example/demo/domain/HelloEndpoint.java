package com.example.demo.domain;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/*
 * @Endpoint : 새로 추가됨
 * 기존에는 인터페이스로 되어있었지만 어노테이션으로 변경됨
 * (3가지 속성 존재 : id, exposure, defaultEnablement)
 * - id는 id를 뜻 함, endpoint도 id와 동일하게 지정됨
 * - exposure은 노출속성을 의미(2가지 속성 JMX, WEB)
 *   아무 설정을 하지 않았을 경우, 모두 다 노출됨
 * - defaultEnablement 은 기본적으로 enable, disable 시킬 건지 속성
 * 
 * (cf) @WebEndpointExtension 어노테이션이 사라지고 @EndpointWebExtension으로 변경되었다.
 * @WebEndpoint, @JmxEndpoint가 추가 됨.
 *  - @WebEndpoint : web에서만 노출, @JmxEndpoint : jmx에서만 노출됨
 *  - jmx, web 둘 다 노출 시키고 싶으면 -> @Endpoint로 작성하면 됨
 */
//@Endpoint(id="hello")
@WebEndpoint(id="hello")
@Component
public class HelloEndpoint {
  
  /*
   * Http method의 get에 해당 함
   */
  @ReadOperation
  public String hello(String name) {
    return "hello " + name;
  }
  
  /*
   * Http method의 post에 해당 함
   */
  @WriteOperation
  public String foo(String name) {
    return name;
  }
}
