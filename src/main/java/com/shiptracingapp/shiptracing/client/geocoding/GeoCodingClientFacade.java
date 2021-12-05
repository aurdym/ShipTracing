package com.shiptracingapp.shiptracing.client.geocoding;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeoCodingClientFacade {

    private final GeoCodingApiClient geoCodingApiClient;

    @Value("${geocoding.apiKey}")
    private String geocodingApiKey;

    public DestinationResponse getDestinationData(String destinationName) {
        JsonNode geoCodingResponse = geoCodingApiClient.getOpenTrack(geocodingApiKey, destinationName);

        return  geoCodingResponse.get("data").isEmpty() ?
                DestinationResponse.builder().name(destinationName).build():
                DestinationResponse
                        .builder()
                        .name(destinationName)
                        .country(geoCodingResponse.path("data").get(0).get("country").asText())
                        .lon(geoCodingResponse.path("data").get(0).get("longitude").asDouble())
                        .lat(geoCodingResponse.path("data").get(0).get("latitude").asDouble())
                        .build();
    }
}
