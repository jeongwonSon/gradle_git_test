package com.example.demo.domain;

import javax.persistence.*;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  
  /*
   * TODO:: jpa로 암호화하는 거 찾아보기
   * (참고) https://stackoverflow.com/questions/34259457/how-to-encrypt-decypt-data-with-custom-anotationhibernate-in-spring-project
   */
//  @Encrypt
  @Convert(converter = PasswordConverter.class)
  @Column(length=300, nullable=false)
  private String password;
  
  @Column(length=20, nullable=false)
  private String name;
  
  @Column(length=20, nullable=false, unique=true)
  private String phone;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Long getId() {
    return id;
  }
  
  /*
   * 변수값을 계속 꺼내서 비교하는 것이 아닌, 객체에게 메시지를 보내 겍체에게 일을 시킴.
   * 객체 지향적으로 코드를 작성하려면, private으로 캡슐화 되어있는 객체의 변수를 계속 노출시키는 것을 피해야 함
   */
  public boolean matchPassword(String newPassword) {
    if(newPassword == null) {
      return false;
    }
    return newPassword.equals(password);
  }
  
}
