package com.example.demo.controller;

import com.example.demo.dao.PreviousMemberRepository;
import com.example.demo.domain.PreviousMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableCaching	// 어노테이션을 이용한 캐시기능을 사용하겠다는 선언
public class PreviousMemberController {
  
  /**
   * @EnableCaching는 @Cacheable, @CacheEvict등 관련 어노테이션을 사용하겠다는 선언
   */
  
  private static Logger logger = LoggerFactory.getLogger(PreviousMemberController.class);
  
  @Autowired
  PreviousMemberRepository memberRepository;
  
  /*
   * 캐시 사용 유무에 따른 수행시간 비교 
   */
  @GetMapping("/member/nocache/{name}")
  @ResponseBody
  public PreviousMember getNoCacheMember(@PathVariable String name) {
    
    long start = System.currentTimeMillis();	// 수행시간 측정
    PreviousMember member = memberRepository.findByNameNoCache(name);	// db 조회
    long end = System.currentTimeMillis();
    
    logger.info(name+ "의 NoCache 수행시간 : " + Long.toString(end-start));
    
    return member;
  }
  
  @GetMapping("/member/cache/{name}")
  @ResponseBody
  public PreviousMember getCacheMember(@PathVariable String name) {
    
    long start = System.currentTimeMillis();	// 수행시간 측정
    PreviousMember member = memberRepository.findByNameCache(name);	// db 조회
    long end = System.currentTimeMillis();
    
    logger.info(name+ "의 Cache 수행시간 : " + Long.toString(end-start));
    
    return member;
  }
  
  @GetMapping("/member/refresh/{name}")
  @ResponseBody
  public String refresh(@PathVariable String name) {
    memberRepository.refresh(name);	// 캐시제거
    return "cache clear!!!";
  }

}
