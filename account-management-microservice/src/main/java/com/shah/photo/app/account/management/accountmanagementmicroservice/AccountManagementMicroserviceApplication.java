package com.shah.photo.app.account.management.accountmanagementmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountManagementMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagementMicroserviceApplication.class, args);
    }

}
