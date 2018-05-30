package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserRepository;
import com.example.demo.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
  /*
   * 예제에서 본 builder()는 lombok을 사용할때 할 수 있음
   */
  @Autowired
  private UserRepository userRepository;
  
  @After
  public void cleanUp() {
    /**
     * 이후 테스트 코드에 영향을 끼치지 않기 위해
     * 테스트 메소드가 끝날 때 마다 repository 전체 비우는 코드
     */
    userRepository.deleteAll();
  }
  
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
