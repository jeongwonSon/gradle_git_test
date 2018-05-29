package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(description="car 조회에 관한 api")
@RequestMapping("/api")
public class ApiTestController {
	
  /*
   * 20180528.txt 파일에 적어놓은 방식으로 메시지를 넣고 싶었지만..
   * 성공하지 못해서 해당 컨트롤러 맨 위에 apiResponse msg를 넣음
   */
  @ApiResponses(value= {
      @ApiResponse(code=400, message= "유효하지 않은 파라미터 값"),
      @ApiResponse(code=200, message= "성공!")
  })
  
  
  @RequestMapping(value="/car/{color}", method = RequestMethod.GET)
  public String getCar(@ApiParam(value="색깔", required=true, defaultValue="기본값") String color) {
    
    return "car 색은 " + color;
  }
  
	@RequestMapping(value="/car", method = RequestMethod.POST)
	public String selectCar() {
		
		return "car";
	}
}
