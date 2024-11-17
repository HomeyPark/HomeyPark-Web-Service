package com.homeypark.web_service.parkings.domain.model.commands;

public record UpdateParkingCommand(
        Long parkingId,
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
