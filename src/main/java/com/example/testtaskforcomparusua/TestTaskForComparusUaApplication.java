package com.example.testtaskforcomparusua;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TestTaskForComparusUaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestTaskForComparusUaApplication.class, args);
    }

}
