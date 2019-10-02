package com.example.demo.batch.job;

import com.example.demo.service.SampleService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleTasklet implements Tasklet{

  @Autowired
  private SampleService sampleService;
  
  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    // TODO Auto-generated method stub
    return null;
  }

}
