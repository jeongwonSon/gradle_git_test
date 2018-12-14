package com.example.demo.domain;

import java.math.BigInteger;
import java.util.Optional;

public class Employee01 implements Comparable<Employee01>{

  private int id;
  private String name;
  private String department;
  private String position;
  
  /**
   * [BigInteger 클래스]
   * 임의 자리의 정수를 표현하는 클래스로 String처럼 immutable 속성을 가지고 있음.
   * int 타입과 마찬가지로 사칙연산자를 메서드 형태로 제공하며, 유용한 수학적 메서드들도 함께 사용할 수 있음.
   */
  
  private BigInteger sales;
  
  public Employee01() {};
  
  // 생성자
  public Employee01(int id, String name, String department, String position, BigInteger sales) {
    this.id = id;
    this.name = name;
    this.department = department;
    this.position = position;
    this.sales = sales;
  }
  
  // console 찍을때 필요해서
  public String toString() {
    
    String returnValue = "id=" + this.id + " ,  name=" +this.name + ", department="
                        + this.department + ", position=" + this.position + ", sales = " + this.sales + "\n";
    
    return returnValue;
  }

  /**
   * 클래스에 implements로 comparable 확장을 함 --> compareTo()메서드를 사용함
   */
  @Override
  public int compareTo(Employee01 o) {
    /*
     *  파라미터로 비교되는 대상이 되는 객체가 들어온다. int 타입을 반환한다.
     *  A.compareTo(B)일 때 A<B 인 경우는 음수를 리턴하고, A=B일 때는 0을 리턴하고, A>B일 때 양수를 리턴한다.
     *  정렬에서 앞에 오고 싶을때 음수를 내보내면 된다.( -1, 0, 1 만 사용하는 것이 아니다)
     *  a.compareTo(b) == -(b.compareTo(a)) 조건을 만족하게 구성해주면 됨
     */
    return this.name.compareTo(o.name);
  }
  
  public Employee01 method1() {
    Employee01 emp = new Employee01();
    emp.setName("optional");
    return emp;
  }
  
  // optional 예제
  public void test() {
    // 해당 객체의 null을 검사할 수 있는 Wrapper 클래스를 만든다.
    Optional<Employee01> optEmployee01 = Optional.ofNullable(method1());
    // ifPresent로 직접 해당 객체가 null이 아닐 때 action을 줄 수 있고
    optEmployee01.ifPresent(x -> System.out.println(x.getName()));
    // orElse로 받아온 객체가 null일 때는 빈 객체를 만들어서 리턴받을 수도 있다.
    Employee01 emp = optEmployee01.orElse(new Employee01());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public BigInteger getSales() {
    return sales;
  }

  public void setSales(BigInteger sales) {
    this.sales = sales;
  }
  
}
