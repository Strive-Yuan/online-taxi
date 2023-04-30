package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.api.*")
public class VerificationCodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(VerificationCodeApplication.class, args);
    }
}
