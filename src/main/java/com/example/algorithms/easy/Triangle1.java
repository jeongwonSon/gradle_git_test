package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * 삼각형 판단하기
 * @author jwson
 * 
 * - 삼각형의 조건 
 * : 3변의 길이 중 짧은 2개의 선분의 합이 가장 긴 선분 보다 길어야 함
 *   a + b > c 라는 조건
 *   
 * - 정삼각형의 조건 : 세 변의 길이야 같아야 함
 * 
 * - 이등변삼각형 조건 : 두 변의 길이아 같아야 함
 * - 직각삼각형 : 피타고라스 정리(a제곱+b제곱 = c제곱)
 *
 */
public class Triangle1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int[] num = new int[3];
    int temp;
    int a,b,c;
    
    for(int i=0; i< num.length; i++) {
      num[i] = sc.nextInt();
    }
    
    // 변의 길이를 측정하고 짧고 긴 선분을 판단하기 위한 정렬 알고리즘
    for (int i=0; i<num.length-1; i++) {
      for (int j=i+1; j<num.length; j++) {
        if (num[i] > num[j]) {
          temp = num[i];
          num[i] = num[j];
          num[j] = temp;
        }
      }
    }
    
    // 직각삼각형 구별
    a = (int) Math.pow(num[0], 2);
    b = (int) Math.pow(num[1], 2);
    c = (int) Math.pow(num[2], 2);
    
    if ((num[0] + num[1]) > num[2]) {
      if( num[0] == num[1] && num[1] == num[2]) {
        System.out.println("정삼각형");
      } else if( num[0] == num[1] || num[1] == num[2]) {
        System.out.println("이등변삼각형");
      } else if((a+b) == c) {
        System.out.println("직각삼각형");
      } else {
        System.out.println("삼각형");
      }
    } else {
      System.out.println("삼각형 Nono~");
    }
  }

}
