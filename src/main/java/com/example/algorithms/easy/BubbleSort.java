package com.example.algorithms.easy;

/**
 * 버블 정렬 : 두 인접한 원소를 검사하여 정렬하는 방법
 * 시간복잡도가 상당히 느린 편이지만 코드가 단순하여 자주 사용됨
 * @author jwson
 *
 */
public class BubbleSort {
  
  public static void main(String[] args) {
    System.out.println(" 5개만 정렬해볼게요!");
    int[] check = {5,4,3,2,1};
    System.out.println(" ----- 정렬 전");
    System.out.println("    5  4  3  2  1 ");
    bubbleSort(check);
  }
  
  public static void bubbleSort(int a[]) {
    int size = a.length;
    for (int i = size-1; i>0 ; i-- ) {
      System.out.printf(" \n 버블 정렬 %d 단계 : ", size-i);
      for (int j=0; j<i; j++) {
        if (a[j] > a[j+1]) {
          swap(a,j,j+1);
        }
        System.out.printf("\n\t");
        for(int v : a) {
          System.out.printf("%3d ", v);
        }
      }
    }
  }
  
  public static void swap(int a[], int idx1, int idx2) {
    int temp = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = temp;
  }
}
