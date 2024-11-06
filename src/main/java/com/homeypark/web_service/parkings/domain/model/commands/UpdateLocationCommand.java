package com.homeypark.web_service.parkings.domain.model.commands;

public record UpdateLocationCommand (Long locationId,
                                     String address,
                                     String numDirection,
                                     String street,
                                     String district,
                                     String city,
                                     String coordinates,
                                     String latitude,
                                     String longitude){
}