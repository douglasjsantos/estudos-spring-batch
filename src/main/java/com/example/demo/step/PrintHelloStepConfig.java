package com.example.demo.step;

import com.example.demo.tasklet.PrintHelloTasklet;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class PrintHelloStepConfig {



    @Bean
    public Step printHelloStep(JobRepository jobRepository, PlatformTransactionManager transactionManager, PrintHelloTasklet printHelloTasklet){
        return new StepBuilder("printHelloStep", jobRepository)
                .tasklet(printHelloTasklet, transactionManager).build();
    }
}
