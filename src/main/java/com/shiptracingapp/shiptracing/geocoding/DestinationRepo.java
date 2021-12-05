package com.shiptracingapp.shiptracing.geocoding;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepo extends JpaRepository<DestinationEntity, String> {
    DestinationEntity findFirstByName(String name);
}
