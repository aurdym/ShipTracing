package com.shiptracingapp.shiptracing.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "area")
@Getter
@Setter
public class AreaProperties {
    private double northWestLon;
    private double northWestLat;
    private double southWestLat;
    private double southWestLon;
    private double northEastLon;
    private double northEastLat;
    private double southEastLon;
    private double southEastLat;
}
