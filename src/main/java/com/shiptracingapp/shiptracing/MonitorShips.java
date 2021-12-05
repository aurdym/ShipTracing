package com.shiptracingapp.shiptracing;

import com.shiptracingapp.shiptracing.client.ships.ShipsApiClient;
import com.shiptracingapp.shiptracing.client.ships.model.Position;
import com.shiptracingapp.shiptracing.configuration.AreaProperties;
import com.shiptracingapp.shiptracing.controller.Area;
import com.shiptracingapp.shiptracing.controller.Ship;
import com.shiptracingapp.shiptracing.geocoding.DestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonitorShips {

    private final AreaProperties areaProperties;
    private final DestinationService destinationService;
    private final ShipsApiClient shipsApiClient;
    private final TrackService trackService;



    public Area mapArea() {
        return Area.builder()
                .northWestLat(areaProperties.getNorthWestLat())
                .northWestLon(areaProperties.getNorthWestLon())
                .southWestLat(areaProperties.getSouthWestLat())
                .southWestLon(areaProperties.getSouthWestLon())
                .northEastLat(areaProperties.getNorthEastLat())
                .northEastLon(areaProperties.getNorthEastLon())
                .southEastLat(areaProperties.getSouthEastLat())
                .southEastLon(areaProperties.getSouthEastLon())
                .build();
    }



    public List<Ship> mapShips() {
        List<Position> ships = shipsApiClient.getOpenPositions(areaProperties.getSouthWestLon(),
                areaProperties.getNorthEastLon(),
                areaProperties.getSouthEastLat(),
                areaProperties.getNorthEastLat());

        return ships.parallelStream().map(this::mapSingleShip).collect(Collectors.toList());
    }

    private Ship mapSingleShip(Position position) {
        return Ship.builder()
                .sog(position.getSog())
                .destination(destinationService.mapDestnationInfo(position.getDestination()))
                .country(position.getCountry())
                .mmsi(position.getMmsi())
                .lat(position.getGeometry().getCoordinates().get(1))
                .lon(position.getGeometry().getCoordinates().get(0))
                .timeStamp(position.getTimeStamp())
                .name(position.getName())
                .trackPoints(trackService.getTracks(position.getMmsi()))
                .build();
    }




}
