package com.example.demo.service;

import com.example.demo.common.util.CryptoUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class HealthbellDataEncrypt {
  
  public static void main(String[] args) throws Exception {
    // 파일명으로 BufferedReader를 만든다.
    
    // thinkware 관리자nm -> 암호화 키 변경됨
    // WCtxZIq1yblHzogdzioVMg==
    // 관리자 , B1KsWDsJUrIsmvSYDZoSaQ==
    String file = "E:\\gradle_test\\gradle_git_test\\src\\main\\resources\\ilshinHolderNm.txt";
//    String file = "E:\\gradle_test\\gradle_git_test\\src\\main\\resources\\salemanNm.txt";
//    System.out.println(file + " , " + CryptoUtil.encryptAES(file));
//    System.out.println(file + " , " + CryptoUtil.decryptAES(file));
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
    br.lines().filter(e->{
      if(e != null && e.split(",").length >= 1) {
        return true;
      }
      return false;
    })
    
    // 필터를 통과한 라인들을 순회하며 출력하고 (,)를 기준으로 해서 리스트 객체로 만든다.
    .forEach(e->{
//      List<String> token = Arrays.asList(e.split(","));
      List<String> token = Arrays.asList(e.split("\\r\\n"));  // 빈칸으로 끊음
      token.forEach(num->{
        try {
          System.out.println(num + " , " + CryptoUtil.decryptAES(num));
//          System.out.println(CryptoUtil.encryptAES(num));
        } catch (Exception e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      });
    });
  }
}
