package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record UpdateParkingResource(
        Double width,
        Double length,
        Double height,
        Double price,
        String phone,
        Integer space,
        String description,
        String address,
        String numDirection,
        Double latitude,
        Double longitude) {
}