package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record CreateParkingResource(
        Long userId,
        double width,
        double length,
        double height,
        double price,
        String phone,
        Integer space,
        String description,
        String address,
        String numDirection,
        Double latitude,
        Double longitude) {
}