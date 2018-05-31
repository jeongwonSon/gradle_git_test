package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.HelloRepository;
import com.example.demo.domain.Car;
import com.example.demo.domain.Hello;
import com.google.gson.Gson;

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
}
