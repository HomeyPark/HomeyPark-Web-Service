package com.homeypark.web_service.parkings.interfaces.rest.transformers;

import com.homeypark.web_service.parkings.domain.model.commands.UpdateParkingCommand;
import com.homeypark.web_service.parkings.interfaces.rest.resources.UpdateParkingResource;

public class UpdateParkingCommandFromResourceAssembler {
    public static UpdateParkingCommand toCommandFromResource(Long id, UpdateParkingResource resource){
        return new UpdateParkingCommand(id,
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
                resource.endTime());
    }
}
