package com.shiptracingapp.shiptracing.geocoding;

import com.shiptracingapp.shiptracing.client.geocoding.DestinationResponse;
import com.shiptracingapp.shiptracing.client.geocoding.GeoCodingClientFacade;
import com.shiptracingapp.shiptracing.controller.DestinationInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DestinationService {
    private final GeoCodingClientFacade client;
    private final DestinationRepo repo;

    public DestinationInfo mapDestnationInfo(String destinationName) {

        if(destinationName == null || destinationName.isEmpty()) {
            return null;
        }

        DestinationEntity destinationEntity = repo.findFirstByName(destinationName);

        if (destinationEntity == null) {
            DestinationResponse destinationResponse = client.getDestinationData(destinationName);


            DestinationEntity entity = new DestinationEntity();
            entity.setCountry(destinationResponse.getCountry());
            entity.setName(destinationResponse.getName());
            entity.setLat(destinationResponse.getLat());
            entity.setLon(destinationResponse.getLon());
            repo.saveAndFlush(entity);
            if(entity.anySignificantFieldNull()) {
                return null;
            }


            return DestinationInfo
                    .builder()
                    .country(destinationResponse.getCountry())
                    .name(destinationResponse.getName())
                    .lat(destinationResponse.getLat())
                    .lon(destinationResponse.getLon())
                    .build();
        }

        return DestinationInfo
                .builder()
                .country(destinationEntity.getCountry())
                .name(destinationEntity.getName())
                .lat(destinationEntity.getLat())
                .lon(destinationEntity.getLon())
                .build();

    }
}
