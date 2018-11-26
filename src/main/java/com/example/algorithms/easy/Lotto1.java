package com.example.algorithms.easy;

import java.util.Scanner;

import org.h2.engine.SysProperties;

/**
 * 로또 번호 일치 확인
 * @author jwson
 * 
 * 1등 : 6개 번호 일치
 * 2등 : 5개 번호 일치 + 보너스 번호
 * 3등 : 5개 번호 일치
 * 4등 : 4개 번호 일치
 * 5등 : 3개 번호 일치
 *
 */
public class Lotto1 {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int[] num = new int[7];
    int[] myNum = new int[6];
    int point = 0;
    boolean isPoint = false;
    
    System.out.println("당첨 번호를 입력하세요! 7개");
    if(num.length < 7) {
      System.out.println("당첨 번호 7개를 다시 입력해주세요!");
    }
    for ( int i=0; i < num.length; i++) {
      num[i] = sc.nextInt();
    }
    System.out.println("자신의 번호를 입력하세요! 6개");
    if(myNum.length < 6) {
      System.out.println("자신의 로또 번호 6개를 다시 입력해주세요!");
    }
    for(int i=0; i < myNum.length; i++) {
      myNum[i] = sc.nextInt();
    }
    
    // 당첨번호와 자신의 번호 비교하기
    for (int i=0; i < num.length ; i++) {
      for (int j=0; j < myNum.length ; j++) {
        if (num[i] == myNum[j]) {
          point++;
          if ((num.length - 1) == i) {
            isPoint = true;
            point--;
            break;
          }
          break;
        }
      }
    }
    
    if (point == 5 && isPoint ) {
      System.out.println("2등");
    } else if(point == 6) {
      System.out.println("1등");
    } else if(point == 5) {
      System.out.println("3등");
    } else if(point == 4) {
      System.out.println("4등");
    } else if(point == 3) {
      System.out.println("5등");
    } else {
      System.out.println("탈락!!!!");
    }
  }
}
