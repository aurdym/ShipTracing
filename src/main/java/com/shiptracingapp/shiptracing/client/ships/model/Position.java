package com.shiptracingapp.shiptracing.client.ships.model;

import lombok.Data;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.time.Instant;

@Getter
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Position {

    private Instant timeStamp;
    private double sog;
    private long mmsi;
    private Geometry geometry;
    private String name;
    private String country;
    private String destination;
}
