package com.example.demo.controller;

import com.example.demo.dao.HelloRepository;
import com.example.demo.domain.Car;
import com.example.demo.domain.Hello;
import com.example.demo.domain.Member;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HelloRestController {
  
  @Autowired
  private HelloRepository helloDao;
  
  @RequestMapping("/main")
  @ResponseBody
  public String index() {
  	// hello world를 찍어보자! test
    String value = "hello world";
    Gson gson = new Gson();
    
    /*
     * WebMvcConfig.java 추가하고 나니 error는 나지 않음.
     * 하지만 원하는 값이 나오지 않는다.
     * :: gson.toString()을 찍는게 아니고, gson.toJson()으로 찍어야 원하는 json값이 나온다.
     * (단, messageConverter 추가해야 함)
     */
  	return gson.toJson(value);
  }
  
  @RequestMapping("/hello")
  public String hello(Model model) {
    // hello.html을 호출할 것
    
    Car car = new Car();
    car.setColor("blue");
    car.setDoor(4);
    
    model.addAttribute("car", car);
    return "sample/hello";
  }
  
  @RequestMapping("/getCarList")
  public String getCarList(Model model) {
    
    // 임시방편 차 생성
    Car car1 = new Car();
    car1.setColor("red");
    
    Car car2 = new Car();
    car2.setColor("black");
    
    List<Car> carList = new ArrayList<Car>();
    carList.add(car1);
    carList.add(car2);
    
    model.addAttribute("carList", carList);
    return "sample/car_list";
  }
  
  // Jpa sample test 추가
  @RequestMapping("/add")
  public Hello add(Hello hello) {
    Hello helloData = helloDao.save(hello);
    return helloData;
  }
  
  @RequestMapping("/list")
  public List<Hello> list(Model model){
    List<Hello> helloList = helloDao.findAll();
    return helloList;
  }
  
  private void testOptional() {
    /**
     * java8에서 생긴 optional 써보려고 만듦.
     * (optional)
     * :: 존재할 수도 있지만 안 할 수도있는 객체. 즉, null이 될 수도 있는 객체 -> 일종의 래퍼 클래스
     * 원소가 없거나 최대 하나 밖에 없는 Collection이나 Stream으로 생각해도 좋음
     * 
     * :: 효과
     * - npe를 유발할 수 있는 null을 직접 다루지 않아도 됨
     * - 수고롭게 null체크를 직접하지 않아도 됨
     * - 명시적으로 해당 변수가 null일 수도 있다는 가능성을 표현할 수 있음(불필요한 방어로직을 줄일 수 있음)
     * 
     * :: 변수명은 'maybe'나 'opt'와 같은 접두어를 붙여서 optional 타입의 변수라는 것을 좀 더 명확히 나타냄
     */
    
    Member aMember = new Member();
    
    // null을 담고있는, optional 객체를 얻어온다. optional 내부적으로 미리 생성해놓은 싱글턴 인스턴스!!
    Optional<Member> maybeMember1 = Optional.empty();
    
    // null이 아닌 객체를 담고 있는 Optional 객체를 생성한다. null이 넘어올 경우, npe를 던지기 때문에 주의해서 사용해야 함
    Optional<Member> optMember = Optional.of(null);
    
    /*
     * null인지 아닌지 확신할 수 없는 객체를 담고 있는 Optional 객체를 생성한다.
     * Optional.empty() + Optional.ofNullable(value)를 합쳐놓은 메소드라고 생각하면 됨
     * null이 넘어올 경우, npe를 던지지 않고 Optional.empty()와 동일하게 비어 있는 Optional 객체를 얻어온다.
     * ==> 해당 객체가 null인지 아닌지 자신 없는 상황에서는 이 메소드를 사용할 것!
     */
    Optional<Member> maybeMember = Optional.ofNullable(aMember);
    Optional<Member> maybeNotMember = Optional.ofNullable(aMember);
    
//    int length = Optional.ofNullable(aMember).map(String::length).orElse(0);
  }
}
