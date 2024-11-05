package com.homeypark.web_service.parkings.interfaces.rest.transformers;

import com.homeypark.web_service.parkings.domain.model.commands.UpdateLocationCommand;
import com.homeypark.web_service.parkings.interfaces.rest.resources.UpdateLocationResource;

public class UpdateLocationCommandFromResourceAssembler {
    public static UpdateLocationCommand toCommandFromResource(Long id, UpdateLocationResource resource){
        return new UpdateLocationCommand(id,
                resource.district(),
                resource.city(),
                resource.coordinates(),
                resource.typeDirection(),
                resource.numDirection(),
                resource.street(),
                resource.reference());
    }
}