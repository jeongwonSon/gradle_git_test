package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

/**
 * Junit 호출 순서
 * 
 *  @BeforeClass
 *  
 *  @Before
 *  @Test
 *  @After
 *  
 *  @AfterClass
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
  /*
   * 예제에서 본 builder()는 lombok을 사용할때 할 수 있음
   */
  @Autowired
  private UserRepository userRepository;
  
  /**
   * 단위 테스트 시작 전, 공통적으로 초기화되는 코드
   */
  @Before
  public void setUp() {
    
  }
  
  /**
   * 단위 테스트 종료 후, 공통적으로 적용될 로직
   * : 엔티티를 생성하고 기본 정보를 소거하는 등의 작업 진행
   * : transactional이 걸려있다면 엔티티는 신경안써도 됨!
   */
  @After
  public void cleanUp() {
    /**
     * 이후 테스트 코드에 영향을 끼치지 않기 위해
     * 테스트 메소드가 끝날 때 마다 repository 전체 비우는 코드
     */
    userRepository.deleteAll();
  }
  
  /**
   * - given 
   *   : 테스트 기반 환경을 구축하는 단계, @builder 사용법도 함께 확인
   * - when
   *   : 테스트 하고자 하는 행위 선언, posts가 db에 insert 되는 것을 확인하기 위함
   * - then
   *   : 테스트 결과 검증, 실제로 db에 insert 되었는 지 확인하기 위해 조회 후, 입력된 값 확인
   */
  
  @Test
  public void 유저_불러오기() {
    User user = new User();
    user.setName("테스트");
    user.setPhone("010-0000-0000");
    
    // given
    userRepository.save(user);
    
    // when
    List<User> userList = userRepository.findAll();
    
    // then
    User tempUser = userList.get(0);
    assertThat(tempUser.getName(), is("유저 이름"));
    assertThat(tempUser.getPhone(), is("유저의 전화번호"));
  }
}
