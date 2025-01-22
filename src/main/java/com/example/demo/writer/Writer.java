package com.example.demo.writer;

import com.example.demo.model.Person;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<Person> {

    @Override
    public void write(Chunk<? extends Person> items) throws Exception {
        items.forEach(System.out::println); // Imprime cada pessoa no console
    }


}