package com.shiptracingapp.shiptracing.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Area {
    private double northWestLon;
    private double northWestLat;
    private double southWestLon;
    private double southWestLat;
    private double northEastLon;
    private double northEastLat;
    private double southEastLon;
    private double southEastLat;
}
