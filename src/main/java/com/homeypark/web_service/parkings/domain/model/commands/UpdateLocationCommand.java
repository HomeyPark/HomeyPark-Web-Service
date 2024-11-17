package com.homeypark.web_service.parkings.domain.model.commands;

public record UpdateLocationCommand (Long locationId,
                                     String address,
                                     String numDirection,
                                     Double latitude,
                                     Double longitude){
}