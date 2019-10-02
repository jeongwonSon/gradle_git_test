package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value= "/user")
public class UserController {
  private static final Logger log = LoggerFactory.getLogger(UserController.class);
  
  @Autowired
  private SampleService sampleService;
  
  @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<User> getUserById(@PathVariable("id") long id){
    log.debug("Fetching User with id " + id);
    User user = sampleService.findeById(id);
    if(user==null) {
      return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
    
    return new ResponseEntity<User>(HttpStatus.OK);
  }
  
  @PostMapping(value="/create", headers="Accept=application/json")
  public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
    log.debug("Creating User " + user.getName());
    sampleService.createUser(user);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
    return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
  }
  
  @GetMapping(value="/get", headers="Accept=application/json")
  public List<User> getAllUser(){
    List<User> tasks = sampleService.getUserList();
    return tasks;
  }
  
  @PutMapping(value="/update", headers="Accept=application/json")
  public ResponseEntity<String> updateUser(@RequestBody User currentUser){
    log.debug("user update!");
    User user = sampleService.findeById(currentUser.getId());
    if(user==null) {
      return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
    }
    sampleService.update(currentUser, currentUser.getId());
    return new ResponseEntity<String>(HttpStatus.OK);
  }
}
