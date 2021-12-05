package com.shiptracingapp.shiptracing.controller;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Response {
    private Area area;
    private List<Ship> ships;
}
