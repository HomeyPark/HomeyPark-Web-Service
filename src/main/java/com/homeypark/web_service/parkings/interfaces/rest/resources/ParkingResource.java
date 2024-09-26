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
        String district,
        String city,
        String coordinates,
        String typeDirection,
        String numDirection,
        String street,
        String reference,
        String startTime,
        String endTime,
        Long userId
) {
}
