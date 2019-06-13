package com.practice.springcloud.ribbon.server.sayhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling
public class ServerSayHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerSayHelloApplication.class, args);
    }
}