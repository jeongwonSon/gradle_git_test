package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Hello;

/**
 * JpaRepository를 상속받은 인터페이스
 * @author jeongwon
 * @description :: http://projects.spring.io/spring-data-jpa/ -> jpa관한 자세한 사항은 여기 참고
 */
@Repository
public interface HelloDao extends JpaRepository<Hello, Integer>{

}
