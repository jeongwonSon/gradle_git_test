package com.example.demo.batch.step;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleStepConfig {
  
  /*
   * chunk는 하나의 트랜잭션 안에서 처리할 read의 단위를 설정함.
   * 3이라면 3개의 아이템을 하나의 트랜잭션 안에서 읽은 후 한번에 write 함.
   */
  
  private static final String STEP_NAME = "SampleStep";
  
  /**
   * step을 생성하기 위해 주입함.
   */
  @Autowired
  private StepBuilderFactory stepBuilderFactory;
  
  /**
   * mybatis를 사용하면 SqlSessionFactory 사용, jpa를 쓸 경우 EntityManagerFactory를 사용한다.
   * 
   * ---> 2018년 5월 30일 jpa 추가함(entityManagerFactory 추가)
   */
//  @Autowired
//  private SqlSessionFactory sqlSessionFactory;
  @Autowired
  private EntityManagerFactory EntityManagerFactory;
  
  @Bean
  public Step sampleStep() {
    return stepBuilderFactory.get(STEP_NAME)
        .<String, String>chunk(1)
        .reader(sampleItemReader())
//        .processor(sampleItemProcessor())
        .writer(sampleItemWriter())
        .build();
  }
  
  @Bean
  public ItemReader<String> sampleItemReader(){
    // sample에는 여기서 mybatis(db)읽어오는 부분이 있지만, db 사용하지 않음
    ItemReader<String> reader = new ItemReader<String>() {
      String[] messages = { "sample data", "Welcome to Spring Batch Example", "Database for this example" };
      int count = 0;

      @Override
      public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < messages.length) {
          return messages[count++];
        } else {
          count = 0;
        }
        return null;
      }
    };

    return reader;
  }
  
  /**
   * ItemProcessor는 정의하지 않는 경우에는 ItemReader에서 바로 ItemWriter로 넘어간다.
   * 로직을 추가할 필요가 있는 경우에는 ItemProcessor 인터페이스를 구현하고
   * process()메소드를 오버라이드 해서 구현하면 프로세서를 거쳐간다.
   */
//  @Bean
//  public ItemProcessor<String, String> sampleItemProcessor(){
//    return new SampleItemProcessor();
//  }
  
  public ItemWriter<String> sampleItemWriter(){
    // 여기도 reader 처럼 mybatis 관련
    ItemWriter<String> writer = new ItemWriter<String>() {

      @Override
      public void write(List<? extends String> items) throws Exception {
        for (String msg : items) {
          System.out.println("the data " + msg);
        }
      }
    };
    return writer;
  }
}
