package com.homeypark.web_service.parkings.domain.model.commands;

public record UpdateLocationCommand (Long locationId,
                                     String district,
                                     String city,
                                     String coordinates,
                                     String typeDirection,
                                     String numDirection,
                                     String street,
                                     String reference){
}