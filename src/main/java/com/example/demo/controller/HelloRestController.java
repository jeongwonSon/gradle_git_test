package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.Car;

@Controller
@RequestMapping("/")
public class HelloRestController {
	
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
		return "hello";
	}
}
