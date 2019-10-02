package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * JpaRepository를 상속받는 것만으로도 기본적인 CRUD가 가능함.
 * (query-creation을 이용하여 쿼리를 작성할 수 있음)
 */
public interface UserRepository extends JpaRepository<User, Long>{

}
