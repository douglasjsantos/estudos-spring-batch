package com.example.demo.step;

import com.example.demo.dto.UserDTO;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

public class FetchUserDataAndStoreDBStepConfig {

    private PlatformTransactionManager transactionManager;

    @Bean
    public Step FetchUserDataAndStoreDBStep(ItemReader<UserDTO> fetchUserDataReader, JobRepository jobRepository){
        return new StepBuilder("fetchUserDataAndStoreDBStep", jobRepository)
                .<UserDTO, UserDTO>chunk(5, transactionManager)
                .reader(fetchUserDataReader)
                .build();
    }
}
