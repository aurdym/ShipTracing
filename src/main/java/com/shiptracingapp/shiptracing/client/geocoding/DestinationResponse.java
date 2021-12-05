package com.shiptracingapp.shiptracing.client.geocoding;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class DestinationResponse {

    private String name;
    private String country;
    private double lat;
    private double lon;
}
