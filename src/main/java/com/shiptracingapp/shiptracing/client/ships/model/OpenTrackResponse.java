package com.shiptracingapp.shiptracing.client.ships.model;

import lombok.Data;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenTrackResponse {
    private long mmsi;
    private List<Track> tracks;

}
