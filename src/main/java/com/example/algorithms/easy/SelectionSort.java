package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * 선택정렬
 * : 제자리 정렬 알고리즘의 하나
 * 주어진 리스트 중 최소값을 찾는다. 그 값을 맨 앞에 위치한 값과 교체함
 * 맨 처음 위치를 뺀 나머지 리스트를 같은 방법으로 교체함
 * (버블 정렬과 거의 흡사함)
 * @author jwson
 *
 */
public class SelectionSort {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(" 5개만 정렬을 해보도록 하자");
    int[] check = {5, 4, 3, 2, 1};
    System.out.println("정렬 전");
    System.out.println(" 5 4 3 2 1");
    selectionsort(check);
  }
  
  static void selectionsort(int[] list) {
    int temp;
    
    for(int i=0; i <list.length-1 ; i++) {
      System.out.println((i+1) + " 번째 선택 정렬");
      for(int j = i+1; j < list.length ; j++) {
        // 버블 정렬과의 차이점 j = i+1 부터 시작
        if (list[i] > list[j]) {
          temp = list[i];
          list[i] = list[j];
          list[j] = temp;
        }
        
        for(int v: list) {
          System.out.printf("%3d ", v);
        }
        System.out.println();
      }
    }
  }

}
