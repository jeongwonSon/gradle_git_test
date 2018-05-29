package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.HelloDao;
import com.example.demo.domain.Car;
import com.example.demo.domain.Hello;

@RestController
public class HelloRestController {
  
  @Autowired
  private HelloDao helloDao;
  
  @RequestMapping("/main")
  @ResponseBody
  public String index() {
  	// hello world를 찍어보자! test
  	return "hello world";
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
