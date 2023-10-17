package com.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@Slf4j
@EnableDiscoveryClient
public class UserLoginGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserLoginGateWayApplication.class,args);
        log.info("Connect Successfully!");
    }
}
