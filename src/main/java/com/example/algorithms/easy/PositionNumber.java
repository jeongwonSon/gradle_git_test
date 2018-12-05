package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * 자릿수 계산 문제
 * (ex) 입력을 1로 하면 1, 10으로 하면 2, 100으로 하면 3
 * @author jwson
 *
 */
public class PositionNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    long count = sc.nextInt();
    long ch = 10;
    int point = 1;
    while (true) {
      if (ch > count) break;
      point ++;
      ch *= 10;
    }
    System.out.println(point);
  }
}
