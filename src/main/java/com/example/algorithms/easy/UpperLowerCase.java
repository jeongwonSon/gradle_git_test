package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * [대소문자 바꾸기]
 * 참고 : https://m.blog.naver.com/aroaroro/220594583187
 * @author jeongwon
 * 
 * 자바에서 제공하는 toUpperCase(),toLowerCase() 함수들 존재함
 * 대문자로 모두 교환이거나 소문자로 모두 교환임
 * 
 * +32 또는 -32를 해줌으로써 아스키코드 값을 변형시켜서 답을 도출함
 */
public class UpperLowerCase {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    char temp;
    for(int i=0; i < str.length(); i++) {
      temp = str.charAt(i);
      
      if(temp>=65 && temp <= 96) {
        // 대문자를 소문자로 변형
        System.out.println((char)(temp+32) +"");
      } else if(temp >= 97 && temp <= 122) {
        // 소문자를 대문자로 변형
        System.out.println((char)(temp-32) + "");
      } else {
        // 숫자가 들어갔을 때는 그냥 출력
        System.out.println(temp +"");
      }
    }
    // 아스키 코드 65 = 'A' ~ 90 = 'Z'
    //             97 = 'a' ~ 122 = 'z'
  }

}
