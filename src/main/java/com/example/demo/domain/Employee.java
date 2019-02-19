package com.example.demo.domain;

import lombok.Data;

@Data
//@Entity
public class Employee {
  
  private Long id;
  private String firstName;
  private String lastName;
  private String description;
  
  private Employee() {}
  
  public Employee(String firstName, String lastName, String description) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.description = description;
  }
}
