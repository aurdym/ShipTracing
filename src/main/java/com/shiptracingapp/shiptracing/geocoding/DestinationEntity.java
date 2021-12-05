package com.shiptracingapp.shiptracing.geocoding;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DestinationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String country;
    private Double lat;
    private Double lon;

    public boolean anySignificantFieldNull(){
        return name == null || lat == null || lon == null;
    }

}
