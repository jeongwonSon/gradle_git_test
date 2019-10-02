package com.example.demo.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

//@Configuration // 기본 설정 선언
//@EnableBatchProcessing // 기본 설정 선언
@EnableScheduling // 스케줄러 사용 선언
public class Launcher1Job1Step1 { // http://www.javainuse.com/spring/bootbatch 참고

  private static final String BATCH_NAME = "BaseJobStep";

  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  @Autowired
  private StepBuilderFactory stepBuilderFactory;
  @Autowired
  private SimpleJobLauncher jobLauncher;

  /**
   * 스케쥴러
   * 
   * 주기적으로 Job 실행 cron 설정에 따라 실행 jobLauncher 1개당 job 1+ 와 step 1+ 를 사용가능
   * 
   * @throws Exception
   */
  @Scheduled(cron = "1 * * * * *")
  public void scheduler() throws Exception {
    String jobId = String.valueOf(System.currentTimeMillis());

    System.out.println("Started jobId : " + jobId);

    JobParameters param = new JobParametersBuilder().addString("JobID", jobId).toJobParameters();
    JobExecution execution = jobLauncher.run(baseJob(), param);

    System.out.println("end : " + param.getString("JobID") + ":::" + execution.getStatus());
  }

  /**
   * 배치 Job
   * 
   * baseStep 호출한다
   * 
   * @return
   */
  @Bean
  public Job baseJob() {
    return jobBuilderFactory.get("[Job - " + BATCH_NAME + "]").start(baseStep()).build();
  }

  /**
   * 배치 Step
   * 
   * <pre>
   * reader() : 더미 데이터 생성
   * writer() : sysout 찍기
   * </pre>
   * 
   * @return
   */
  @Bean
  public Step baseStep() { // chunk 큰덩어리 프로세스단위
    return stepBuilderFactory.get("[Step - " + BATCH_NAME + "]").<String, String>chunk(20).reader(sampleItemReader())
        .processor(sampleItemProcessor()).writer(sampleItemWriter()).build();
  }

  @Bean
  public ItemReader<String> sampleItemReader() {

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

  @Bean
  public ItemProcessor<String, String> sampleItemProcessor() {
    return new ItemProcessor<String, String>() {

      @Override
      public String process(String data) throws Exception {
        return data.toUpperCase();
      }
    };
  }

  @Bean
  public ItemWriter<String> sampleItemWriter() {
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
