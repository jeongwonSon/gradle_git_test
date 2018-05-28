package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(description="car 조회에 관한 api")
@RequestMapping("/api")
public class ApiTestController {
	
  @RequestMapping(value="/car/{color}", method = RequestMethod.GET)
  public String getCar(@PathVariable(value="color") String color) {
    
    return "car 색은 " + color;
  }
  
	@RequestMapping(value="/car", method = RequestMethod.POST)
	public String selectCar() {
		
		return "car";
	}
}
