package com.example.algorithms.easy;

import java.util.Scanner;

/**
 * 사칙연산 문제
 * @author jwson
 *
 */
public class FourRules1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("숫자 두개와 사칙연산을 입력해주세요(ex : 4 + 2 )");
    String str = sc.nextLine();
    String[] ans = new String[2];
    int plus = str.indexOf("+");
    int minus = str.indexOf("-");
    int multiplx = str.indexOf("*");
    int division = str.indexOf("/");
    
    /**
     * indexOf는 괄호 안의 요소가 몇번째에 있는지 알려줌
     * java split은 문자열을 나누는 메서드
     * split(".") 으로 쓰면 작동을 하지 않는다 -> split("\\.")으로 써야 작동함
     * (split 인자로 들어가는 String 토큰이 regex 정규식이기 때문임, 정규식에서 .은
     * 무작위의 한글자를 의미함, 그럼 모든 문자가 토큰이 되기 때문에 배열에 남는 것이 없음) 
     * ( \ 만 써야하는 경우도 있음 : \b \t \n \f\ \r \" \' \\ )
     */
    
    
    if (plus >= 0) {
      ans = str.split("\\+");
      System.out.println(Integer.parseInt(ans[0])+Integer.parseInt(ans[1]));
    } else if (minus >= 0) {
      ans = str.split("\\-");
      System.out.println(Integer.parseInt(ans[0])-Integer.parseInt(ans[1]));
    } else if (multiplx >= 0) {
      ans = str.split("\\*");
      System.out.println(Integer.parseInt(ans[0])*Integer.parseInt(ans[1]));
    } else if (division >= 0) {
      ans = str.split("\\/");
      // 캐스팅 계산시 어느 한쪽만 해주어도 계산이 된다.
      double temp = Integer.parseInt(ans[0])/(double)Integer.parseInt(ans[1]);
      // 소수점 2자리까지 표현
      System.out.printf("%1.2f", temp);
    }
  }
}
