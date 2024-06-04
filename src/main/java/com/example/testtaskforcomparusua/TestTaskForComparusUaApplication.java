package com.example.testtaskforcomparusua;

import com.example.testtaskforcomparusua.entity.User;
import com.example.testtaskforcomparusua.firstDB.repository.UserFirstDBRepository;
import com.example.testtaskforcomparusua.secondDB.repository.UserSecondDBRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories

//@EnableJpaRepositories("com.example.testtaskforcomparusua.*")
//@ComponentScan(basePackages = { "com.example.testtaskforcomparusua.*" })
//@EntityScan("com.example.testtaskforcomparusua..*")
//@EnableAutoConfiguration
public class TestTaskForComparusUaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(TestTaskForComparusUaApplication.class, args);
        var firstDbRepository = context.getBean(UserFirstDBRepository.class);
        var secondDbRepository = context.getBean(UserSecondDBRepository.class);

        firstDbRepository.save(User.builder()
                        .surname("Firs surname")
                        .username("First username")
                        .name("First name")
                .build());

        secondDbRepository.save(User.builder()
                .surname("Second surname")
                .username("Second username")
                .name("Second name")
                .build());
    }

}
