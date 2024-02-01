package com.group1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ManagerMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerMicroServiceApplication.class);
    }
}