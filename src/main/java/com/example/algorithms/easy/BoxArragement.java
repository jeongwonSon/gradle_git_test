package com.example.algorithms.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [박스배치]
 * 참고 : https://m.blog.naver.com/aroaroro/220609677272
 * @author jeongwon
 *
 * 위의 문제 입니다. 제가 접근한 방식은 가로로 박스를 넣다가 
 * 한계치를 넘어가면 다음 줄로 넘어가고 넘어가는 동시에 세로수 중 
 * 가장 큰수를 더해주고 넘어가지 않으면 마지막까지 계산한 세로중 가장 큰수를 한번더 더해주어서
 * 답을 찾아내는 방식으로 알고리즘을 해결해보았습니다.
 */
public class BoxArragement {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int width = sc.nextInt();
    int[] x = new int[1];
    int[] y = new int[1];
    int count = 0;
    
    while(true) {
      x[count] = sc.nextInt();
      y[count] = sc.nextInt();
      
      x = Arrays.copyOf(x, x.length+1);
      y = Arrays.copyOf(y, y.length+1);
      
      if(x[count] == -1) {
        x = Arrays.copyOf(x, x.length-2);
        y = Arrays.copyOf(y, y.length-2);
        break;
      }
      count++;
    }
    
    int sumW = 0;
    int height = 0;
    int wTemp = 0;
    int big = 0;
    int hBig = 0;
    for(int i=0; i<x.length; i++) {
      sumW += x[i];
      
      System.out.println(i + " " + (x.length-1) + " big : " + big + " y[i] : " + y[i]);
      
      if(sumW > width) {
        // 가로가 넘어간다면 세로 중 가장 큰 숫자를 골라서 height에 넣는다
        height += big;
        
        // 가로 중 가장 큰 것을 choice
        sumW = sumW - x[i];
        if(hBig < sumW) {
          hBig = sumW;
        }
        
        sumW = x[i];
        big=0;
      }
      
      if(big < y[i]) {
        // 가장 큰 세로
        big = y[i];
      }
      if(i == x.length -1) {
        height += big;
        if(sumW > hBig) {
          hBig = sumW;
        }
      }
      System.out.println(hBig + " x " + height);
      
    }
  }

}
