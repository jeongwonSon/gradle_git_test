package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * [chess board]
 * 참고 : https://m.blog.naver.com/aroaroro/220609677272
 * @author jeongwon
 * 
 * (1,1) = 1
 * (2,2) = 3
 * (3,3) = 7 
 */
public class ChessBoard {
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int x = 1;
    int y = 1;
    int num = sc.nextInt();
    int sum = 1;
    int sumTemp = 2;
    
    if(num != 1) {
      for(int i=0; i<num; i++) {
        x++;
        y++;
        sum += sumTemp;
        sumTemp += 2;
        
        if(num <= sum) {
          break;
        }
      }
    }
    
    System.out.println("num : " + num +" sum : " + sum +" x : " + " y: " +y);
    
    int temp = sum - num;
    // 몇 칸 움직여야 하는지 x가 짝수면 좌측으로 x가 홀수면 아래쪽으로
    
    System.out.println(temp);
    boolean xCh = false;  // x가 줄어들지, 길어질지 판결
    boolean yCh = false;  // y가 줄어들지, 길어질지 판결
    
    if(x%2 == 0) {
      for(int i=0; i < temp; i++) {
        if(yCh) {
          // 아랫방향으로 한칸 전진 후 y방향 감소 안되게
          y--;
          System.out.println("y--");
          yCh = false;
          xCh = true;
          continue; // 아랫쪽의 x 루틴이 한번 더 돌기 때문에 탈출
        }
        
        if(xCh) {
          x++;
          System.out.println("x++");
        } else {
          x--;
          System.out.println("x--");
        }
        
        if(x == 1) {  // x가 1이 되면 한칸 아래로
          yCh = true;
        }
      }
    } else {
      for(int i=0; i< temp; i++) {
        if(xCh) {
          x--;
          System.out.println("x--");
          yCh = true;
          xCh = false;
          continue;
        }
        if(yCh) {
          y++;
          System.out.println("y++");
        } else {
          y--;
          System.out.println("y--");
        }
        
        if(y==1) {
          xCh = true;
        }
      }
    }
      System.out.println(x + " " + y);
  } 
  
}
