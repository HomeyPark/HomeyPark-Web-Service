package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateLocationResource(String address,
                                     String numDirection,
                                     String street,
                                     String district,
                                     String city,
                                     String coordinates,
                                     String latitude,
                                     String longitude) {
}
