package com.example.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

import static com.fasterxml.jackson.databind.cfg.CoercionInputShape.Array;

@Configuration
public class batchConfig {


    @Bean
    public Job job(JobRepository jobRepository, Step imprimeParImparStep) {
        return new JobBuilder("job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(imprimeParImparStep)
                .build();
    }

    @Bean
    public Step helloWorld(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("helloWorld", jobRepository)
                .tasklet((StepContribution contribution, ChunkContext chunkContext)-> {
                    System.out.println("Hello");
                    return RepeatStatus.FINISHED;
                }, transactionManager).build();
    }

    @Bean
    public IteratorItemReader<Integer> contaAteDezReader() {
        List<Integer> numerosDeUmAteDez = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        return new IteratorItemReader<>(numerosDeUmAteDez.iterator());
    }

    @Bean
    public FunctionItemProcessor<Integer, String> parOuImparProcessor() {
        return new FunctionItemProcessor<>(item ->
                item % 2 == 0
                        ? String.format("Item %s é Par", item)
                        : String.format("Item %s é Ímpar", item)
        );
    }

    @Bean
    public ItemWriter<String> imprimeWriter() {
        return itens -> itens.forEach(System.out::println);
    }
}
