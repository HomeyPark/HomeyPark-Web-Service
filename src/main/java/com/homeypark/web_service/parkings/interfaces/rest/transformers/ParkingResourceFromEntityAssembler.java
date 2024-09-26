package com.homeypark.web_service.parkings.interfaces.rest.transformers;

import com.homeypark.web_service.parkings.domain.model.entities.Parking;
import com.homeypark.web_service.parkings.interfaces.rest.resources.ParkingResource;

public class ParkingResourceFromEntityAssembler {
    public static ParkingResource toResourceFromEntity(Parking entity) {
        return new ParkingResource(
                entity.getId(),
                entity.getAddress(),
                entity.getWidth(),
                entity.getLength(),
                entity.getHeight(),
                entity.getPrice(),
                entity.getPhone(),
                entity.getDescription(),
                entity.getLocation().getDistrict(),
                entity.getLocation().getCity(),
                entity.getLocation().getCoordinates(),
                entity.getLocation().getTypeDirection(),
                entity.getLocation().getNumDirection(),
                entity.getLocation().getStreet(),
                entity.getLocation().getReference(),
                entity.getSchedule().getStartTime(),
                entity.getSchedule().getEndTime(),
                entity.getId()
        );
    }
}
