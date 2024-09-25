package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateLocationResource(String district,
                                     String city,
                                     String coordinates,
                                     String typeDirection,
                                     String numDirection,
                                     String street,
                                     String reference) {
}
