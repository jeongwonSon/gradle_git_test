package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * [시저의 암호]
 * 참고 : https://m.blog.naver.com/aroaroro/220594583187
 * @author jeongwon
 * 
 * 암호학에서 시저 암호는 가장 오래된 암호이고 가장 대표적인 대치(substitution) 암호로서
 * 평문 문자를 다른 문자로 일대일 대응시켜 암호문을 만들어 내는 방식이다.
 * 
 * 씨저 암호는 알파벳을 3글자씩 밀려서 쓰면서 문장을 만들었다.
 * 실제 씨저는 부하인 브루투스에게 암살되기 전에 키케로에게 다음과 같은 암호문을 보냈다고 한다.
 * 
 * qhyhu wuxvw euxwxv
 * ===> never trust brutus    (절대 브루투스를 믿지마라)
 * 
 * 3작은 알파벳으로 치환하면 된다
 */
public class CaesarCipher1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    
    char temp;
    int count = 0;
    for(int i=0; i<str.length(); i++) {
      temp = (char)(str.charAt(i)-3);
      if(temp == 29) {
        temp = ' ';
      } else if(temp < 65) {
        count = (65-(int)temp);
        temp = (char)(91-count);
      } else if(temp < 97) {
        count = (97-(int)temp);
        temp = (char)(123-count);
      }
      
      System.out.println(temp);
    }

  }

}
