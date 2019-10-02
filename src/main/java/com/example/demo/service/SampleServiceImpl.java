package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SampleServiceImpl implements SampleService{
  
  // 해당 서비스 로그 쓰기 위해서
  private static final Logger log = LoggerFactory.getLogger(SampleServiceImpl.class);

  @Autowired
  private UserRepository userRepository;
  
  @Override
  public void createUser(User user) {
    userRepository.save(user);
  }

  @Override
  public List<User> getUserList() {
    return (List<User>)userRepository.findAll();
  }

  @Override
  public User findeById(long id) {
    return userRepository.getOne(id);
  }

  @Override
  public User update(User user, long id) {
    return userRepository.save(user);
  }

}
