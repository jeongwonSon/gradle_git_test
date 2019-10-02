package com.example.demo.dao;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * - 메소드 이름 기반으로 해서 만들어도 되고, @Query를 이용해 기존의 SQL처럼 만들어도 됨
 */
public interface MemberRepository  extends JpaRepository<Member, Long>{
  
  List<Member> findByNameAndAgeLessThan(String name, int age);
  
  @Query("select t from Member t where name=:name and age<:age")
  List<Member> findByNameAndAgeLessThanSQL(@Param("name") String name, @Param("age") int age);
  
  List<Member> findByNameAndAgeLessThanOrderByAgeDesc(String name, int age);
}
