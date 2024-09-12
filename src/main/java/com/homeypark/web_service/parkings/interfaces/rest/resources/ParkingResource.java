package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record ParkingResource(
        Long id,
        String address,
        Double width,
        Double length,
        Double height,
        Double price,
        String phone,
        String description,
        Double latitude,
        Double longitude,
        Long userId
) {
}
