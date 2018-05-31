package com.example.demo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Junit 호출 순서 test
 *  
 *  @BeforeClass
 *  
 *  @Before
 *  @Test
 *  @After
 *  
 *  @AfterClass
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JunitCallTest {
  /*
   * 실행 결과 -------------
   *  @Before
   *  testCase1
   *  @After
   *  @Before
   *  testCase2
   *  @After
   *  @AfterClass
   *
   * -----------------------
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    System.out.println("@BeforeClass");
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    System.out.println("@AfterClass");
  }

  @Before
  public void setUp() throws Exception {
    System.out.println("@Before");
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("@After");
  }

  @Test
  public void testCase1() throws Exception {
    System.out.println("testCase1");
  }

  @Test
  public void testCase2() throws Exception {
    System.out.println("testCase2");
  }
}
