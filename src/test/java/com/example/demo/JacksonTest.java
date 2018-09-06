package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.TestTwoModel;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/*
 * 이건 junit으로 실행 시, error남(test 4개 다 실행이 안됨)
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class JacksonTest {
  private ObjectMapper mapper;
  
  @Before
  public void setup() {
    this.mapper = new ObjectMapper();
  }
  
  /*
   * 참고 :: http://jdm.kr/blog/224
   */
  @Test
  public void testBasicCode() throws IOException {
    /**
    test.json 파일 내용
    {
        "name":"JDM",
        "age":30,
        "bool":true
    }
    */
    InputStream is = JacksonTest.class.getClassLoader().getResourceAsStream("test.json");
    /*
     * (2018.09.06)
     * test.json 및 test2.json 파일이 읽혀지질 않아서 해당 파일 두개 위치 변경함
     * -> /src/main/resources/ 아래 있어야 파일이 읽혀짐!
     */
    Map test = mapper.readValue(is, Map.class);
    assertTrue("JDM".equals(test.get("name")));
    assertTrue(30 == Integer.parseInt(test.get("age").toString()));
    assertTrue(true == Boolean.parseBoolean(test.get("bool").toString()));
  }
  
  /**
   * 이 테스트는 기본 json 포맷 내부 엘리먼트 요소로 list가 있는 경우
   * model class를 사용해 처리하는 것을 보여줍니다.
   * model class 소스 코드는 포스트 하단에 있습니다.
   * @throws IOException
   */
  @Test
  public void testComplexCodeUsingModel() throws IOException {
    /**
    test2.json 파일 내용
    {
        "name":"JDM",
        "age":30,
        "bool":true,
        "numbers":[1,2,3]
    }
    */
    InputStream is = JacksonTest.class.getClassLoader().getResourceAsStream("test2.json");
    TestTwoModel test = mapper.readValue(is, TestTwoModel.class);
    assertTrue(test.getName().equals("JDM"));
    assertTrue(test.getAge() == 30);
    assertTrue(test.isBool() == true);
    assertTrue(test.getNumbers().size() == 3);
    
  }
  
  /**
   * 이 테스트는 JsonNode를 사용하는 방법을 보여줍니다.
   * @throws IOException
   */
  @Test
  public void testComplexCodeUsingJsonNode() throws IOException {
    
    InputStream is = JacksonTest.class.getClassLoader().getResourceAsStream("test2.json");
    JsonNode test = mapper.readValue(is, JsonNode.class);
    
    /**
     * .get()를 이용해서 원하는 필드의 값을 가져옵니다.
     * .get()은 값을 찾을 수 없는 경우 null을 반환합니다.
     */
    assertTrue(test.get("name").asText().equals("JDM"));
    assertTrue(test.get("age").asInt() == 30);
    assertTrue(test.get("bool").asBoolean() == true);
    assertTrue(test.get("numbers").isArray());
    
    /**
     * .path()를 이용할 수도 있습니다.
     * .get()와의 차이점은 값을 찾을 수 없는 경우 return 값으로
     * MissingNode 객체를 반환합니다.
     */
    assertTrue(test.path("name").asText().equals("JDM"));
  }
  
  /**
   * JsonNode 객체는 불변(immutable)하는 객체기 때문에 값을 변경하려면
   * 가변 객체인 ObjectNode로 캐스팅해서 바꿔야 합니다.
   * @throws IOException
   */
  @Test
  public void testChangeValueUsingObjectNode() throws IOException {
    String src = "{\"item\":\"i'm Item!\"}";
    JsonNode obj = mapper.readValue(src, JsonNode.class);
    assertTrue(obj.get("item").asText().equals("i'm Item!"));
    ((ObjectNode)obj).put("item", "change Value!"); // .set()을 사용해도 된다.
    assertTrue(obj.get("item").asText().equals("Change Value!"));
    System.out.println("objectNode로 바꾼 값 : " + obj);
  }
}
