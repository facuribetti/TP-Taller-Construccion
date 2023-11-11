package com.taller.contruccion;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ContruccionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContruccionApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return runner -> {
            System.out.println("hello");
        };
    }
}