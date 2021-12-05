package com.shiptracingapp.shiptracing.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ships-api")
@Getter
@Setter
public class ShipsApiProperties {
    private String clientId;
    private String secret;
}
