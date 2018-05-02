package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiTestController {
	
	@RequestMapping(value="/car", method = RequestMethod.POST)
	public String selectCar() {
		
		return "car";
	}
}
