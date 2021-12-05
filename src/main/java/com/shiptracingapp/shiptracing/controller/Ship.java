package com.shiptracingapp.shiptracing.controller;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Ship {
    private Instant timeStamp;
    private double sog;
    private long mmsi;
    private double lat;
    private double lon;
    private String name;
    private String country;
    private DestinationInfo destination;
    private List<TrackPoint> trackPoints;

}
