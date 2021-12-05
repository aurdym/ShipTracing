package com.shiptracingapp.shiptracing.controller;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DestinationInfo {
    private String name;
    private String country;
    private double lat;
    private double lon;
}
