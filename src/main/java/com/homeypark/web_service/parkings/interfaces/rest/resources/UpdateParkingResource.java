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
        String street,
        String district,
        String city,
        String coordinates,
        String latitude,
        String longitude) {
}
