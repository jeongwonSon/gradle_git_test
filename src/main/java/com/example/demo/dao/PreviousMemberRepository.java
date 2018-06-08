package com.example.demo.dao;

import com.example.demo.domain.PreviousMember;

public interface PreviousMemberRepository {
  
  PreviousMember findByNameNoCache(String name);
  PreviousMember findByNameCache(String name);
  void refresh(String name);

}
