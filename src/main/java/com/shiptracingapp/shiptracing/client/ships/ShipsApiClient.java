package com.shiptracingapp.shiptracing.client.ships;

import com.shiptracingapp.shiptracing.client.ships.model.OpenTrackResponse;
import com.shiptracingapp.shiptracing.client.ships.model.Position;
import com.shiptracingapp.shiptracing.configuration.ShipFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value="ships-api", url="https://www.barentswatch.no/bwapi", configuration = ShipFeignClientConfiguration.class)
public interface ShipsApiClient {
    @GetMapping(value = "/v2/geodata/ais/openpositions")
    List<Position> getOpenPositions(@RequestParam("Xmin") double xMin,
                                    @RequestParam("Xmax") double xMax,
                                    @RequestParam("Ymin") double yMin,
                                    @RequestParam("Ymax") double yMax);

    @GetMapping(value = "/v1/geodata/ais/{mmsi}/opentracks")
    OpenTrackResponse getOpenTrack(@PathVariable("mmsi") long mmsi);
}
