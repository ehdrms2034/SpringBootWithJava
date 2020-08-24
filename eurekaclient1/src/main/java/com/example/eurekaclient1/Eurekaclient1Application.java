package com.example.eurekaclient1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Eurekaclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(Eurekaclient1Application.class, args);
    }

}
