package com.shah.photo.app.photodiscoveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PhotoDiscoveryAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoDiscoveryAppApplication.class, args);
    }

}
