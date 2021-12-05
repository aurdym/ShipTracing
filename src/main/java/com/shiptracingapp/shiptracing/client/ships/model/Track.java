package com.shiptracingapp.shiptracing.client.ships.model;

import lombok.Data;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.time.Instant;
import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {
    private Instant fromTime;
    private Instant toTime;
    private List<IntervalPoint> intervalPoints;
}
