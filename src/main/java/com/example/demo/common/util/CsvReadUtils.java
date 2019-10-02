package com.example.demo.common.util;

import java.io.*;
import java.util.Arrays;
import java.util.List;


public class CsvReadUtils {
  /**
   * CSV 파일을 파싱할 때 쓸만한 코드(java8 Lamda 이용)
   * @throws UnsupportedEncodingException
   * @throws FileNotFoundException
   */
  public void readCsvFile() throws UnsupportedEncodingException, FileNotFoundException {
    // 파일명으로 BufferedReader를 만든다.
    String file = "test.csv";
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
    br.lines().filter(e->{
      if (e != null && e.split(",").length >= 1) {
        return true;
      }
      return false;
    })
    
    // 필터를 통과한 라인들을 순회하며 출력하고 (,)를 기준으로 해서 리스트 객체로 만든다.
    .forEach (e->{
      System.out.println(e);
      List<String> token = Arrays.asList(e.split(","));
    });
  }
}
