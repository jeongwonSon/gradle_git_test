package com.example.demo.controller;

import com.example.demo.dao.MemberRepository;
import com.example.demo.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MemberController {

  private static Logger logger = LoggerFactory.getLogger(MemberController.class); 
  
  @Autowired
  MemberRepository memberRepository;
  
  @RequestMapping("/member/jpa")
  public void run(String... arg) throws Exception{

    memberRepository.save(new Member("a",10));
    memberRepository.save(new Member("b",15));
    memberRepository.save(new Member("c",10));
    memberRepository.save(new Member("a",5));
    
    Iterable<Member> list1 = memberRepository.findAll();
    System.out.println("findAll() Method.");
    list1.forEach(member ->{
      System.out.println(member.toString());
    });
    
    System.out.println("findByNameAndAgeLessThan() Method.");
    List<Member> list2 = memberRepository.findByNameAndAgeLessThan("a", 10);
    list2.forEach(member ->{
      System.out.println(member.toString());
    });
    
    System.out.println("findByNameAndAgeLessThanSQL() Method.");
    List<Member> list3 = memberRepository.findByNameAndAgeLessThanSQL("a", 10);
    list3.forEach(member->{
      System.out.println(member.toString());
    });
    
    System.out.println("findByNameAndAgeLessThanSQL() Method.");
    List<Member> list4 = memberRepository.findByNameAndAgeLessThanOrderByAgeDesc("a", 15);
    list4.forEach(member->{
      System.out.println(member.toString());
    });
    
    memberRepository.deleteAll();
  }
}
