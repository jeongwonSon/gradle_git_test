package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // @bean 설정등 spring 환경설정
@EnableBatchProcessing  // 배치기능 활성화 
// 배치 사용 환경 설정 :: 사용자는 컨텍스트에서 Bean으로 DataSource를 제공해야하며 그렇지 않으면 BatchConfigurer를
// 구성 클래스 자체에 구현해야합니다. 해당경우 MapJobRepositoryFactoryBean 추가함
public class BatchConfig extends DefaultBatchConfigurer{

  @Override
  public void setDataSource(DataSource dataSource) {
      //This BatchConfigurer ignores any DataSource (extends DefaultBatchConfigurer :: 추가필요)
  }
  
  @Bean
  public ResourcelessTransactionManager transactionManager() { // MapJobRepositoryFactoryBean 주입하기 위한 필수 Bean
    return new ResourcelessTransactionManager();
  }

  @Bean // 비 영구적 인 메모리 DAO 구현을 사용하여 SimpleJobRepository의 생성을 자동화하는 FactoryBean 메타데이터를
        // 기록하고 싶지 않다면, 메모리에 메타데이터를 저장할
  public MapJobRepositoryFactoryBean mapJobRepositoryFactory(ResourcelessTransactionManager txManager)
      throws Exception {
    MapJobRepositoryFactoryBean factory = new MapJobRepositoryFactoryBean(txManager);
    factory.afterPropertiesSet();

    return factory;
  }

  @Bean // 데이터 소스 사용 저장소 설정 bean
  public JobRepository jobRepository(MapJobRepositoryFactoryBean factory) throws Exception {
    return factory.getObject();
  }

  @Bean // jobLauncher 를 사용하기 위한 bean //http://opennote46.tistory.com/76
  public SimpleJobLauncher jobLauncher(JobRepository jobRepository) {
    SimpleJobLauncher launcher = new SimpleJobLauncher();
    launcher.setJobRepository(jobRepository);
    return launcher;
  }
}
