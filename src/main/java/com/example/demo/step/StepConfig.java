package com.example.demo.step;

import com.example.demo.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StepConfig {

    @Bean
    public Step printPersonStep(
            ItemReader<Person> personItemReader,
            ItemWriter<Person> personItemWriter,
            JobRepository jobRepository,
            PlatformTransactionManager transactionManager
    ) {
        return new StepBuilder("printPersonStep", jobRepository)
                .<Person, Person>chunk(5, transactionManager)
                .reader(personItemReader)
                .writer(personItemWriter)
                .build();
    }


}
