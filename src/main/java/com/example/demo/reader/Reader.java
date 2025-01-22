package com.example.demo.reader;

import com.example.demo.model.Person;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class Reader {

    @Bean
    public FlatFileItemReader<Person> userFileReader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("userFileReader")
                .resource(new ClassPathResource("data.txt")) // Arquivo de dados
                .linesToSkip(1) // Ignorar o cabeçalho
                .delimited()
                .delimiter(",") // Separador de campos
                .names("name", "age") // Colunas do arquivo
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(Person.class); // Classe alvo
                }})
                .build();
    }

}
