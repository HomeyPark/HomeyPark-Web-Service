package com.homeypark.web_service.parkings.interfaces.rest.resources;

public record LocationResource(
        Long id,
        Long parkingId,
        String address,
        String numDirection,
        Double latitude,
        Double longitude) {
}