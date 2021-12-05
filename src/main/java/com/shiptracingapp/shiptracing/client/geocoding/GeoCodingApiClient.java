package com.shiptracingapp.shiptracing.client.geocoding;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="geocode-api", url="http://api.positionstack.com/v1/forward")
public interface GeoCodingApiClient {

    @GetMapping
    JsonNode getOpenTrack(@RequestParam("access_key") String accessKey,
                          @RequestParam("query") String query);
}
