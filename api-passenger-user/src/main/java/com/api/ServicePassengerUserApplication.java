package com.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.api.*")
@MapperScan("com.api.mapper")
public class ServicePassengerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePassengerUserApplication.class, args);
    }
}
