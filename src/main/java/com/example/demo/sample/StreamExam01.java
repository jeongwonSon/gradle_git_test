package com.example.demo.sample;

import java.util.Arrays;
import java.util.List;


public class StreamExam01 {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("jeong", "pro", "jdk", "java");
    
    // 기존 코딩방식
    long count = 0;
    for(String name : names) {
      if(name.contains("o")) {
        count ++;
      }
    }
    System.out.println("count :" + count);  // 2
    
    // Stream 방식 :: 불필요한 코딩(for, if) 걷어낼 수 있고 직관적이기 때문에 가독성이 좋아짐
    
    count = 0;
    count = names.stream().filter(x -> x.contains("o")).count();
    System.out.println("Count(Stream) :" + count);  // 2
  }
}
