package com.shiptracingapp.shiptracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableFeignClients
@SpringBootApplication
@EnableOAuth2Client
@EnableConfigurationProperties
public class ShipTracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipTracingApplication.class, args);
    }

}
