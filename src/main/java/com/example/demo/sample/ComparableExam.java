package com.example.demo.sample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.demo.domain.Employee01;

/**
 * Comparable은 객체 간의 정렬에 있어서 오름차순, 내림차순등의 일반적인 순서를
 * 잡는 기준이 필요할 때 객체 클래스에 확장해서 사용한다.
 * 
 * @author jeongwon
 *
 */
public class ComparableExam {

  public static void main(String[] args) {
    Employee01 emp1 = new Employee01(1, "jdk", "솔루션 개발1", "연구원", new BigInteger("2800"));
    Employee01 emp2 = new Employee01(2, "jeong", "솔루션 개발1", "선임연구원", new BigInteger("3200"));
    Employee01 emp3 = new Employee01(3, "amateur", "솔루션 개발2", "연구원", new BigInteger("2800"));
    Employee01 emp4 = new Employee01(4, "pro", "솔루션 개발2", "수석연구원", new BigInteger("7000"));
    List<Employee01> list = new ArrayList<>();
    
    list.add(emp1);
    list.add(emp2);
    list.add(emp3);
    list.add(emp4);
    
    System.out.println(list); // 넣은 순서대로
    Collections.sort(list);
    System.out.println("###################");
    System.out.println(list); // 이름 순서대로
  }

}
