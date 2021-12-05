package com.shiptracingapp.shiptracing;

import com.shiptracingapp.shiptracing.client.ships.ShipsApiClient;
import com.shiptracingapp.shiptracing.client.ships.model.IntervalPoint;
import com.shiptracingapp.shiptracing.client.ships.model.OpenTrackResponse;
import com.shiptracingapp.shiptracing.controller.TrackPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TrackService {
    private final ShipsApiClient apiClient;


    public List<TrackPoint> getTracks(long shipId) {
        List<TrackPoint> list = getTracksFromApi(shipId);

        return list;
    }

    private List<TrackPoint> getTracksFromApi(long shipId) {
        OpenTrackResponse response = apiClient.getOpenTrack(shipId);

        return response.getTracks().stream()
                .flatMap($->$.getIntervalPoints().stream())
                .sorted(Comparator.comparing(IntervalPoint::getMsgt))
                .map($ -> new TrackPoint($.getLat(), $.getLon()))
                .collect(Collectors.toList());
    }
}
