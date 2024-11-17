package com.homeypark.web_service.parkings.interfaces.rest.transformers;


import com.homeypark.web_service.parkings.domain.model.aggregates.Location;
import com.homeypark.web_service.parkings.interfaces.rest.resources.LocationResource;

public class LocationResourceFromEntityAssembler {
    public static LocationResource toResourceFromEntity(Location entity) {
        return new LocationResource(
                entity.getId(),
                entity.getParking().getId(),
                entity.getAddress(),
                entity.getNumDirection(),
                entity.getLatitude(),
                entity.getLongitude()
        );
    }
}