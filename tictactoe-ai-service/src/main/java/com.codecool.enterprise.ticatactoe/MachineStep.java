package com.codecool.enterprise.ticatactoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MachineStep {

    public static void main(String[] args) {
        SpringApplication.run(MachineStep.class, args);
    }

}
