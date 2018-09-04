package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hello;

/**
 * JpaRepository를 상속받은 인터페이스
 * @author jeongwon
 * @description :: http://projects.spring.io/spring-data-jpa/ -> jpa관한 자세한 사항은 여기 참고
 *              JpaRepository<Hello, Integer> 클래스를 상속받아야 사용 가능 함
 *              (이 클래스는 Spring-Data JPA에서 제공하는 클래스로 쿼리에 해당하는 내용들이 정의가 되어있음)
 */
public interface HelloRepository extends JpaRepository<Hello, Integer>{
  
  /*
   * (repositoy 제공 기능)
   * - save() : 레코드 저장(insert, update)
   * - findOne() : primary key로 레코드 한 건 찾기
   * - findAll() : 전체 레코드 불러오기, 정렬(sort), 페이징(pageable) 가능
   * - count() : 레코드 개수
   * - delete() : 레코드 삭제
   */
  
  /*
   * (규칙에 맞는 이름으로 메서드를 추가하면 간단한 select문을 대신할 수 있는 조회기능 추가 가능!)
   * - findBy로 시작 : 쿼리를 요청하는 메서드임을 알림
   * - countBy로 시작 : 쿼리 결과 레코드 수 요청하는 메서드 임을 알림
   * 
   * (query method에 포함할 수 있는 키워드)
   * - and : findByEmailAndUserId(String email, String userId) ; 여러 필드를 and로 검색
   * - or : findByEmailOrUserId(String email, String userId) ; 여러 필드를 or로 검색
   * - between : findByCreatedAtBetween(Date fromDate, Date toDate) ; 필드의 두 값 사이에 있는 항목 검색
   * - lessThan : findByAgeLessThanEqual(int age) ; 작은 항목 검색
   * - greaterThanEqual : findByAgeGraterThanEqual(int age) ; 크거나 같은 항목 검색
   * - like : findByNameLike(String name) ; like 검색
   * - isNull : findByJobIsNull() ; null 인 항목 검색
   * - In : findByJob(String,.. jobs) ; 여러 값 중에 하나인 항목 검색
   * - OrderBy : findByEmailOrderByNameAsc(String email) ; 검색 결과를 정렬하여 전달
   */
  
}
