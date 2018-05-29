package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEMBER")
public class Member {
  
  /**
   * @Entity 
   *  - table과 mapping한다고 JPA에 알려줌
   * @Table
   *  - entity class와 매핑할 table 정보를 알려줌
   *  - "name"속성을 사용해서 member 엔티티를 MEMBER table에 매핑
   *  - 이 어노테이션을 생략하면 "클래스 이름" 대로 table name으로 mapping
   * @Id
   *  - entity class의 field를 table의 기본 키(pk)에 mapping
   *  - entity의 id field를 table의 ID 기본 키(pk) 컬럼에 매핑
   *  - @Id가 사용된 필드를 [식별자 필드]라고 한다.
   *  
   * @Column
   *  - 필드를 컬럼에 매핑함
   *  - name속성을 사용해서 member 엔티티의 username 필드를 table의 name 컬럼에 매핑
   * [매핑 정보가 없는 필드]
   *  - 매핑 어노테이션을 생략하면 필드명을 사용해서 컬럼명으로 매핑
   *  - 필드명이 age이므로 age 컬럼으로 매핑
   *  - 만약, 대소문자를 구분하는 db를 사용하려면 @Column(name="AGE")처럼 명시적으로 매핑해야 함
   */
  
  @Id
  @Column(name="ID")
  private Long id;
  
  @Column(name="NAME")
  private String username;
  private Integer age;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public Integer getAge() {
    return age;
  }
  public void setAge(Integer age) {
    this.age = age;
  }
}
