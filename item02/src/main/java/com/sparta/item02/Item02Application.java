package com.sparta.item02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Item02Application {

    public static void main(String[] args) {
        SpringApplication.run(Item02Application.class, args);
    }

}
