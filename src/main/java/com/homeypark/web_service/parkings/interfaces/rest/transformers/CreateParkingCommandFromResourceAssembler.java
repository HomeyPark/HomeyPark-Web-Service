package com.homeypark.web_service.parkings.interfaces.rest.transformers;

import com.homeypark.web_service.parkings.domain.model.commands.CreateParkingCommand;
import com.homeypark.web_service.parkings.interfaces.rest.resources.CreateParkingResource;
import com.homeypark.web_service.user.domain.model.entities.User;

public class CreateParkingCommandFromResourceAssembler {
    public static CreateParkingCommand toCommandFromResource(CreateParkingResource resource) {
        User user = new User();
        user.setId(resource.userId());

        return new CreateParkingCommand(
                resource.address(),
                resource.width(),
                resource.length(),
                resource.height(),
                resource.price(),
                resource.phone(),
                resource.description(),
                resource.latitude(),
                resource.longitude(),
                resource.userId()
        );
    }
}

