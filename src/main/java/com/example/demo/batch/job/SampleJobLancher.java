package com.example.demo.batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration // 기본 설정 선언
@EnableBatchProcessing // 기본 설정 선언
@EnableScheduling // 스케줄러 사용 선언
public class SampleJobLancher {

  /**
   * 이전에 했던 Lancher1Job1Step1.java 파일은 복붙만 했던거라 좀 더 분석해보는
   * SampleJobLancher.java 파일 생성!
   * 
   * @Configuration :: 설정파일임을 명시
   * @EnableBatchProcessing :: Job 생성에 필요한 핀들을 자동으로 가져온다
   * 
   * Job을 생성하기 위해서 JobBuilderFactory를 가져오고, Job에 들어갈 Step도 가져온다.
   * (Step파일을 따로 만들 경우, 해당 Step이름으로 자동 주입시키면 되고, 아니면 Job 설정
   * 파일에 Step빈을 같이 설정해도 무관함 -> Job설정파일에 Step빈을 같이 설정한 경우 예제(Lancher1Job1Step1.java)
   */
  
  private static final String JOB_NAME = "SampleJob";
  
  @Autowired
  private JobBuilderFactory jobBuilderFactory;
  
  @Autowired
  private SimpleJobLauncher jobLauncher;
  
  @Autowired
  private Step stepName;
  
//  @Autowired
//  private SampleTasklet sampleTasklet;
  
  @Scheduled(cron = "2 * * * * *")
  public void sampleSchedulerBatch() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
    String jobId = String.valueOf(System.currentTimeMillis());
    
    System.out.println("Started sample Batch ============== " + jobId);
    JobParameters param = new JobParametersBuilder().addString("jobId", jobId).toJobParameters();
    JobExecution execution = jobLauncher.run(sampleJob(),param);
    
    System.out.println("End sample Batch ============== " + execution.getStatus());
  }
  
  @Bean
  public Job sampleJob() {
    return jobBuilderFactory.get(JOB_NAME)
          .start(stepName)
          .build();
  }
}
