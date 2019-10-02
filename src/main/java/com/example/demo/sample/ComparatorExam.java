package com.example.demo.sample;

import com.example.demo.domain.Employee01;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExam {

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
    
    System.out.println(list); // 원본
    Collections.sort(list);
    System.out.println("################### sort ######################");
    System.out.println(list); // 이름 순서대로(Comparable sort)
    
    // 익명의 Comparator를 만듦
    // comparator를 사용하는 것 자체가 사용하는 때 마다 정렬 기준이 바뀔 수 있기 때문이다.
    Comparator<Employee01> salesComparator = new Comparator<Employee01>() {
      @Override
      public int compare(Employee01 o1, Employee01 o2) {
        return o2.getSales().intValue() - o1.getSales().intValue();
      }
    };
    
    Collections.sort(list, salesComparator);
    System.out.println("################### sort #####################");
    System.out.println(list); // Comparator sort
  }

}
