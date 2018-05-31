package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.User;

public interface SampleService {

  public void createUser(User user);
  
  public List<User> getUserList();
  
  public User findeById(long id);
  
  public User update(User user, long id);
  
}
