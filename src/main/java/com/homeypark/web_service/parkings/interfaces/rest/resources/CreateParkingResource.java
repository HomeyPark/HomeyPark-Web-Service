package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record CreateParkingResource(
        Long userId,
        double width,
        double length,
        double height,
        double price,
        String phone,
        String space,
        String description,
        String address,
        String numDirection,
        String street,
        String district,
        String city,
        String coordinates,
        String latitude,
        String longitude,
        String day,
        String startTime,
        String endTime
) {
}
