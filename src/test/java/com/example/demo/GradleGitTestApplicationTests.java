package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @SpringBootTest : 테스트에 사용할 applicationContext를 쉽게 생성하고 조작할 수 있음
 * 반드시 @RunWith(SpringRunner.class)와 함께 사용해야 함
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GradleGitTestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
