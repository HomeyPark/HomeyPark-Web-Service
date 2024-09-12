package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record CreateParkingResource(
        String address,
        double width,
        double length,
        double height,
        double price,
        String phone,
        String description,
        double latitude,
        double longitude
) {
}
