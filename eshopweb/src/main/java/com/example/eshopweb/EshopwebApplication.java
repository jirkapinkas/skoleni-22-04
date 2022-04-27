package com.example.eshopweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
@EnableAsync
@SpringBootApplication
public class EshopwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(EshopwebApplication.class, args);
    }

}
