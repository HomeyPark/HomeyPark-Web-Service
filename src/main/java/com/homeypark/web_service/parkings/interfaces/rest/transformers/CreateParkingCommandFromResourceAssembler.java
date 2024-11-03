package com.homeypark.web_service.parkings.interfaces.rest.transformers;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.interfaces.rest.resources.CreateParkingResource;

public class CreateParkingCommandFromResourceAssembler {
    public static CreateParkingCommand toCommandFromResource(CreateParkingResource resource) {
        return new CreateParkingCommand(
                resource.userId(),
                resource.address(),
                resource.width(),
                resource.length(),
                resource.height(),
                resource.price(),
                resource.phone(),
                resource.description(),
                resource.district(),
                resource.city(),
                resource.coordinates(),
                resource.typeDirection(),
                resource.numDirection(),
                resource.street(),
                resource.reference(),
                resource.startTime(),
                resource.endTime()
        );
    }
}
