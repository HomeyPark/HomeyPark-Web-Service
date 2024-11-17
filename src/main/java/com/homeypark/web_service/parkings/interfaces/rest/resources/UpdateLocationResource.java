package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateLocationResource(String address,
                                     String numDirection,
                                     Double latitude,
                                     Double longitude) {
}
