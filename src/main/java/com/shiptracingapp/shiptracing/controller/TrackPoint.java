package com.shiptracingapp.shiptracing.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class TrackPoint {
    private final double lat;
    private final double lon;
}
