package com.shiptracingapp.shiptracing.client.ships.model;

import lombok.Data;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.time.Instant;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class IntervalPoint {
    private double lat;
    private double lon;
    private Instant msgt;
}
