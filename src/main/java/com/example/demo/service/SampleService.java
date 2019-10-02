package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.List;

public interface SampleService {

  public void createUser(User user);
  
  public List<User> getUserList();
  
  public User findeById(long id);
  
  public User update(User user, long id);
  
}
