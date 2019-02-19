package com.example.demo.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Journal;

public interface JournalRepository extends JpaRepository<Journal, Long>{
  /*
   * JpaRepository 인터페이스를 확장해서 JPA 기술 구현
   * 
   */
}
